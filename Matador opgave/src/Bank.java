public class Bank {
  private int balance;

  public Bank(int balance) {

    this.balance = balance;
  }

  public int getBalance() {

    return balance;
  }

  public void depositCash(int cash) {
    balance += cash;
  }

  public boolean withdrawCash(int cash) {

    if (cash <= balance && balance > 0) {
      balance -= cash;
      return true;
    }
    return false;
  }
}
// StartAmountCash = 30.000