import java.util.ArrayList;
import java.util.Scanner;

public class Street extends Ownable {

  public Street(String name, int number, Player player) {
    super(name, number, player);
  }

  @Override
  public void landOnField(Player player, GameBoard gameBoard) {
    this.player = player;
    this.gameBoard = gameBoard;
    ownableProperty(player, 2000, player.getCurrentField(), rent(), gameBoard);
  }

  @Override
  public int rent() {
    if (gameBoard.getOwner(number) != null){
      if (!player.getPlayerName().equals(gameBoard.getOwner(number).getPlayerName())){
        return 1000;
      }
    }
    return 0;
  }

  public String toString() {
    return "\n" + number + ". " + name;
  }
}
