import java.util.ArrayList;

public class GameBoard {

  private ArrayList<Player> players;
  private ArrayList<Field> gameBoardList;
  private ArrayList<Ownable> gameBoardOwnedFieldList;

  public GameBoard() {
    gameBoardList = new ArrayList<>();
    gameBoardList.add(new Refuge("Start", 1));
    gameBoardList.add(new Street("Rødovrevej", 2, null));
    gameBoardList.add(new Refuge("Try your luck", 3));
    gameBoardList.add(new Street("Hvidovrevej", 4, null));
    gameBoardList.add(new Taxes("Income tax", 5));
    gameBoardList.add(new Shipping("Ship 1", 6, null));
    gameBoardList.add(new Street("Roskildevej", 7, null));
    gameBoardList.add(new Refuge("Try your luck", 8));
    gameBoardList.add(new Street("Valby Langgdade", 9, null));
    gameBoardList.add(new Street("Allegade", 10, null));
    gameBoardList.add(new Refuge("Visiting prison", 11));
    gameBoardList.add(new Street("Frederiksberg Alle", 12, null));
    gameBoardList.add(new Brewery("Coca Cola", 13, null));
    gameBoardList.add(new Street("Bülowsvej", 14, null));
    gameBoardList.add(new Street("Gl.Kongevej", 15, null));
    gameBoardList.add(new Shipping("Ship 2", 16, null));
    gameBoardList.add(new Street("Bernstorffsvej", 17, null));
    gameBoardList.add(new Refuge("Try your luck", 18));
    gameBoardList.add(new Street("Hellerupvej", 19, null));
    gameBoardList.add(new Street("Strandvej", 20, null));
    gameBoardList.add(new Refuge("Parking", 21));
    gameBoardList.add(new Street("Tringlen", 22, null));
    gameBoardList.add(new Refuge("Try your luck", 23));
    gameBoardList.add(new Street("Østerbrogade", 24, null));
    gameBoardList.add(new Street("Grønningen", 25, null));
    gameBoardList.add(new Shipping("Ship 3", 26, null));
    gameBoardList.add(new Street("Bredgade", 27, null));
    gameBoardList.add(new Street("Kgs.Nytorv", 28, null));
    gameBoardList.add(new Brewery("Faxe Kondi", 29, null));
    gameBoardList.add(new Street("Østergade", 30, null));
    gameBoardList.add(new Taxes("Go to prison", 31));
    gameBoardList.add(new Street("Amagertorv", 32, null));
    gameBoardList.add(new Street("Vimmelskarftet", 33, null));
    gameBoardList.add(new Refuge("Try your luck", 34));
    gameBoardList.add(new Street("Nygade", 35, null));
    gameBoardList.add(new Shipping("Ship 4", 36, null));
    gameBoardList.add(new Refuge("Try your luck", 37));
    gameBoardList.add(new Street("Frederiksbergade", 38, null));
    gameBoardList.add(new Taxes("State tax", 39));
    gameBoardList.add(new Street("Rådhuspladsen", 40, null));
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }

  public void setPlayers(ArrayList<Player> players) {
    this.players = players;
  }

  public ArrayList<Ownable> gameBoardOwnables() {
    gameBoardOwnedFieldList = new ArrayList<>();
    for (Field field : gameBoardList) {
      if (field instanceof Shipping) {
        gameBoardOwnedFieldList.add((Shipping) field);
      } else if (field instanceof Street) {
        gameBoardOwnedFieldList.add((Street) field);
      } else if (field instanceof Brewery) {
        gameBoardOwnedFieldList.add((Brewery) field);
      }
    }
    return gameBoardOwnedFieldList;
  }

  public Player getOwner(int fieldNumber) {
    Player player = null;
    for (int i = 0; i < gameBoardOwnables().size(); i++) {
      if (gameBoardOwnables().get(i).number == fieldNumber) {
        player = gameBoardOwnables().get(i).player;
      }
    }
    return player;
  }

  public void setGameBoard(int index, Field element) {
    gameBoardList.set(index - 1, element); //invarians
  }

  public String getGameBoard() {
    return gameBoardList.toString();
  }

  public Field getFieldEqualsCurrentField(int fieldNumber) {
    for (int i = 0; i < gameBoardList.size(); i++) {
      if (i == fieldNumber) {
        return gameBoardList.get(i);
      }
    }
    return null;
  }
}
