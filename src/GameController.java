import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameController {
    private Board board;
    private ArrayList<Player> players;
    private ArrayList<Property> properties;

    GameController(ArrayList<Player> players, String settings){
        board = new Board();
        board.buildBoard(settings);
        properties = board.getProperties();

        this.players = players;
    }

    private int rollDice(){
        return new Random().nextInt(6) + 1;
    }

    public String Play(){
        int round = 1, rounds = 1000;
        List<Player> winners = players;
        Player winner;

        while (round <= rounds) {
            for (Player player : players) {

                if (!player.getIsPlaying()) {
                    continue;
                }
                
                player.move(rollDice());                
                Property property = properties.get(player.getPosition() - 1);

                if (property.getOwner() == null) {
                    player.buyProperty(property);            
                } else {
                    int rent = property.getRent();
                    player.payRent(rent);
                    property.getOwner().receive(rent);
                }

            }
            
            winners = players.stream().filter(player -> player.getIsPlaying()).collect(Collectors.toList());
            if (winners.size() == 1) {
                winner = winners.get(0);
                return "Vencedor: " + winner;
            }
            round++;
        }  
        
        int maxCoins = winners.stream().mapToInt(Player::getCoins).max().orElse(0);
        winners = winners.stream().filter(player -> player.getCoins() == maxCoins).collect(Collectors.toList());     
        winner = winners.get(0);

        return "Limite de rodadas, Vencedor por numero de moedas é: " + winner;
    }
}
