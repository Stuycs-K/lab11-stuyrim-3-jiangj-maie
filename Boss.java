public class Boss extends Adventurer{
  private int special;
  private int specialMax = 20;
  private boolean transformed;
  private double healAmp;

  public Boss(){
    this("WereWolf");
  }
  public Boss(String name){
    this(name, 50, 0, false);
  }
  public Boss(String name, int hp, int startingSpecial, boolean isTransformed){
    super(name,hp);
    setSpecial(startingSpecial);
    setTransformed(isTransformed);
    setHealAmp(1.0);
    setmaxHP(50);
  }
  public void setHealAmp(double a){
    healAmp = a;
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
  public double getHealAmp(){
    return healAmp;
  }
  public String attack(Adventurer other){
    if (getTransformed()){
      int healing = (int)(Math.ceil(3 * getHealAmp()));
      other.applyDamage((int)(Math.ceil(6 * getDamageMultiplier())));
      if (getHP() + healing >= getmaxHP()){
        setHP(getmaxHP());
      }else{
        setHP(getHP() + healing);
      }
      restoreSpecial(2);
      return "Bit " + other + " for 6 damage!\n" + getSpecialName() + " increased by" + healing +  "\n HP increased by 3";
    }else{
      int healing = (int)(Math.ceil(1 * getHealAmp()));
      other.applyDamage((int)(Math.ceil(3 * getDamageMultiplier())));
      if (getHP() + healing >= getmaxHP()){
        setHP(getmaxHP());
      }else{
        setHP(getHP() + healing);
      }
      restoreSpecial(1);
      return "Bit " + other + " for 4 damage!\n" + getSpecialName() + " increased by 1\n HP increased by 1";
    }

  }

  //heall or buff the target adventurer
  public String support(Adventurer other){
      return support();
  }

  //heall or buff self
  public String support(){
      if (getTransformed()){
        while (Game.getEnemies().size() < 3){
          Game.addEnemies(new Wolf());
        }
      }else{
        if (Game.getEnemies().size() < 3){
          Game.addEnemies(new Wolf());
        }
      }
      return "Summoned Wolf!";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    if (getTransformed()){
      if (getSpecial() >= 8){
        setSpecial(getSpecial() -8);
        setDamageMultiplier(getDamageMultiplier() * 1.5);
        setHealAmp(getHealAmp() * 1.25);
        return "Howled at the moon! \n" + getSpecialName() + " decreased by 8\n Permanently increased damage by 1.5x, Permanently increased Healing by 1.25";
      }else{
        return "Not enough " + getSpecialName() + " to use Howl";
      }
    }else{
      if (getSpecial() >= 15){
        setSpecial(getSpecial() -15);
        setDamageMultiplier(getDamageMultiplier() * 1.25);
        return "Howled at the moon! \n" + getSpecialName() + " decreased by 8\n Permanently increased damage by 1.5x";
      }else{
        return "Not enough " + getSpecialName() + " to use Howl";
      }
    }
  }
}
