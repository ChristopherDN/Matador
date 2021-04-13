import java.util.ArrayList;

public class Player {
  // -------------------Fields------------------------------------
  private final String playerName;
  private final Bank bank;
  private final RaffleCup raffleCup;
  private int currentFieldNumber;

  private ArrayList<Ownable> ownableList;

  // -------------------get & set----------------------------------

  public String getPlayerName() {

    return playerName;
  }

  public Bank getBank() {
    return bank;
  }

  public RaffleCup getRaffleCup() {

    return raffleCup;
  }

  public void setCurrentField(){
    this.currentFieldNumber += raffleCup.sumOfDice();
    if (this.currentFieldNumber > 40) {
      this.currentFieldNumber -= 40;
    }
  }

  public Field getCurrentField() {
    GameBoard g = new GameBoard();
    Field standingOnField = g.getFieldEqualsCurrentField(currentFieldNumber - 1);
    return standingOnField;
  }

  // --------------------constructor-------------------------------
  public Player(String playerName) {
    this.bank = new Bank(30000);
    this.playerName = playerName;
    this.raffleCup = new RaffleCup();
    this.currentFieldNumber = 1;
    this.ownableList = new ArrayList();
  }

  public String toString() {
    return playerName + " " + bank.getBalance();
  }
}
