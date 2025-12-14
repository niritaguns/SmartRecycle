package es.ulpgc.hpi.p3.smartrecycle.model;

public class EcoUser {

    private String userId;
    private String name;
    private int ecoPoints;
    private boolean isPremium;

    public EcoUser(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.ecoPoints = 0;
        this.isPremium = false;
    }

    public void addEcoPoints(int points) {
        this.ecoPoints += points;
        System.out.println(name + " ha ganado " + points + " EcoPoints. Total: " + this.ecoPoints);
        checkPremiumStatus();
    }

    private void checkPremiumStatus() {
        final int PREMIUM_THRESHOLD = 500;
        if (this.ecoPoints >= PREMIUM_THRESHOLD && !isPremium) {
            this.isPremium = true;
            System.out.println("¡FELICIDADES! " + name + " ha alcanzado el estado PREMIUM (500+ puntos).");
        }
    }

    public String getStatus() {
        String status = isPremium ? "PREMIUM" : "Estándar";
        return name + " (ID: " + userId + ") - Puntos: " + ecoPoints + " - Estatus: " + status;
    }
}


