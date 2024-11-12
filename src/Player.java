import java.util.ArrayList;

public class Player {
    private int position;
    private boolean isPlaying;
    
    protected float coin;
    protected ArrayList<Property> properties;

    Player(){
        this.coin = 300;
        this.position = 0;
        this.isPlaying = true;
        properties = new ArrayList<Property>();
    }

    public int move(int steps){
        this.position += steps;
        
        if (this.position > 20) {
            this.position -= 20;
        }

        return this.position;
    }

    public void receive(float coin){
        this.coin += coin;
    }

    public void payRent(float cost){
        this.coin -= cost;

        if (this.coin < 0) {
            this.lose();
        }
    }

    public void lose(){
        this.isPlaying = false;
            
        for (Property property : properties) {
            property.setOwner(null);
        }

        properties.clear();
    }    
}
