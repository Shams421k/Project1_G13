/*TODO:
- Skapa 3 privata instansvariabler för namn, poäng och dice
- skapa konstruktorn public player (String name) och sparar namnet i instansvariabel
- Skapa public String getName som returnerar namnet
- Skapa int get och void setter för score
- Skapa publoic void addDie(int numberOfSides): Skapa en tärning med new Die(numberOfSides), sparar dden i spelarens variabel die
- Skapa void rollDice som anropar spelarens roll
- Skapa getDieValue som returnerar spelarens poäng
- Skapa increaseScore som ökar poängen med ett


 */

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

    public void rollDice(){
        die.roll();
    }
    public int getDieValue() {
    return die.getValue();
    }

    public void increaseScore() {
    points++;
    }

}   
