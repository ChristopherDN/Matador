public abstract class Field {
  protected String name;
  protected int number;

  public Field(String name, int number) {
    this.name = name;
    this.number = number;
  }

  public abstract void landOnField(Player player, GameBoard gameBoard);
}
