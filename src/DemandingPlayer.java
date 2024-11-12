public class DemandingPlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        float rent = property.getRent();

        if (coin >= cost && rent > 50) {
            coin -= cost;
            property.setOwner(this);
        }
    }
}
