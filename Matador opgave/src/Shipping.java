import java.util.Scanner;

public class Shipping extends Ownable {

  public Shipping(String name, int number, Player player) {
    super(name, number, player);
  }

  @Override
  public void landOnField(Player player, GameBoard gameBoard) {
    this.gameBoard = gameBoard;
    this.player = player;

    ownableProperty(player, 2000, player.getCurrentField(), rent(), gameBoard);
    //simpelt metodekald
  }

  @Override
  public int rent() {

    if (gameBoard.getOwner(number) != null && !player.getPlayerName().equals(gameBoard.getOwner(number).getPlayerName())) {
      int amount = 0;

      for (int i = 0; i < gameBoard.gameBoardOwnables().size(); i++) {

        Ownable fieldId = gameBoard.gameBoardOwnables().get(i);

        if (fieldId instanceof Shipping && fieldId.player != null) {

          for (int j = 0; j < gameBoard.getPlayers().size(); j++) {
            if (fieldId.player.getPlayerName().equals(gameBoard.getPlayers().get(j).getPlayerName())) {
              amount++;
            }
          }
        }
      }

      switch (amount) {
        case 1:
          return 500;
        case 2:
          return 1000;
        case 3:
          return 2000;
        case 4:
          return 4000;
      }
    }

    return 0;
  }

  public String toString() {
    return "\n" + number + ". " + name;
  }
}