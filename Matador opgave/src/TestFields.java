import java.util.ArrayList;
import java.util.Scanner;

public class TestFields {
  public static Scanner scan = new Scanner(System.in);

  public static ArrayList<Player> players;
  public static int numbersOfPlayers; //numberOfPlayer

  public static Player player;
  public static RaffleCup raffleCup;
  public static Bank bank;
  public static Field field;

  public static GameBoard gameBoard = new GameBoard();

  public static void getNumbersOfPlayers() {
    System.out.println("How many players are gonna play?");
    System.out.print("Enter a number here: ");
    numbersOfPlayers = scan.nextInt();
  }

  public static void createPlayerList() {
    players = new ArrayList<>();

    for (int i = 0; i < numbersOfPlayers; i++) {
      System.out.print("Enter a player name: ");
      String playerName = scan.next();
      players.add(new Player(playerName));
    }
    gameBoard.setPlayers(players);
  }

  public static void main(String[] args) {
    getNumbersOfPlayers();
    createPlayerList();

    System.out.println(gameBoard.getGameBoard());

    do {
      for (int i = 0; i < players.size(); i++) {

        //Take the player out from player class
        player = gameBoard.getPlayers().get(i);
        raffleCup = player.getRaffleCup();
        bank = player.getBank();

        field = player.getCurrentField();

        System.out.println();
        System.out.println("It's " + player.getPlayerName() + "'s turn to roll");
        System.out.println("You stand here: " + field.toString());
        System.out.println();
        System.out.print("Enter something to roll: ");
        scan.next();
        raffleCup.shakeDice();
        System.out.println("You rolled " + raffleCup.getDice1() + " & " + raffleCup.getDice2());

        player.setCurrentField();
        field = player.getCurrentField();
        System.out.println("You moved to " + field.toString());

        field.landOnField(player, gameBoard);
        System.out.println("Current balance: " + player.getBank().getBalance());
        System.out.println();
        System.out.println("--------------------------------------");
      }
    } while (bank.getBalance() >= 0);
  }
}
