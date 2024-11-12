public class CautiousPlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        float reserve = coin - cost;

        if (this.coin >= cost && reserve >= 80) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }

}
