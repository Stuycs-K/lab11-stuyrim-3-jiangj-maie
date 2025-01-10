public class Boss extends Adventurer{
  private int special;
  private int specialMax = 20;
  private boolean transformed;

  public Boss(String name){
    super(name);
    setSpecial(0);
    setTransformed(false);
  }
  public Boss(String name, int hp){
    super(name,hp);
    setSpecial(0);
    setTransformed(false);
  }
  public void setTransformed(boolean n){
    transformed = n;
  }
  public String getSpecialName(){
    return "Fury";
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
  public boolean getTransformed(){
    return transformed;
  }
  public String attack(Adventurer other){
    if (getTransformed()){
      other.applyDamage(6);
      setHp(getHP() + 3);
      setSpecial(getSpecial() + 2);
      return "Bit " + other + " for 6 damage!\n" + getSpecialName() + " increased by 2\n HP increased by 3";
    }else{
      other.applyDamage(4);
      setHP(getHP() + 1);
      setSpecial(getSpecial() + 1);
      return "Bit " + other + " for 4 damage!\n" + getSpecialName() + " increased by 1\n HP increased by 1";
    }

  }

  //heall or buff the target adventurer
  public String support(Adventurer other){
      other.setHP(other.getHP() + 10);
      setSpecial(getSpecial()-1);
      return "Shot " + other + " with a Healing Arrow!\n" + "Healed for 10 HP";
  }

  //heall or buff self
  public String support(){
      setSpecial(getSpecial() + 3);
      return "Reloaded!\n" + getSpecialName() + " increased by 3";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    other.applyDamage(getSpecial() * 3);
    setSpecial(0);
    return "Rapid Fire at " + other + " for " + (getSpecial() * 3) + " damage!\n" + "Consumed all " + getSpecialName();
  }
}
