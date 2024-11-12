public class Player {
    protected float coin;
    private int position;

    Player(){
        this.coin = 300;
        this.position = 0;
    }

    public int move(int steps){
        this.position += steps;
        
        if (this.position > 20) {
            this.position -= 20;
        }

        return this.position;
    }

    public void payRent(float cost){
        coin -= cost;
    }
}
