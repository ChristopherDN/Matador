public class Brewery extends Ownable {

  public Brewery(String name, int number, Player player) {
    super(name, number, player);
  }

  @Override
  public void landOnField(Player player, GameBoard gameBoard) {
    this.gameBoard = gameBoard;
    this.player = player;
    ownableProperty(player, 2000, player.getCurrentField(), rent(), gameBoard);
  }

  @Override
  public int rent() {
    RaffleCup raffleCup = new RaffleCup();
    raffleCup.shakeDice();

    int amount = 0;
    if (gameBoard.getOwner(number) != null) {
      if (!player.getPlayerName().equals(gameBoard.getOwner(number).getPlayerName())) {
        for (int i = 0; i < gameBoard.gameBoardOwnables().size(); i++) {

          Ownable field = gameBoard.gameBoardOwnables().get(i);

          if (field instanceof Brewery && field.player != null) {

            for (int j = 0; j < gameBoard.getPlayers().size(); j++) {

              if (field.player.getPlayerName().equals(gameBoard.getPlayers().get(j).getPlayerName())) {
                amount++;
              }
            }
          }
        }

        return amount * (raffleCup.sumOfDice() * 100); //( *antal rederier man i forvejen har*
      }
    }
    return 0;
  }

  public String toString() {
    return "\n" + number + ". " + name;
  }
}
