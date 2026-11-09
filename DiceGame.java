
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till tärningsspelet!");

        // Fråga efter spelarens namn
        System.out.print("Ange ditt namn: ");
        String name = scanner.nextLine();

        // Skapa spelaren
        Player player = new Player(name);

        // Fråga hur många omgångar
        int rounds = 0;
        while (rounds <= 0) {
            System.out.print("Hur många omgångar vill du spela? ");

            if (scanner.hasNextInt()) {
                rounds = scanner.nextInt();

                if (rounds <= 0) {
                    System.out.println("Du måste välja minst 1 omgång.");
                }
            } else {
                System.out.println("Fel! Du måste skriva ett heltal.");
                scanner.next();
            }
        }

        // Fråga hur många sidor tärningen ska ha
        int numberOfSides = 0;
        while (numberOfSides <= 0) {
            System.out.print("Hur många sidor ska tärningen ha? ");

            if (scanner.hasNextInt()) {
                numberOfSides = scanner.nextInt();

                if (numberOfSides <= 0) {
                    System.out.println("Tärningen måste ha minst 1 sida.");
                }
            } else {
                System.out.println("Fel! Du måste skriva ett heltal.");
                scanner.next();
            }
        }


        // Ge spelaren en tärning
        player.addDie(numberOfSides);

        System.out.println("Hej " + player.getName() + "!");
        System.out.println("Nu börjar spelet!");

        for (int i = 1; i <= rounds; i++) {

            System.out.println("\nOmgång " + i);

            
            int guess = 0; // Spelarens gissning börjar på 0

            // Fortsätt fråga tills spelaren skriver ett giltigt tal
            while (guess < 1 || guess > numberOfSides) {

                System.out.print("Gissa ett tal mellan 1 och " + numberOfSides + ": ");

                // Kontrollera om spelaren skriver ett heltal
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();

                    // Kontrollera om talet är inom tärningens gränser
                    if (guess < 1 || guess > numberOfSides) {
                        System.out.println("Fel! Talet måste vara mellan 1 och " + numberOfSides + ".");
                    }

                } else {
                    // Om spelaren skriver bokstäver istället för siffror
                    System.out.println("Fel! Du måste skriva ett heltal.");
                    scanner.next(); // Ta bort den felaktiga inmatningen
                }
            }


            player.rollDice();
            int diceValue = player.getDieValue();

            System.out.println("Tärningen visade: " + diceValue);

            if (guess == diceValue) {
                System.out.println("Rätt gissat! Du får 1 poäng.");
                player.setPoints(player.getPoints() + 1);
            } else {
                System.out.println("Fel gissat!");
            }

            System.out.println("Din poäng: " + player.getPoints());
        }

        System.out.println("\nSpelet är slut!");
        System.out.println(player.getName() + " fick totalt " + player.getPoints() + " poäng.");

        scanner.close();
    }
}
