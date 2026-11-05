/*TODO:
- Importera java.util.Random
- Skapa privata instansvariabler
- Skapa konstruktorn public Die(int numberOfSides) och spara antalet sidor i instansvariablen
- Skapa public int getNumberOfSides() som returnerar antalet sidor
- Skapa public int getValue() som returnerar nuvarande värde
- Skapa public void roll(): Slumba med random.nextInt(numberOfSides) + 1, spara resultat i value
- Tärningen ex. 1 sida - value 1, 6 sidor, value mellan 1 till 6, 10 sidor, value mellan 1 till 10
- Returnerar rätt svar?
 */
import java.util.Random;
public class Die{
    private int value;
    private int numberOfSides;
    private Random r = new Random();

    public Die(int numberOfSides){
        this.numberOfSides = numberOfSides;
    }

    public int getNumberOfSides(){
        return numberOfSides;
    }

    public int getValue(){
        return value;
    }

    //Random värde beroende på sidor, värdet på tärningen startar på 1
    public void roll(){
        value = r.nextInt(numberOfSides) + 1; 
    }
}