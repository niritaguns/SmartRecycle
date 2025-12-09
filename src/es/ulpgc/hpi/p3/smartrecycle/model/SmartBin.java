package es.ulpgc.hpi.p3.smartrecycle.model;

public class SmartBin {
    private String binId;
    private String locationGPS;
    private int  maxCapacityLiters;
    private int currentFillLevel;
    private boolean isFull;


    public SmartBin(String binId, String locationGPS, int maxCapacityLiters){
        this.binId = binId;
        this.locationGPS = locationGPS;
        this.maxCapacityLiters = maxCapacityLiters;
        this.currentFillLevel = 0;
        this.isFull = false;
    }


}
