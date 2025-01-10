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

  public String attack(Adventurer other){
    other.applyDamage(3);
    return "Attacked " + other + " for 3 damage!";
  }

  public String specialAttack(Adventurer other){
    other.applyDamage(10);
    setSpecial(getSpecial() - 10);
    other.setAccuracy(other.getAccuracy() * 0.8);
    return "Sneak attacked " + other + " for 10 damage and deployed a smoke bomb to decrease " + other + "'s accuracy!";
  }

  public String support(){
    setSpecial(getSpecial() + 10);
    return "Practiced meditation and stealth increased by 10!";
  }

  public String support(Adventurer other){
    other.setSpecial(other.getSpecial() + 5);
    return "Threw a recharge shuriken at " + other + " and " + other.getSpecialName() + "increased by 5!";
  }
}
