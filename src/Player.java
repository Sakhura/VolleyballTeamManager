
public class Player {
    private String firstName;
    private String lastName;
    private double attackStats;
    private double blockStats;

    // Constructor
    public Player(String firstName, String lastName, double attackStats, double blockStats) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.attackStats = attackStats;
        this.blockStats = blockStats;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getAttackStats() {
        return attackStats;
    }

    public double getBlockStats() {
        return blockStats;
    }

    // Método toString para mostrar información del jugador
    @Override
    public String toString() {
        return String.format("%-20s Ataque: %.2f  Bloqueo: %.2f",
                getFullName(), attackStats, blockStats);
    }
}