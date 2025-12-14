package es.ulpgc.hpi.p3.smartrecycle.model;

public class SmartRecycleApp {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA SMARTERECYCLE (DEMO P3) ---");

        System.out.println("\n--- DEMO: Participación Ciudadana (EcoPoints) ---");

        EcoUser user1 = new EcoUser("USER_101", "Javier Fernández"); // Grupo de SmartRecycle

        System.out.println(user1.getStatus());

        System.out.println("Simulación: Reciclaje de cartón...");
        user1.addEcoPoints(100);

        System.out.println("Simulación: Reporte de contenedor lleno y reciclaje extra...");
        user1.addEcoPoints(410);

        System.out.println(user1.getStatus());
        System.out.println("------------------------------------------------");

        SmartBin binA = new SmartBin("BIN_A", "28.11,-15.42", 1000);
        SmartBin binB = new SmartBin("BIN_B", "28.11,-15.43", 1000);
        SmartBin binC_NOT_FULL = new SmartBin("BIN_C", "28.12,-15.42", 1000);

        System.out.println("\nContenedores Creados: A, B, y C.");

        SensorData readingA = new SensorData("DATA_A1", binA.getBinId(), 92, 25.0);
        SensorData readingB = new SensorData("DATA_B1", binB.getBinId(), 85, 65.0);
        SensorData readingC = new SensorData("DATA_C1", binC_NOT_FULL.getBinId(), 30, 20.0);

        System.out.println("\n-- PROCESAMIENTO DE DATOS EN TIEMPO REAL --");

        readingA.checkFireRisk();
        binA.updateFillLevel(readingA.getFillLevelReading());


        if (readingB.checkFireRisk()) {
            System.out.println("¡ALERTA CRÍTICA en " + binB.getBinId() + "! (Activación de protocolo de seguridad).");
        }
        binB.updateFillLevel(readingB.getFillLevelReading());

        binC_NOT_FULL.updateFillLevel(readingC.getFillLevelReading());


        CollectionRoute routeMorning = new CollectionRoute("ROUTE_MORN_01", "TRUCK_A");

        System.out.println("\n-- EJECUTANDO ALGORITMO DE OPTIMIZACIÓN --");
        System.out.println("Filtro: Añadir solo contenedores con más del 80% de llenado...");


        if (binA.isFull()) {
            routeMorning.addBinToRoute(binA);
        }
        if (binB.isFull()) {
            routeMorning.addBinToRoute(binB);
        }
        if (binC_NOT_FULL.isFull()) {
            routeMorning.addBinToRoute(binC_NOT_FULL); // Este no se añadirá
        }


        routeMorning.generateRouteSummary();
        System.out.println("\nVerificación: El Contenedor " + binC_NOT_FULL.getBinId() + " no fue incluido (Llenado: " + binC_NOT_FULL.getCurrentFillLevel() + "%)");

        System.out.println("\n--- SISTEMA APAGADO ---");
    }
}