public class ImpulsivePlayer extends Player implements Playable{
    public void buyProperty(Property property){
        float cost = property.getCost();
        
        if (this.coin >= cost) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }
}
