package es.ulpgc.hpi.p3.smartrecycle.model;

import java.time.Instant;

public class SensorData {
    private String dataId;
    private String binId;
    private long timestamp;
    private int fillLevelReading;
    private double temperature;

    public SensorData(String dataId, String binId, int fillLevelReading, double temperature) {
        this.dataId = dataId;
        this.binId = binId;
        this.fillLevelReading = fillLevelReading;
        this.temperature = temperature;
        this.timestamp = Instant.now().getEpochSecond();
    }

    public boolean checkFireRisk() {
        final double MAX_TEMP_CELSIUS = 60.0;

        if (temperature > MAX_TEMP_CELSIUS) {
            System.out.println("ADVERTENCIA: Temperatura anómala (" + temperature + "C) en bin " + binId + ".");
            return true;
        }
        return false;
    }

    public String getBinId() {
        return binId;
    }

    public int getFillLevelReading() {
        return fillLevelReading;
    }

    public double getTemperature() {
        return temperature;
    }

}
