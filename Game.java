import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;
  private static ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
  private static ArrayList<Adventurer> party = new ArrayList<Adventurer>();

  public static ArrayList<Adventurer> getEnemies(){
    return enemies;
  }
  public static void addEnemies(Adventurer a){
    enemies.add(a);
  }
  public static ArrayList<Adventurer> getParty(){
    return party;
  }

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    //outer borders
    for (int row = 1; row < 31; row++) {
      for (int column = 1; column < 81; column++) {
        if ((row == 1 || row == 30) || (column == 1 || column == 80)) {
          Text.go(row, column);
          System.out.print(Text.colorize(".", Text.WHITE));
        }
      }
    }
    //inner horizontal borders
    for (int column = 1; column < 81; column++) {
      for (int row = 1; row < 31; row++) {
        if (row == 5 || row == 23 || row == 27) {
          Text.go(row, column);
          System.out.print(Text.colorize(".", Text.WHITE));
        }
      }
    }
    //inner vertical borders
    for (int row = 2; row < 5; row++) {
      for (int column = 81/3; column < 81; column += (81/3)) {
        Text.go(row, column);
        System.out.print(Text.colorize(".", Text.WHITE));
      }
    }
    for (int row = 24; row < 27; row++) {
      for (int column = 81/3; column < 81; column += (81/3)) {
        Text.go(row, column);
        System.out.print(Text.colorize(".", Text.WHITE));
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    for (int i = 0; i < height; i++){
      Text.go(row + i, col);
      String temp = "";
      if (text.length() > width) {
        System.out.print(text.substring(0, width + 1));
        text = text.substring(width + 1, width * 2 + 1);
      }
      else if (text.length() <= width) {
          for (int j = 0; j < width - text.length(); j++){
            temp += " ";
          }
          System.out.print(text + (temp));
          text = "";
        }
      else if (text == "") {
          for (int j = 0; j < width; j++){
            temp += " ";
          }
          System.out.print(temp ); 
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      String[] adventurers = {"Archer", "Ninja", "CodeWarrior"};
        String rand = adventurers[(int) (Math.random() * 3)];
        if(rand.equals("Archer")){
          return new Archer();
        }
        else if(rand.equals("Ninja")){
          return new Ninja();
        }
        else {
          return new CodeWarrior();
        }
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){// modify to make it work with size less than 3
      if (party.size() > 0){
        for (int i = 0; i < party.size(); i++) {
          int column = 2 + (81/3) * i;
          String nameText = party.get(i) + "";
          String HPText = "HP: " + colorByPercent(party.get(i).getHP(),party.get(i).getmaxHP());
          String specialText = party.get(i).getSpecialName() + ": "+ party.get(i).getSpecial();
          drawText(nameText, startRow, column);
          drawText(HPText, startRow + 1, column);
          drawText(specialText, startRow + 2, column);
        }
      }
    }



  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    double percent = (double)hp / maxHP * 100.0;
    if (percent < 25) {
      return Text.colorize(output, Text.RED);
    }
    else if (percent < 75) {
      return Text.colorize(output, Text.YELLOW);
    }
    else {
      return Text.colorize(output, Text.WHITE);
    }
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    
  }




  public static void drawHistory(String allHistory){
    String[] history = allHistory.split("\n");
    // String displayed = "";
    int startingIndex = 0;
    if (history.length > 17){
      startingIndex = history.length - 17;
    }
    int row = 6;
    for (int i = startingIndex; i < history.length; i ++){
      drawText(history[i], row ,2);
      row++;
    }
    // TextBox(7, 2, 78, 17, displayed);
  }
  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(){

    drawBackground();

    //draw player party
    drawParty(party, 24);
    

    //draw enemy party
    drawParty(enemies, 2);
  }
  

  public static String userInput(Scanner in){
      //Move cursor to prompt location

      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }
  public static ArrayList<Adventurer> generateRandomParty(int size){
    ArrayList<Adventurer> randParty = new ArrayList<Adventurer>();
    for (int i = 0; i < size; i++){
      randParty.add(createRandomAdventurer());
    }
    return randParty;
  }
  public static String enemyEngine(Adventurer enemy){
    String[] arr = {"a", "sp", "su"};
    int randIndex = (int) (Math.random()*3);
    int randSlot = (int) (Math.random() * getParty().size());
    String move = arr[randIndex];
    if (move.equals("a")){
      return enemy.attack(getParty().get(randSlot));
    }else if (move.equals("sp")){
      return enemy.specialAttack(getParty().get(randSlot));
    }else if (move.equals("su")) {
      return enemy.support(getParty().get(randSlot));
    }
    return "something went wrong with enemyEngine";
  }
  

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){


    Scanner in = new Scanner(System.in);
    String input = "";
    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.


    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.

    for (int i = 0; i < 3; i++){ // loop to add 3 allies
      String partyPreprompt = "Draft a player to add to your party: (A)rcher, (N)inja, (C)odeWarrior, (R)andom";
      System.out.println(partyPreprompt);
      input = userInput(in);
      if(input.equals("Archer") || input.equals("A")){
        party.add(new Archer());
      }
      else if(input.equals("Ninja") || input.equals("N")){
        party.add(new Ninja());
      }
      else if(input.equals("CodeWarrior") || input.equals("C")){
        party.add(new CodeWarrior());
      }
      else if(input.equals("Random") || input.equals("R")){
        party = generateRandomParty(3);
        break;
      }
      else{
        System.out.println("Invalid Input!");
        i--;
      }


    }

    for (int i = 0; i < 3; i++){ // loop to add 3 enemies or boss
      String enemyPreprompt = "Draft an enemy to add to the enemy team: (A)rcher, (N)inja, (C)odeWarrior, (R)andom, (B)oss";
      System.out.println(enemyPreprompt);
      input = userInput(in);
      if(input.equals("Archer") || input.equals("A")){
        enemies.add(new Archer());
      }
      else if(input.equals("Ninja") || input.equals("N")){
        enemies.add(new Ninja());
      }
      else if(input.equals("CodeWarrior") || input.equals("C")){
        enemies.add(new CodeWarrior());
      }
      else if(input.equals("Random") || input.equals("R")){
        enemies = generateRandomParty(3);
        break;
      }else if(input.equals("Boss") || input.equals("B")){
        enemies = new ArrayList<Adventurer>();
        enemies.add(new Boss());
        break;
      }
      else{
        System.out.println("Invalid Input!");
        i--;
      }


    }
    //Clear and initialize
    Text.hideCursor();
    Text.clear();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    input = "";//blank to get into the main loop.

    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen();//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String moveHistory = "";
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      drawScreen();
      drawText(preprompt, 28, 2);
      //Read user input
      drawText(">", 29, 2);
      input = userInput(in);

      //example debug statment: readd later
      TextBox(1, 2, 78, 17," partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );
      if (getParty().size() == 0){
          System.out.println("Your party has been defeated!");
          break;
      }else if (getEnemies().size() == 0){
        System.out.println("You defeated your enemies! You Win!");
        break;
      }
      String partyMove = "";
      //display event based on last turn's input
      if(partyTurn){
        
        //Process user input for the last Adventurer:
        if(input.startsWith("a ") || input.startsWith("attack ")){
          String[] attackInput = input.split(" ");
          partyMove = party.get(whichPlayer).attack(enemies.get(Integer.parseInt(attackInput[1]))) + "\n\n";
        }
        else if(input.startsWith("sp ") || input.startsWith("special ")){
          String[] specialInput = input.split(" ");
          partyMove = party.get(whichPlayer).specialAttack(enemies.get(Integer.parseInt(specialInput[1]))) + "\n\n";
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          String[] supportInput = input.split(" ");
          if (Integer.parseInt(supportInput[1]) == whichPlayer){
            partyMove = party.get(whichPlayer).support() + "\n\n";
          }else{
            partyMove = party.get(whichPlayer).support(getParty().get(Integer.parseInt(supportInput[1]))) + "\n\n";
          }
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        for (int i = 0; i < getEnemies().size(); i++){
          if (getEnemies().get(i).getHP() <= 0){
            moveHistory += getEnemies().get(i) + " has been slain! \n\n";
            getEnemies().remove(i);
            i--;
          }
        }
        
        moveHistory += partyMove;
        drawHistory(moveHistory);
        drawScreen();
        // Text.go(15, 2);
        // System.out.print(partyMove);

        whichPlayer++;
        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!
        Adventurer currentOpponent = getEnemies().get(whichOpponent);
        if (currentOpponent instanceof Boss && turn == 2){
          getEnemies().set(whichOpponent, new Boss("Transformed WereWolf", currentOpponent.getHP() + 10, currentOpponent.getSpecial(), true));
          moveHistory += "It's a full moon outside. \n WereWolf transformed and healed 10 HP\n\n";
          // Text.go(15, 2);
          // System.out.print("It's a full moon outside. \n WereWolf transformed and healed 10 HP");
          
          drawHistory(moveHistory);
          drawScreen();
          
        }
        // Text.go(15, 2);
        // System.out.print(enemyEngine(currentOpponent));
        // check if party member gets killed
        moveHistory += enemyEngine(currentOpponent) + "\n\n";
        for (int i = 0; i < getParty().size(); i++){
          if (getParty().get(i).getHP() <= 0){
            moveHistory += getParty().get(i) + " has been slain! \n\n";
            getParty().remove(i);
            i--;
          }
        }
        
        drawHistory(moveHistory);
        drawScreen();
       
        

        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      
      drawScreen();


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
