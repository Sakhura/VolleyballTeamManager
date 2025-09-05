import java.io.*;
import java.util.*;

/**
 * Programa para gestionar equipos de voleibol Verde Valley
 */
public class VolleyballTeamManager {
    private ArrayList<Player> players;
    private Scanner scanner;
    private boolean playersLoaded;

    public VolleyballTeamManager() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
        playersLoaded = false;
    }

    public static void main(String[] args) {
        VolleyballTeamManager manager = new VolleyballTeamManager();
        manager.run();
    }


    public void run() {
        System.out.println("=== Verde Valley Volleyball Team Manager ===");

        int choice;
        do {
            showMenu();
            choice = getMenuChoice();
            processChoice(choice);
        } while (choice != 5);

        System.out.println("¡Gracias por usar Verde Valley Volleyball Team Manager!");
        scanner.close();
    }

    /**
     * Muestra el menú principal
     */
    private void showMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Abrir una lista de jugadores");
        System.out.println("2. Mostrar los 3 mejores atacantes");
        System.out.println("3. Mostrar los 3 mejores bloqueadores");
        System.out.println("4. Crear y mostrar equipos de práctica");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción (1-5): ");
    }

    /**
     * Obtiene la elección del usuario del menú
     */
    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0; // Valor inválido
        }
    }

    /**
     * Procesa la elección del usuario
     */
    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                loadPlayerList();
                break;
            case 2:
                showTopAttackers();
                break;
            case 3:
                showTopBlockers();
                break;
            case 4:
                createPracticeTeams();
                break;
            case 5:
                break;
            default:
                System.out.println("Opción inválida. Por favor selecciona 1-5.");
        }
    }

    /**
     * Carga la lista de jugadores desde un archivo
     */
    private void loadPlayerList() {
        System.out.print("Ingresa el nombre del archivo: ");
        String filename = scanner.nextLine();

        try {
            players.clear();

            // Intentar buscar en múltiples ubicaciones
            File file = null;

            // Primero intentar en la raíz del proyecto
            file = new File(filename);
            if (!file.exists()) {
                // Si no existe, intentar en src/
                file = new File("src/" + filename);
            }
            if (!file.exists()) {
                // Si no existe, intentar ruta relativa desde out/
                file = new File("../" + filename);
            }

            if (!file.exists()) {
                throw new FileNotFoundException("No se encontró el archivo en las ubicaciones esperadas");
            }

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    parsePlayerLine(line);
                }
            }

            fileScanner.close();
            playersLoaded = true;
            System.out.println("¡Lista de jugadores cargada exitosamente!");
            System.out.println("Total de jugadores: " + players.size());

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo encontrar el archivo '" + filename + "'");
            System.out.println("Ubicaciones buscadas: ./, src/, ../");
            playersLoaded = false;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            playersLoaded = false;
        }
    }

    /**
     * Parsea una línea del archivo para crear un jugador
     */
    private void parsePlayerLine(String line) {
        String[] parts = line.split("\\s+");
        if (parts.length >= 4) {
            String firstName = parts[0];
            String lastName = parts[1];
            double attackStats = Double.parseDouble(parts[2]);
            double blockStats = Double.parseDouble(parts[3]);

            players.add(new Player(firstName, lastName, attackStats, blockStats));
        }
    }

    /**
     * Muestra los 3 mejores atacantes
     */
    private void showTopAttackers() {
        if (!checkPlayersLoaded()) return;

        System.out.println("\n=== 3 MEJORES ATACANTES ===");

        // Crear copia de la lista y ordenar por estadísticas de ataque (descendente)
        ArrayList<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort((p1, p2) -> Double.compare(p2.getAttackStats(), p1.getAttackStats()));

        int count = Math.min(3, sortedPlayers.size());
        for (int i = 0; i < count; i++) {
            Player player = sortedPlayers.get(i);
            System.out.printf("%d. %s - Estadísticas de ataque: %.2f%n",
                    i + 1, player.getFullName(), player.getAttackStats());
        }
    }

    /**
     * Muestra los 3 mejores bloqueadores
     */
    private void showTopBlockers() {
        if (!checkPlayersLoaded()) return;

        System.out.println("\n=== 3 MEJORES BLOQUEADORES ===");

        // Crear copia de la lista y ordenar por estadísticas de bloqueo (descendente)
        ArrayList<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort((p1, p2) -> Double.compare(p2.getBlockStats(), p1.getBlockStats()));

        int count = Math.min(3, sortedPlayers.size());
        for (int i = 0; i < count; i++) {
            Player player = sortedPlayers.get(i);
            System.out.printf("%d. %s - Estadísticas de bloqueo: %.2f%n",
                    i + 1, player.getFullName(), player.getBlockStats());
        }
    }

    /**
     * Crea y muestra equipos de práctica equilibrados
     */
    private void createPracticeTeams() {
        if (!checkPlayersLoaded()) return;

        int totalPlayers = players.size();
        int teamsCount = totalPlayers / 6; // 6 jugadores por equipo

        if (teamsCount == 0) {
            System.out.println("No hay suficientes jugadores para formar equipos (mínimo 6).");
            return;
        }

        System.out.println("\n=== EQUIPOS DE PRÁCTICA ===");
        System.out.printf("Jugadores totales: %d\n", totalPlayers);
        System.out.printf("Equipos a formar: %d\n", teamsCount);

        // Crear listas separadas para atacantes y bloqueadores
        ArrayList<Player> attackersSorted = new ArrayList<>(players);
        attackersSorted.sort((p1, p2) -> Double.compare(p2.getAttackStats(), p1.getAttackStats()));

        // Crear equipos
        ArrayList<ArrayList<Player>> teams = new ArrayList<>();
        for (int i = 0; i < teamsCount; i++) {
            teams.add(new ArrayList<>());
        }

        // Distribuir mejores atacantes (primera mitad de cada equipo)
        distributeTopPlayers(teams, attackersSorted, 3); // 3 atacantes por equipo

        // Crear lista de jugadores restantes y ordenar por bloqueo
        Set<Player> assignedPlayers = new HashSet<>();
        for (ArrayList<Player> team : teams) {
            assignedPlayers.addAll(team);
        }

        ArrayList<Player> remainingPlayers = new ArrayList<>();
        for (Player player : players) {
            if (!assignedPlayers.contains(player)) {
                remainingPlayers.add(player);
            }
        }

        remainingPlayers.sort((p1, p2) -> Double.compare(p2.getBlockStats(), p1.getBlockStats()));

        // Distribuir mejores bloqueadores (segunda mitad de cada equipo)
        distributeTopPlayers(teams, remainingPlayers, 3); // 3 bloqueadores por equipo

        // Mostrar equipos
        displayTeams(teams);
    }

    /**
     * Distribuye jugadores de manera equilibrada entre equipos
     */
    private void distributeTopPlayers(ArrayList<ArrayList<Player>> teams,
                                      ArrayList<Player> sortedPlayers, int playersPerTeam) {
        int teamIndex = 0;
        int playersAssigned = 0;

        for (Player player : sortedPlayers) {
            if (teams.get(teamIndex).size() < (playersPerTeam * 2)) { // Máximo 6 por equipo
                teams.get(teamIndex).add(player);
                playersAssigned++;

                if (playersAssigned % playersPerTeam == 0) {
                    teamIndex = (teamIndex + 1) % teams.size();
                }

                if (playersAssigned >= teams.size() * playersPerTeam) {
                    break;
                }
            }
        }
    }

    /**
     * Equipos formados
     */
    private void displayTeams(ArrayList<ArrayList<Player>> teams) {
        for (int i = 0; i < teams.size(); i++) {
            System.out.printf("\nEquipo %d:\n", i + 1);
            ArrayList<Player> team = teams.get(i);

            for (Player player : team) {
                System.out.println("  " + player);
            }

            // Calcular promedios del equipo
            double avgAttack = team.stream().mapToDouble(Player::getAttackStats).average().orElse(0.0);
            double avgBlock = team.stream().mapToDouble(Player::getBlockStats).average().orElse(0.0);

            System.out.printf("  Promedio - Ataque: %.2f, Bloqueo: %.2f\n", avgAttack, avgBlock);
        }
    }

    /**
     * Aca se verifica si se han cargado jugadores
     */
    private boolean checkPlayersLoaded() {
        if (!playersLoaded || players.isEmpty()) {
            System.out.println("Por favor, abre una lista de jugadores.");
            return false;
        }
        return true;
    }
}