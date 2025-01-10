public class Ninja extends Adventurer{
  private int stealth;
  private int stealthMax;

  public Ninja(String name, int hp){
    super(name, hp);
    stealth = 5;
    stealthMax = 10;
  }

  public Ninja(String name){
    this(name, 15);
  }

  public Ninja(){
    this("Adonis");
  }

  public String getSpecialName(){
    return "Stealth";
  }

  public int getSpecial(){
    return stealth;
  }

  public void setSpecial(int n){
    stealth = n;
  }

  public int getSpecialMax(){
    return stealthMax;
  }

}