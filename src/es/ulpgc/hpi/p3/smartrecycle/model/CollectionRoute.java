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
}
