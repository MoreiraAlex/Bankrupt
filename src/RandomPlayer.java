import java.util.Random;

public class RandomPlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        boolean buy = new Random().nextBoolean();
        
        if (coin >= cost && buy) {
            coin -= cost;
            property.setOwner(this);
        }
    }

}
