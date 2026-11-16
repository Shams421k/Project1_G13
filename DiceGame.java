
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        clearScreen();

        System.out.println("================================");
        System.out.println("         TÄRNINGSSPELET");
        System.out.println("================================");

        // Fråga efter spelarens namn
        System.out.print("Ange ditt namn: ");
        String name = scanner.nextLine();

        Player player = new Player(name);

        clearScreen();

        // Fråga hur många omgångar
        int rounds = 0;

        while (rounds <= 0) {
            System.out.print("Hur många omgångar vill du spela? ");

            if (scanner.hasNextInt()) {
                rounds = scanner.nextInt();

                if (rounds <= 0) {
                    System.out.println("Fel! Välj minst 1 omgång.");
                }
            } else {
                System.out.println("Fel! Skriv ett heltal.");
                scanner.next();
            }
        }

        clearScreen();

        // Fråga hur många sidor tärningen ska ha
        int numberOfSides = 0;

        while (numberOfSides <= 0) {
            System.out.print("Hur många sidor ska tärningen ha? ");

            if (scanner.hasNextInt()) {
                numberOfSides = scanner.nextInt();

                if (numberOfSides <= 0) {
                    System.out.println("Fel! Välj minst 1 sida.");
                }
            } else {
                System.out.println("Fel! Skriv ett heltal.");
                scanner.next();
            }
        }

        player.addDie(numberOfSides);

        // Ta bort kvarvarande radbrytning
        scanner.nextLine();

        // Starta spelet
        for (int i = 1; i <= rounds; i++) {

            clearScreen();

            System.out.println("================================");
            System.out.println("         TÄRNINGSSPELET");
            System.out.println("================================");
            System.out.println("Spelare : " + player.getName());
            System.out.println("Omgång  : " + i + " av " + rounds);
            System.out.println("Poäng   : " + player.getPoints());
            System.out.println();
            System.out.println("---------- OMGÅNG " + i + " ----------");
            System.out.println();

            int guess = 0;

            // Kontrollera spelarens gissning
            while (guess < 1 || guess > numberOfSides) {

                System.out.print("Gissa ett tal mellan 1 och "
                        + numberOfSides + ": ");

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();

                    if (guess < 1 || guess > numberOfSides) {
                        System.out.println("Fel! Talet måste vara mellan 1 och "
                                + numberOfSides + ".");
                    }
                } else {
                    System.out.println("Fel! Skriv ett heltal.");
                    scanner.next();
                }
            }

            // Kasta tärningen
            player.rollDice();
            int diceValue = player.getDieValue();

            System.out.println();
            System.out.println("------------ RESULTAT ------------");
            System.out.println("Din gissning      : " + guess);
            System.out.println("Tärningen visade  : " + diceValue);
            System.out.println();

            // Kontrollera resultatet
                if (guess == diceValue) {
                player.increaseScore();
                System.out.println("*** RÄTT GISSAT! +1 POÄNG ***");
            } else {
                System.out.println("--- FEL GISSAT! ---");
}

            System.out.println();
            System.out.println("Total poäng: " + player.getPoints());
            System.out.println("----------------------------------");

            // Vänta innan nästa omgång
            scanner.nextLine();

            if (i < rounds) {
                System.out.println();
                System.out.print("Tryck Enter för nästa omgång...");
            } else {
                System.out.println();
                System.out.print("Tryck Enter för slutresultatet...");
            }

            scanner.nextLine();
        }

        clearScreen();

        // Visa slutresultatet
        System.out.println("================================");
        System.out.println("           SPELET SLUT!");
        System.out.println("================================");
        System.out.println();
        System.out.println("Spelare       : " + player.getName());
        System.out.println("Antal omgångar: " + rounds);
        System.out.println("Slutpoäng     : " + player.getPoints());
        System.out.println();
        System.out.println("================================");

        scanner.close();
    }

    // Rensa terminalen
    public static void clearScreen() {

        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {

                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();

            } else {
                System.out.print("\033[H\033[2J\033[3J");
                System.out.flush();
            }

        } catch (Exception e) {
            // Reservlösning om rensning inte fungerar
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
