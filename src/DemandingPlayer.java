public class DemandingPlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        float rent = property.getRent();

        if (this.coin >= cost && rent > 50) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }
}
