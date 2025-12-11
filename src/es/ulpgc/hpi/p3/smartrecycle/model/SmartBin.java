package es.ulpgc.hpi.p3.smartrecycle.model;

public class SmartBin {
    private String binId;
    private String locationGPS;
    private int maxCapacityLiters;;
    private int currentFillLevel;
    private boolean isFull;


    public SmartBin(String binId, String locationGPS, int maxCapacityLiters){
        this.binId = binId;
        this.locationGPS = locationGPS;
        this.maxCapacityLiters = maxCapacityLiters;
        this.currentFillLevel = 0;
        this.isFull = false;
    }
    public void updateFillLevel(int newFillLevel){
        final int FULL_THRESHOLD = 80;

        this.currentFillLevel = newFillLevel;

        if (newFillLevel > FULL_THRESHOLD) {
            this.isFull = true;
            System.out.println("ALERTA: Contenedor " + binId + " está lleno (" + newFillLevel + "%) y necesita recogida.");
        } else {
            this.isFull = false;
        }
    }

    public String getBinId() {
        return binId;
    }

    public int getCurrentFillLevel() {
        return currentFillLevel;
    }

    public boolean isFull() {
        return isFull;
    }
}
