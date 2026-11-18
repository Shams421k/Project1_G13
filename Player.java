
public class Player {
    private String name;
    private int points;
    private Die die;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void addDie(int numberOfSides){
        this.die = new Die(numberOfSides);
    }
    //Spelaren kastar tärningen
    public void rollDice(){
        die.roll();
    }
    //Tärningens värde returnerar
    public int getDieValue() {
    return die.getValue();
    }
    //Spelarens poäng ökar med 1
    public void increaseScore() {
    points++;
    }

}   
