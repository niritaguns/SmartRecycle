package es.ulpgc.hpi.p3.smartrecycle.model;
import java.util.ArrayList;
import java.util.List;
public class CollectionRoute {
    private String routeId;
    private String truckId;
    private List<SmartBin> binsToCollect;
    private double estimatedDistanceKM;

    public CollectionRoute(String routeId, String truckId) {
        this.routeId = routeId;
        this.truckId = truckId;
        this.binsToCollect = new ArrayList<>();
        this.estimatedDistanceKM = 0.0;
    }

    public void addBinToRoute(SmartBin bin) {
        this.binsToCollect.add(bin);
        recalculateDistance();
        System.out.println("-> Contenedor " + bin.getBinId() + " añadido a la Ruta " + routeId);
    }

    private void recalculateDistance() {
        this.estimatedDistanceKM = this.binsToCollect.size() * 2.5;
    }

    public void generateRouteSummary() {
        System.out.println("\n--- Resumen de la Ruta: " + routeId + " ---");
        System.out.println("Camión Asignado: " + truckId);
        System.out.println("Contenedores a Recoger: " + binsToCollect.size());
        System.out.println("Distancia Total Estimada: " + estimatedDistanceKM + " KM");

        System.out.print("Lista de Bins: ");
        for (SmartBin bin : binsToCollect) {
            System.out.print(bin.getBinId() + " (" + bin.getCurrentFillLevel() + "%); ");
        }
        System.out.println();
    }

    public double getEstimatedDistanceKM() {
        return estimatedDistanceKM;
    }
}
