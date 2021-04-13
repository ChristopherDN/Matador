public class Refuge extends Field{
  private final int bonusCashAmount = 1000;


  public Refuge(String name, int number) {
    super(name, number);
  }

  @Override
  public void landOnField(Player player, GameBoard gameBoard) {

    player.getBank().depositCash(bonusCashAmount);
  }

  public String toString() {

    return "\n" + number + ". " + name;
  }
}
