public class Wolf extends Adventurer{
  private int special = 0;
  private int specialMax = 10;
  public Wolf(){
    this("Wolf", 3);
  }
  public Wolf(String name){
      this(name, 3);
  }

  public Wolf(String name, int hp){
      super(name,hp);
  }

  public String getSpecialName(){
    return "Nothing";
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
    other.applyDamage(2);
    return "Chomped " + other + " for 2 damage!\n";
  }

  //heall or buff the target adventurer
  public String support(Adventurer other){
      return attack(other);
  }

  //heall or buff self
  public String support(){
      return support(Game.getParty().get((int)(Math.random()*3)));
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    return attack(other);
  }
}
