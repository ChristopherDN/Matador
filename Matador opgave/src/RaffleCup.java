import java.util.Random;

public class RaffleCup {

  private  int dice1;
  private  int dice2;

  public int getDice1() {
    return dice1;
  }

  public int getDice2() {
    return dice2;
  }

  public void shakeDice() {
    Random random = new Random();
    dice1 = random.nextInt(6) + 1;
    dice2 = random.nextInt(6) + 1;
  }

  public int sumOfDice() {
    return dice1 + dice2;
  }

  public boolean isDiceEqual() {
    if (dice1 == dice2) {
      return true;
    }
    return false;
  }
}
