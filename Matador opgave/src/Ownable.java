import java.util.Scanner;

public abstract class Ownable extends Field {

  protected Player player;
  protected GameBoard gameBoard;

  public Ownable(String name, int number, Player player) {
    super(name, number);
    this.player = player;
  }

  public abstract int rent();

  public void ownableProperty(Player player, int cost, Field field, int rent, GameBoard gameBoard) {
    Scanner scan = new Scanner(System.in);
    this.player = player;

    if (gameBoard.getOwner(number) == null) {

      System.out.print("Do you want to buy the property?: ");
      String input = scan.next();

      while (!(input.equals("yes") || input.equals("no"))) { // validering af input
        System.out.println("Enter yes or no");
        input = scan.nextLine();
      }

      if (input.equals("yes")) {
        player.getBank().withdrawCash(cost);

        if (field instanceof Shipping) {
          gameBoard.setGameBoard(number, new Shipping(name, number, player));
        } else if ( field instanceof Street) {
          gameBoard.setGameBoard(number, new Street(name, number, player));
        } else if (field instanceof Brewery) {
          gameBoard.setGameBoard(number, new Brewery(name, number, player));
        }
      }

    } else {

      System.out.println("Property is owned.");
      System.out.println("You have to pay: " + rent + " in rent.");
      player.getBank().withdrawCash(rent);

    }
  }

}
