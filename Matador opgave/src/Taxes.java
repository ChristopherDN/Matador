public class Taxes extends Field {

  public Taxes(String name, int number) {

    super(name, number);
  }

  @Override
  public void landOnField(Player player, GameBoard gameBoard) {

    int tax;
    Field playerField = player.getCurrentField();
    if (playerField.number == 5) {
      tax = 4000;
      System.out.println("You've landed on " + playerField.name +  " and owe: " + tax + " in taxes!");
      player.getBank().withdrawCash(tax);
    } else if (playerField.number == 39) {
      tax = 2000;
      System.out.println("You've landed on " + playerField.name + " and owe: " + tax + " in taxes!");
      player.getBank().withdrawCash(tax);
    } else if (playerField.number == 31) {  // Christopher ide at lave den til en tax, da det ikke skal være gratis at komme i fængsel.
      tax = 1000;
      System.out.println("You're going to prison : " + tax + " in taxes!");
      player.getBank().withdrawCash(tax);
    }
  }

  public String toString() {
    return "\n" + number + ". " + name;
  }
}
