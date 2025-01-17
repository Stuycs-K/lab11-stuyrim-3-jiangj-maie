public class Archer extends Adventurer{
  private int special = 0;
  private int specialMax = 10;
  public Archer(){
    this("Joe", 20);
  }
  public Archer(String name){
      super(name);
      setSpecial(3);
  }

  public Archer(String name, int hp){
      super(name + " the Archer",hp);
      setSpecial(3);
  }

  public String getSpecialName(){
    return "Ammo";
  }
  //accessor methods
  public int getSpecial(){
    return special;
  }
  public void setSpecial(int n){
    special = n;
  }
  public int getSpecialMax(){
    return specialMax;
  }
  public String attack(Adventurer other){
    other.applyDamage(5);
    setSpecial(getSpecial() - 1);
    return this + " attacked " + other + " for 5 damage!\n" + getSpecialName() + " reduced by 1";
  }

  //heall or buff the target adventurer
  public String support(Adventurer other){
      other.setHP(other.getHP() + 10);
      setSpecial(getSpecial()-1);
      return this + " shot " + other + " with a Healing Arrow!\n" + "Healed for 10 HP";
  }

  //heall or buff self
  public String support(){
      setSpecial(getSpecial() + 3);
      return this + " reloaded!\n" + getSpecialName() + " increased by 3";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    int temp = getSpecial() * 3;
    other.applyDamage(temp);
    setSpecial(0);
    return this + " Rapid Fired at " + other + " for " + temp + " damage!\n" + "Consumed all " + getSpecialName();
  }
}
