
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
        System.out.print("Hur många omgångar vill du spela? ");
        int rounds = scanner.nextInt();

        // Fråga hur många sidor tärningen ska ha
        System.out.print("Hur många sidor ska tärningen ha? ");
        int numberOfSides = scanner.nextInt();

        // Ge spelaren en tärning
        player.addDie(numberOfSides);

 System.out.println("Hej " + player.getName() + "!");
        System.out.println("Nu börjar spelet!");

        for (int i = 1; i <= rounds; i++) {

            System.out.println("\nOmgång " + i);

            System.out.print("Gissa ett tal mellan 1 och " + numberOfSides + ": ");
            int guess = scanner.nextInt();

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
