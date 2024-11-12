public class ImpulsivePlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        
        if (coin >= cost) {
            coin -= cost;
            property.setOwner(this);
        }
    }
}
