
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

    //Random värde mellan ett och antal sidor
    public void roll(){
        value = r.nextInt(numberOfSides) + 1; 
    }
}