public class CautiousPlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        float reserve = coin - cost;

        if (coin >= cost && reserve >= 80) {
            coin -= cost;
            property.setOwner(this);
        }
    }

}
