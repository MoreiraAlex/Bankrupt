import java.util.Random;

public class RandomPlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        boolean buy = new Random().nextBoolean();
        
        if (this.coin >= cost && buy) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }

}
