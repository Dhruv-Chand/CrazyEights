/*
  Dhruv, Jathushan, and Harshaan
  04/06/2021
  Gamepage Code
  This file contains all the java code that is needed in the game. 
*/
/****WORKERS COMMENTS***/
/*Harshaan Mahendran 2021-03-24 4:45pm Working on basic title screen and navigation code*/
/*Jathushan Vishnukaran 2021-03-25 5:00pm Working on basic algorithm*/
/*Harshaan Mahendran 2021-03-25 6:30pm Working on game algorithm and navigation code*/
/*Dhruv Chand 2021-03-25 7:00pm Working on creating highscores page and game code*/
/*Harshaan Mahendran 2021-03-26 11:18am Working on game algorithm*/
/*Harshaan Mahendran 2021-03-26 2:20pm Working on game algorithm*/
/*Harshaan Mahendran 2021-03-26 7:00pm Working on game algorithm*/
/*Jathushan Vishnukaran 2021-03-26 7:30pm Working on help page*/
/*Dhruv Chand 2021-03-26 2:20pm Bug fixing the code*/
/*Harshaan Mahendran 2021-03-27 10:37am Working on game algorithm and fixing bugs*/
/*Jathushan Vishnukaran 2021-03-27 11:15am Starting on highscores page*/
/*Harshaan Mahendran 2021-03-28 11:01am Working on game algorithm*/
/*Dhruv Chand 2021-03-28 11:01am Working on game algorithm and fixing bugs*/
/*Jathushan Vishnukaran 2021-03-28 11:05am Working on highscores page*/
/*Harshaan Mahendran 2021-03-29 2:22pm Fixing logic errors and working on algorithm*/
/*Dhruv Chand 2021-03-29 2:22pm Working on game algorithm and fixing errors*/
/*Harshaan Mahendran 2021-03-29 7:02pm Fixing highscores*/
/*Dhruv Chand 2021-03-29 7:00pm Working on game and working on highscores page*/
/*Jathushan Vishnukaran 2021-03-28 2:25pm Working on highscores page*/
/*Jathushan Vishnukaran 2021-03-28 7:10pm Working on draw card section*/
/*Harshaan Mahendran 2021-03-30 2:12pm Working on highscores*/
/*Dhruv Chand 2021-03-30 4:00pm Working on game*/
/*Dhruv Chand 2021-03-29 2:10pm Working draw card function*/
/*Harshaan Mahendran 2021-03-30 6:01pm Working on highscores*/
/*Dhruv Chand 2021-04-01 2:10pm Working draw card function*/
/*Harshaan Mahendran 2021-04-01 4:14pm Working on highscores, adding if statements, adding documentation, fixing scopes*/
/*Harshaan Mahendran 2021-04-02 10:30am Finishing navigation and about the game page*/
/*Dhruv Chand 2021-04-02 2:00pm Working draw card function*/
/*Harshaan Mahendran 2021-04-02 2:00pm Working on simplifying code*/
/*Dhruv Chand 2021-04-03 1:00pm Working on special card functions*/
/*Harshaan Mahendran 2021-04-03 1:07pm Working on special card functions*/
/*Harshaan Mahendran 2021-04-04 12:26pm Final touches for game.*/
/*Dhruv Chand 2021-04-04 12:26pm Final touches for game.*/
/*Jathushan Vishnukaran 2021-04-04 3:00pm Final touches for game.*/

import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

class Main {
    //global variables
    /****************************************
      The global variables below are referenced throughout the code in at least 2 or more methods.
    *****************************************/
    static String name = "";//Global variable used to store name.
    static int numOpponentShuffle=0;//Global variable used for representing number of opponents.
    static String cardInPileColor = "";//Global variable used to check color of card in pile.
    static String cardInPileType = "";//Global variable used to check type of card in pile.
    static int CPU1cardsAmount = 6;
    static int CPU2cardsAmount = 6;
    static int CPU3cardsAmount = 6;
    static int turns = 0;//Global variable used to add to the amount of turns that pass. 
    static int cards = 6;//Global variable used to represent the number of cards the user has.
    static Random rand = new Random();//Global variable used to randomize numbers.
    static Scanner in = new Scanner(System.in);//Global variable used for user input.
    static int plusCard = 0;//Global variable used for +2 and +4 cards. 
    static String instruction = "";//Global variable used for user input in help page, highscores page, and about game page.
    static String nav = "";//Global variable used for user navigation throughout the project.
    //global arrays
    static final int ROWS = 51;//Constant used for setting up the rows of a 2D array.
    static final int COLUMNS = 2;//Constant used for setting up the cols of a 2D array.
    /****************************************
      The global arrays below are referenced throughout the code in at least 2 or more methods.
    *****************************************/
    static final String[] ARRAY_COLORS = {"Red", "Blue", "Green", "Yellow"};//Constant global array used to store possible card colors. 1D array and constant.
    static final String[] ARRAY_CARD_TYPES = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "+4", "+2", "colorChange"};//Constant global array used to store possible card types. 1D array and constant.
    static String[][] arrayNewCardsCPU;//Global array used in CPU drawsand CPU decision making. 2D array.
    static String[][] arrayPlayerCards;//Global array used in user draws, user decision making and to store player cards. 2D array.
    static String[][] CPU1Cards; //Global array used to store cards for CPU 1. 2D array.
    static String[][] CPU2Cards; //Global array used to store cards for CPU 2. 2D array.
    static String[][] CPU3Cards; //Global array used to store cards for CPU 3. 2D array.

    public static void main(String[] args) throws IOException{
      titleScreen();
      inputMain();
    }

    /**********************
      Method used to collect input from user and do something using the input when user is in title screen. Method without parameters. 
    ***********************/
    public static void inputMain() throws IOException{
      System.out.print("Enter Number Here:");
      nav = in.nextLine();//CONSOLE INPUT.
      if (nav.equals("1")) getInformation();
      else if (nav.equals("2")) helpPage();
      else if (nav.equals("3")) highscoresPage();
      else if (nav.equals("4")) aboutGame();
      else {
        System.out.println("Incorrect input, try again.");
        inputMain();
      }
    }
    
    /**********************
      Method used to load in the title screen's ASCII art. Method without parameters.
    ***********************/
    public static void titleScreen() throws IOException {
      FileReader logo = new FileReader("title.txt");//File reading inplemented.
      BufferedReader br = new BufferedReader(logo);
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
      br.close();
    }

    /**********************
      Method used to collect basic user information and based on user input continue to the game. Method without parameters.
    ***********************/
    public static void getInformation() throws IOException {
      System.out.print("What is your name?");
      name = in.nextLine();//CONSOLE INPUT.
      FileReader gameModes = new FileReader("gameModes.txt");//File reading inplemented.
      BufferedReader br = new BufferedReader(gameModes);
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
      System.out.print("Hey " + name + " press A to continue to the game.");
      String letter = in.nextLine();//CONSOLE INPUT.
      if (letter.toUpperCase().equals("A")) opponentSelection();
      else {
        System.out.println("Not understood, restarting data collection.");
        getInformation();
      }
    }

    /**********************
      Method used to display the help page when the user wants to. Method without parameters.
    ***********************/
    public static void helpPage() throws IOException {
      FileReader logo = new FileReader("help.txt");//File reading inplemented.
      BufferedReader br = new BufferedReader(logo);
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
      br.close();
      System.out.println("Basic Instructions to Play Game:");
      System.out.println("To play the game you would need to press 1 on the homescreen that you load into or 2 if you are on any other section of the game.");
      System.out.println("2-4 players can play this game including yourself.");
      System.out.println("When the game begins and the cards are dealt, the game rotation would go from the dealers left side.");
      System.out.println("To place cards, you would need to place the same color of the card that was last placed in the pile, the card can also be different color but same number, and the card can also be a wildcard. Wild cards include plus2, plus4, and change color.");
      System.out.println("The game ends when one player has no cards left.");
      System.out.println("If you win your game, your score would be recorded in the highscore page when you press 3.");
      System.out.println("Navigation:");
      System.out.println("Press 1 to go back to home screen, 2 to play game, 3 to get to highscores page, 4 to go to about the game page.");
      System.out.print("Type number here: ");
      instruction = in.nextLine();//CONSOLE INPUT.
      if (instruction.equals("1")) {
        titleScreen();
        System.out.print("Enter Number Here:");
        nav = in.nextLine();//CONSOLE INPUT.
        if (nav.equals("1")) getInformation();
        else if (nav.equals("2")) helpPage();
        else if (nav.equals("3")) highscoresPage();
        else if (nav.equals("4")) aboutGame();
        else {
          System.out.println("Incorrect input, try again.");
          inputMain();
        }
      }
      else if (instruction.equals("2")) helpPage();
      else if (instruction.equals("3")) highscoresPage();
      else if (instruction.equals("4")) aboutGame();
      else {
        System.out.println("Incorrect value, restarting help page.");
        helpPage();
      }
    }

    /**********************
      Method used to display the highscores page when the user wants to. Method without parameters.
    ***********************/
    public static void highscoresPage() throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));//File reading inplemented.
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
      System.out.println("Welcome to the highscores page.");
      highscores();
      System.out.println("Press 1 to go back to homepage, press 2 to go to help page, press 3 to go to highscores page, press 4 to go to about the game page.");
      instruction = in.nextLine();//CONSOLE INPUT.
      if (instruction.equals("1")) {
        titleScreen();
        System.out.print("Enter Number Here:");
        nav = in.nextLine();//CONSOLE INPUT.
        if (nav.equals("1")) getInformation();
        else if (nav.equals("2")) helpPage();
        else if (nav.equals("3")) highscoresPage();
        else if (nav.equals("4")) aboutGame();
        else {
          System.out.println("Incorrect input, try again.");
          inputMain();
        }
      }
      else if (instruction.equals("2")) helpPage();
      else if (instruction.equals("3")) highscoresPage();
      else if (instruction.equals("4")) aboutGame();
      else {
        System.out.println("Incorrect value, restarting highscores page.");
        highscoresPage();
      }
    }

    /**********************
      Method used to display the aboutGame page and navigate throughout the project. Method without parameters.
    **********************/
    public static void aboutGame() throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("aboutGame.txt"));//File reading inplemented.
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
      System.out.println("Welcome to the About the Game page.");
      System.out.println("Here are some details about the game:");
      System.out.println("This is a modified version of the classic card game Crazy 8s made by Jathushan, Dhruv, and Harshaan. It blends elements from both the classic card game and the IMessage version of the game.");
      System.out.println("It was a game that challenged the developing capabilities of the developers. As a group, we ran into problems that we were able to overcome. We hope that you, the user, can enjoy the final product.");
      System.out.println("Press 1 to go back to homepage, press 2 to go to help page, press 3 to go to highscores page, press 4 to go to about the game page.");
      instruction = in.nextLine();//CONSOLE INPUT.
      if (instruction.equals("1")) {
        titleScreen();
        System.out.print("Enter Number Here:");
        nav = in.nextLine();//CONSOLE INPUT.
        if (nav.equals("1")) getInformation();
        else if (nav.equals("2")) helpPage();
        else if (nav.equals("3")) highscoresPage();
        else if (nav.equals("4")) aboutGame();
        else {
          System.out.println("Incorrect input, try again.");
          inputMain();
        }
      }
      else if (instruction.equals("2")) helpPage();
      else if (instruction.equals("3")) highscoresPage();
      else if (instruction.equals("4")) aboutGame();
      else {
        System.out.println("Incorrect value, restarting about the game page.");
        aboutGame();
      }
    }

    /**********************
      Method used to shuffle the cards for the user. Method without parameters. Method with return type. Method that returns a 2D array.
    ***********************/
    public static String[][] draftCardsUser() throws IOException {
      String[][] calculatingCardArray = new String[ROWS][COLUMNS];//2D array.
      //two arrays, one for card color, one for card number/special cards
      String card1Color = "", card2Color = "", card3Color = "", card4Color = "", card5Color = "", card6Color = "";//Local variables used to house type of each user card color.
      String card1 = "", card2 = "", card3 = "", card4 = "", card5 = "", card6 = "", card7 = "", card8 = "";//Local variables used to house the type of each user card. 
      for (int x = 0; x <= 6; x++) {
        if (x == 1) card1Color = ARRAY_COLORS[rand.nextInt(4)]; 
        else if (x == 2) card2Color = ARRAY_COLORS[rand.nextInt(4)]; 
        else if (x == 3) card3Color = ARRAY_COLORS[rand.nextInt(4)];
        else if (x == 4) card4Color = ARRAY_COLORS[rand.nextInt(4)];
        else if (x == 5) card5Color = ARRAY_COLORS[rand.nextInt(4)];
        else if (x == 6) card6Color = ARRAY_COLORS[rand.nextInt(4)];
      }
      for (int x = 0; x <= 6; x++) {
        if (x == 1) card1 = ARRAY_CARD_TYPES[rand.nextInt(12)]; 
        else if (x == 2) card2 = ARRAY_CARD_TYPES[rand.nextInt(12)]; 
        else if (x == 3) card3 = ARRAY_CARD_TYPES[rand.nextInt(12)];
        else if (x == 4) card4 = ARRAY_CARD_TYPES[rand.nextInt(12)];
        else if (x == 5) card5 = ARRAY_CARD_TYPES[rand.nextInt(12)];
        else if (x == 6) card6 = ARRAY_CARD_TYPES[rand.nextInt(12)];
      }
      calculatingCardArray[0][0] = card1Color;
      calculatingCardArray[0][1] = card1;
      calculatingCardArray[1][0] = card2Color;
      calculatingCardArray[1][1] = card2;
      calculatingCardArray[2][0] = card3Color;
      calculatingCardArray[2][1] = card3;
      calculatingCardArray[3][0] = card4Color;
      calculatingCardArray[3][1] = card4;
      calculatingCardArray[4][0] = card5Color;
      calculatingCardArray[4][1] = card5;
      calculatingCardArray[5][0] = card6Color;
      calculatingCardArray[5][1] = card6;
      return calculatingCardArray;
    }

    /**********************
      Method used to choose the amount of opponents based on user input. Method without parameters.
    ***********************/
    public static void opponentSelection() throws IOException {
      String beginningMessage = "The game has begun, good luck!";
      System.out.print("How many opponents, one, two, or three? (enter 1 for one, 2 for two, and 3 for three)");
      int input = Integer.parseInt(in.nextLine());//CONSOLE INPUT.
      if (input == 1) {
        numOpponentShuffle = 1;
        System.out.print("One oppenent selected.");
        System.out.println(" Shuffling Process Has Begun. Here are your cards.");
        arrayPlayerCards = draftCardsUser();
        System.out.println("Opponent Shuffling has Begun.");
        CPU1Cards = draftCardsUser();
      }
      else if (input == 2) {
        numOpponentShuffle = 2;
        System.out.print("Two oppenents selected.");
        System.out.println(" Shuffling Process Has Begun. Here are your cards.");
        arrayPlayerCards = draftCardsUser();
        System.out.println("Opponent Shuffling has Begun.");
        CPU1Cards = draftCardsUser();
        CPU2Cards = draftCardsUser();
      }
      else if (input == 3) {
        numOpponentShuffle = 3;
        System.out.print("Three oppenents selected.");
        System.out.println(" Shuffling Process Has Begun. Here are your cards.");
        arrayPlayerCards = draftCardsUser();
        System.out.println("Opponent Shuffling has Begun.");
        CPU1Cards = draftCardsUser();
        CPU2Cards = draftCardsUser();
        CPU3Cards = draftCardsUser();
      }
      else {
        System.out.println("Unknown value, retrying selection process.");
        opponentSelection();
      }
      System.out.println(beginningMessage);
      playGameUserTurn();
    }
    
    /**********************
      Method used to draw a card for the user. Method without parameters.
    ***********************/
    public static void DrawCards() throws IOException {
      if (cards == 50) System.out.println("You have reached the maximum number of cards");
      else {
        System.out.println("You have drawn a card");
        int drawCounter = 0;
        String newCardType = "";
        String newCardColor = "";
        for (int k = 0; arrayPlayerCards!=null; k++) {
          if (arrayPlayerCards[k][0] == null) 
          {
            drawCounter = k;
            break;
          }
        }
        newCardColor = ARRAY_COLORS[rand.nextInt(4)];
        newCardType = ARRAY_CARD_TYPES[rand.nextInt(12)];
        arrayPlayerCards[drawCounter][0] = newCardColor;
        arrayPlayerCards[drawCounter][1] = newCardType;
        cards++;
      }
    }

    /**********************
      Method used to draw a card for the first CPU. Method without parameters.
    ***********************/
    public static void DrawCardsCPU1() throws IOException {
      if (CPU1cardsAmount == 50) System.out.println("CPU 1 tries to draw a card but has reached maximum cards they can hold!");
      else {
        System.out.println("Computer 1 has drawn a card!");
        int drawCounter = 0;
        String newCardType = "";
        String newCardColor = "";
        for (int k = 0; CPU1Cards != null; k++) {
          if (CPU1Cards[k][0] == null) 
          {
            drawCounter = k;
            break;
          }
        }
        newCardColor = ARRAY_COLORS[rand.nextInt(4)];
        newCardType = ARRAY_CARD_TYPES[rand.nextInt(12)];
        CPU1Cards[drawCounter][0] = newCardColor;
        CPU1Cards[drawCounter][1] = newCardType;
        CPU1cardsAmount++;
      }
    }

    /**********************
      Method used to draw a card for the second CPU. Method without parameters.
    ***********************/
    public static void DrawCardsCPU2() throws IOException {
      if (CPU2cardsAmount == 50) System.out.println("CPU 2 tries to draw a card but has reached maximum cards they can hold!");
      else {
        System.out.println("Computer 2 has drawn a card!");
        int drawCounter = 0;
        String newCardType = "";
        String newCardColor = "";
        for (int k = 0; CPU2Cards != null; k++) {
          if (CPU2Cards[k][0] == null) 
          {
            drawCounter = k;
            break;
          }
        }
        newCardColor = ARRAY_COLORS[rand.nextInt(4)];
        newCardType = ARRAY_CARD_TYPES[rand.nextInt(12)];
        CPU2Cards[drawCounter][0] = newCardColor;
        CPU2Cards[drawCounter][1] = newCardType;
        CPU2cardsAmount++;
      }
    }

    /**********************
      Method used to draw a card for the third CPU. Method without parameters.
    ***********************/
    public static void DrawCardsCPU3() throws IOException {
      if (CPU3cardsAmount == 50) System.out.println("CPU 3 tries to draw a card but has reached maximum cards they can hold!");
      else {
        System.out.println("Computer 3 has drawn a card!");
        int drawCounter = 0;
        String newCardType = "";
        String newCardColor = "";
        for (int k = 0; CPU3Cards != null; k++) {
          if (CPU3Cards[k][0] == null) 
          {
            drawCounter = k;
            break;
          }
        }
        newCardColor = ARRAY_COLORS[rand.nextInt(4)];
        newCardType = ARRAY_CARD_TYPES[rand.nextInt(12)];
        CPU3Cards[drawCounter][0] = newCardColor;
        CPU3Cards[drawCounter][1] = newCardType;
        CPU3cardsAmount++;
      }
    }

    /**********************
      Method used to display the instructions and perform the user's turn. Method without parameters.
    ***********************/
    public static void playGameUserTurn() throws IOException {
      int result = 0;
      int card = 0;
      int loop = 0;
      int arrayNumber = 0;
      String enteredCardColor = "";
      String enteredCardType = "";
      String inputValue = null;
      System.out.println(" ");
      System.out.println("Your current cards are:");
      while (loop < cards) {
        if (arrayPlayerCards[arrayNumber][0] != null) {
          System.out.println("Card " + (arrayNumber + 1) + " color and type: " + arrayPlayerCards[arrayNumber][0] + " " + arrayPlayerCards[arrayNumber][1]);
          loop++;
        }
        arrayNumber++;
       }
      loop = 0;
      arrayNumber = 0;
      System.out.print("The current amount of cards you have is " + cards);
      System.out.println(" ");
      System.out.println("Your Turn, what card would you like to play (enter a number from 1 to the number of cards you have to play a card, Enter Draw if you would like to draw a card. Enter Quit to forfeit the game).");
      inputValue = in.nextLine();//CONSOLE INPUT.
      if (inputValue.equals("draw") || inputValue.equals("Draw")) DrawCards();
      else if (inputValue.equals("quit") || inputValue.equals("Quit")) {
        System.out.println(name + " has quit. " + name + " has gotten outsmarted by their computer. Congrats " + name + " the computer is smarter than you.");
        System.out.println("Returning to title screen.");
        reset();
        titleScreen();
        System.out.print("Enter Number Here:");
        nav = in.nextLine();//CONSOLE INPUT.
        if (nav.equals("1")) getInformation();
        else if (nav.equals("2")) helpPage();
        else if (nav.equals("3")) highscoresPage();
        else if (nav.equals("4")) aboutGame();
        else {
          System.out.println("Incorrect input, try again.");
          inputMain();
        }
      }
      else if (inputValue.equals("1") || inputValue.equals("2") || inputValue.equals("3") || inputValue.equals("4") || inputValue.equals("5") || inputValue.equals("6") || inputValue.equals("7") || inputValue.equals("8") || inputValue.equals("9") || inputValue.equals("10") || inputValue.equals("11") || inputValue.equals("12") || inputValue.equals("13") || inputValue.equals("14") || inputValue.equals("15") || inputValue.equals("16") || inputValue.equals("17") || inputValue.equals("18") || inputValue.equals("19") || inputValue.equals("20") || inputValue.equals("21") || inputValue.equals("22") || inputValue.equals("23") || inputValue.equals("24") || inputValue.equals("25") || inputValue.equals("26") || inputValue.equals("27") || inputValue.equals("28") || inputValue.equals("29") || inputValue.equals("30") || inputValue.equals("31") || inputValue.equals("32") || inputValue.equals("33") || inputValue.equals("34") || inputValue.equals("35") || inputValue.equals("36") || inputValue.equals("37") || inputValue.equals("38") || inputValue.equals("39") || inputValue.equals("40") || inputValue.equals("41") || inputValue.equals("42") || inputValue.equals("43") || inputValue.equals("44") || inputValue.equals("45") || inputValue.equals("46") || inputValue.equals("47") || inputValue.equals("48") || inputValue.equals("49") || inputValue.equals("50")) card = Integer.parseInt(inputValue);
      else {
        System.out.println("Not understood, restarting your current turn.");
        playGameUserTurn();
      }
      if (card != 0) {
        if (arrayPlayerCards[card-1][0] == null && arrayPlayerCards[card-1][1] == null) System.out.println("You cannot place this card, you either do not have the card or have already placed the card.");
        else {
          enteredCardColor = arrayPlayerCards[card - 1][0];
          enteredCardType = arrayPlayerCards[card - 1][1];
          result = pileCheck(enteredCardColor, enteredCardType);
          if (result == 1) {
            if (enteredCardColor == null && enteredCardType == null) System.out.println("You cannot place this card, you have already played it");
            else {
              System.out.println("You placed card type: " + enteredCardType + " with color " + enteredCardColor);
              arrayPlayerCards[card - 1][0] = null;
              arrayPlayerCards[card - 1][1] = null;
            }
            cards--;
            if (enteredCardType == "+4") {
              CPU1Cards = UserPlus2or4toComputer(enteredCardType, CPU1Cards);
              System.out.println("Computer 1 now has " + CPU1cardsAmount +" cards left");
            }
            else if (enteredCardType == "+2") {
              CPU1Cards = UserPlus2or4toComputer(enteredCardType, CPU1Cards);
              System.out.println("Computer 1 now has " + CPU1cardsAmount +" cards left");
            }
          }
          else if (result == 2) {
            System.out.println("You put down a color change card!");
            colorChange();
            cardInPileType = "colorChange";
            arrayPlayerCards[card - 1][0] = null;
            arrayPlayerCards[card - 1][1] = null;
            cards--;
          }
          else System.out.println("The card you have selected cannot be placed");
          card = 0;
        }
      }
      else System.out.println("End of turn");
      checkCardsLeft();
      System.out.println("You have " + cards + " cards remaining.");
      turns++;
      System.out.println(" ");
      System.out.println("Opponent turn commencing now. You are currently at " + turns + " turns.");
      checkPile();
      opponentTurn();
    }

    /**********************
      Method used to check the current card's type and color in the pile. Method with parameters. Method with return type.
    ***********************/
    public static int pileCheck (String color, String type) {
      int result = 0;
      if (type == "colorChange") {
        result = 2; 
        return result;
      }
      else if (type == cardInPileType || color == cardInPileColor || cardInPileColor == "" && cardInPileType == "") {
        cardInPileColor = color;
        cardInPileType = type;
        return result += 1;
      }
      else return result;
    }

    /**********************
      Method used to add 2 or 4 cards to the user if the computer places a +2 or +4 onto user. Method with parameters. Method with 2D array as parameter. Method with return type. Method that returns a 2D array.
    ***********************/
    public static String[][] computerPlus2or4toUser (String cardType, String[][] inputArray) {
      int cardsGiven = 0;
      int arrayLine = 0;
      String color = null;
      String type = null;
      if (cardType == "+4") {
        while (cardsGiven < 4) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       cards+=4;
      }
      else {
        while (cardsGiven < 2) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       cards+=2;
      }
      return inputArray;
    }

    /*****************************
      Method used to add 2 or 4 cards to the computer if the user places a +2 or +4 card. Method with parameters. Method with 2D array as parameter. Method with return type. Method that returns a 2D array.
    ******************************/
    public static String[][] UserPlus2or4toComputer (String cardType, String[][] inputArray) {
      int cardsGiven = 0;
      int arrayLine = 0;
      String color = null;
      String type = null;
      if (cardType == "+4") {
        while (cardsGiven < 4) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       CPU1cardsAmount+= 4;
      }
      else {
        while (cardsGiven < 2) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       CPU1cardsAmount+= 2;
      }
      return inputArray;
    }

    /**********************
      Method used to add 2 or 4 cards to the second computer if the first computer places a +2 or +4 card. Method with parameters. Method with 2D array as parameter. Method with return type. Method that returns a 2D array.
    ***********************/
    public static String[][] computer1Plus2or4toComputer2 (String cardType, String[][] inputArray) {
      int cardsGiven = 0;
      int arrayLine = 0;
      String color = null;
      String type = null;
      if (cardType == "+4") {
        while (cardsGiven < 4) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       CPU2cardsAmount+= 4;
      }
      else {
        while (cardsGiven < 2) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       CPU2cardsAmount+= 2;
      }
      return inputArray;
    }

    /**********************
      Method used to add 2 or 4 cards to the third computer if the second computer places a +2 or +4 card. Method with parameters. Method with 2D array as parameter. Method with return type. Method that returns a 2D array.
    ***********************/
    public static String[][] computer2Plus2or4toComputer3 (String cardType, String[][] inputArray) {
      int cardsGiven = 0;
      int arrayLine = 0;
      String color = null;
      String type = null;
      if (cardType == "+4") {
        while (cardsGiven < 4) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       CPU3cardsAmount+= 4;
      }
      else {
        while (cardsGiven < 2) {
        if (inputArray[arrayLine][0] == null) {
          color = ARRAY_COLORS[rand.nextInt(4)];
          type = ARRAY_CARD_TYPES[rand.nextInt(12)];
          inputArray[arrayLine][0] = color;
          inputArray[arrayLine][1] = type;
          cardsGiven++;
        }
        arrayLine++;
       }
       CPU3cardsAmount+= 2;
      }
      return inputArray;
    }

    /**********************
      Method user to change color if user places color change card. Method without parameters.
    **********************/
    public static void colorChange() throws IOException {
      cardInPileColor = ARRAY_COLORS[rand.nextInt(4)];
      System.out.println("The color has been changed, the current color in the pile is " + cardInPileColor + ".");
    }
    
    /**********************
      Method used to perform the opponents turn. Method without parameters.
    ***********************/
    public static void opponentTurn() throws IOException { 
        Random rand = new Random();
        String cardColor = null;
        String cardType = null;
        int cpu1result = 0;
        int cpu2result = 0;
        int cpu3result = 0;
        int cpuCheck = 0;
        int cpuCheckLoop = 0;
        if (numOpponentShuffle == 1) {//1 player
          while (cpuCheck < CPU1cardsAmount) {
            if (CPU1Cards[cpuCheckLoop][0] != null) {
              cardColor =  CPU1Cards[cpuCheckLoop][0];
              cardType = CPU1Cards[cpuCheckLoop][1];
              cpu1result = pileCheck(cardColor,cardType);
              if (cpu1result == 2) {
                System.out.println("Computer 1 put down a color change card!");
                colorChange();
                cardInPileType = "colorChange";
                break;
              }
              else if (cpu1result == 1) break;
              cpuCheck++;
            }
            cpuCheckLoop++;
          }
          if (cpu1result != 1 && cpu1result != 2) {
            DrawCardsCPU1();
            checkCardsOpponent(CPU1cardsAmount);
          }
          else if (cpu1result == 2) {
            CPU1cardsAmount--;
            checkCardsOpponent(CPU1cardsAmount);
          }
          else {
            System.out.println("Computer 1 placed a " + CPU1Cards[cpuCheckLoop][0] + " " + CPU1Cards[cpuCheckLoop][1]);
            CPU1Cards[cpuCheckLoop][0] = null;
            CPU1Cards[cpuCheckLoop][1] = null;
            CPU1cardsAmount--;
            checkCardsOpponent(CPU1cardsAmount);
          }
          if (cardType == "+4" && cpu1result == 1) {
            arrayPlayerCards = computerPlus2or4toUser(cardType, arrayPlayerCards);
            System.out.println("Computer 1 added 4 cards to your hand!");
          }
          else if (cardType == "+2" && cpu1result == 1) {
            arrayPlayerCards = computerPlus2or4toUser(cardType, arrayPlayerCards);
            System.out.println("Computer 1 added 2 cards to your hand!");
          }
          cpuCheckLoop = 0;
          cpuCheck = 0;
          cpu1result = 0;
        }
        else if (numOpponentShuffle == 2) {//2 players
          while (cpuCheck < CPU1cardsAmount) {
            if (CPU1Cards[cpuCheckLoop][0] != null) {
              cardColor =  CPU1Cards[cpuCheckLoop][0];
              cardType = CPU1Cards[cpuCheckLoop][1];
              cpu1result = pileCheck(cardColor,cardType);
              if (cpu1result == 2) {
                System.out.println("Computer 1 put down a color change card!");
                colorChange();
                cardInPileType = "colorChange";
                break;
              }
              else if (cpu1result == 1) break;
              cpuCheck++;
            }
            cpuCheckLoop++;
          }
          if (cpu1result != 1 && cpu1result != 2) {
            DrawCardsCPU1();
            checkCardsOpponent(CPU1cardsAmount);
          }
          else if (cpu1result == 2) {
            CPU1cardsAmount--;
            checkCardsOpponent(CPU1cardsAmount);
          }
          else {
            System.out.println("Computer 1 placed a " + CPU1Cards[cpuCheckLoop][0] +" " + CPU1Cards[cpuCheckLoop][1]);
            CPU1Cards[cpuCheckLoop][0] = null;
            CPU1Cards[cpuCheckLoop][1] = null;
            CPU1cardsAmount--;
            checkCardsOpponent(CPU1cardsAmount);
          }
          if (cardType == "+4" && cpu1result == 1) {
            CPU2Cards = computer1Plus2or4toComputer2(cardType, CPU2Cards);
            System.out.println("Computer 1 added 4 cards to Computer 2!");
          }
          else if (cardType == "+2" && cpu1result == 1) {
            CPU2Cards = computer1Plus2or4toComputer2(cardType, CPU2Cards);
            System.out.println("Computer 1 added 2 cards to Computer 2!");
          }
          cpuCheckLoop = 0;
          cpuCheck = 0;
          while (cpuCheck < CPU2cardsAmount) {
            if (CPU2Cards[cpuCheckLoop][0] != null) {
              cardColor =  CPU2Cards[cpuCheckLoop][0];
              cardType = CPU2Cards[cpuCheckLoop][1];
              cpu2result = pileCheck(cardColor,cardType);
              if (cpu2result == 2) {
                System.out.println("Computer 2 put down a color change card!");
                colorChange();
                cardInPileType = "colorChange";
                break;
              }
              else if (cpu2result == 1) break;
              cpuCheck++;
            }
            cpuCheckLoop++;
          }
          if (cpu2result != 1 && cpu2result != 2) {
            DrawCardsCPU2();
            checkCardsOpponent(CPU2cardsAmount);
          }
          else if (cpu2result == 2) {
            CPU2cardsAmount--;
            checkCardsOpponent(CPU2cardsAmount);
          }
          else {
            System.out.println("Computer 2 placed a " + CPU2Cards[cpuCheckLoop][0] +" " + CPU2Cards[cpuCheckLoop][1]);
            CPU2Cards[cpuCheckLoop][0] = null;
            CPU2Cards[cpuCheckLoop][1] = null;
            CPU2cardsAmount--;
            checkCardsOpponent(CPU2cardsAmount);
          }
          if (cardType == "+4" && cpu2result == 1) {
            arrayPlayerCards = computerPlus2or4toUser(cardType, arrayPlayerCards);
            System.out.println("Computer 2 added 4 cards to your hand!");
          }
          else if (cardType == "+2" && cpu2result == 1) {
            arrayPlayerCards = computerPlus2or4toUser(cardType, arrayPlayerCards);
            System.out.println("Computer 2 added 2 cards to your hand!");
          }
          cpuCheckLoop = 0;
          cpuCheck = 0;
        }
        else if (numOpponentShuffle == 3) {//3 players
          while (cpuCheck < CPU1cardsAmount) {
            if (CPU1Cards[cpuCheckLoop][0] != null) {
              cardColor =  CPU1Cards[cpuCheckLoop][0];
              cardType = CPU1Cards[cpuCheckLoop][1];
              cpu1result = pileCheck(cardColor,cardType);
              if (cpu1result == 2) {
                System.out.println("Computer 1 put down a color change card!");
                colorChange();
                cardInPileType = "colorChange";
                break;
              }
              else if (cpu1result == 1) break;
              cpuCheck++;
            }
            cpuCheckLoop++;
          }
          if (cpu1result != 1 && cpu1result != 2) {
            DrawCardsCPU1();
            checkCardsOpponent(CPU1cardsAmount);
          }
          else if (cpu1result == 2) {
            CPU1cardsAmount--;
            checkCardsOpponent(CPU1cardsAmount);
          }
          else {
            System.out.println("Computer 1 placed a " + CPU1Cards[cpuCheckLoop][0] +" " + CPU1Cards[cpuCheckLoop][1]);
            CPU1Cards[cpuCheckLoop][0] = null;
            CPU1Cards[cpuCheckLoop][1] = null;
            CPU1cardsAmount--;
            checkCardsOpponent(CPU1cardsAmount);
          }
          if (cardType == "+4" && cpu1result == 1) {
            CPU2Cards = computer1Plus2or4toComputer2(cardType, CPU2Cards);
            System.out.println("Computer 1 added 4 cards to Computer 2!");
          }
          else if (cardType == "+2" && cpu1result == 1) {
            CPU2Cards = computer1Plus2or4toComputer2(cardType, CPU2Cards);
            System.out.println("Computer 1 added 2 cards to Computer 2!");
          }
          cpuCheckLoop = 0;
          cpuCheck = 0;
          while (cpuCheck < CPU2cardsAmount) {
            if (CPU2Cards[cpuCheckLoop][0] != null) {
              cardColor =  CPU2Cards[cpuCheckLoop][0];
              cardType = CPU2Cards[cpuCheckLoop][1];
              cpu2result = pileCheck(cardColor,cardType);
              if (cpu2result == 2) {
                System.out.println("Computer 2 put down a color change card!");
                colorChange();
                cardInPileType = "colorChange";
                break;
              }
              else if (cpu2result == 1) break;
              cpuCheck++;
            }
            cpuCheckLoop++;
          }
          if (cpu2result != 1 && cpu2result != 2) {
            DrawCardsCPU2();
            checkCardsOpponent(CPU2cardsAmount);
          }
          else if (cpu2result == 2) {
            CPU2cardsAmount--;
            checkCardsOpponent(CPU2cardsAmount);
          }
          else {
            System.out.println("Computer 2 placed a " + CPU2Cards[cpuCheckLoop][0] +" " + CPU2Cards[cpuCheckLoop][1]);
            CPU2Cards[cpuCheckLoop][0] = null;
            CPU2Cards[cpuCheckLoop][1] = null;
            CPU2cardsAmount--;
            checkCardsOpponent(CPU2cardsAmount);
          }
          if (cardType == "+4" && cpu2result == 1) {
            CPU3Cards = computer2Plus2or4toComputer3(cardType, CPU3Cards);
            System.out.println("Computer 2 added 4 cards to Computer 3!");
          }
          else if (cardType == "+2" && cpu2result == 1) {
            CPU3Cards = computer2Plus2or4toComputer3(cardType, CPU3Cards);
            System.out.println("Computer 2 added 2 cards to Computer 3!");
          }
          cpuCheckLoop = 0;
          cpuCheck = 0;
          while (cpuCheck < CPU3cardsAmount) {
            if (CPU3Cards[cpuCheckLoop][0] != null) {
              cardColor =  CPU3Cards[cpuCheckLoop][0];
              cardType = CPU3Cards[cpuCheckLoop][1];
              cpu3result = pileCheck(cardColor,cardType);
              if (cpu3result == 2) {
                System.out.println("Computer 3 put down a color change card!");
                colorChange();
                cardInPileType = "colorChange";
                break;
              }
              else if (cpu3result == 1) break;
              cpuCheck++;
            }
            cpuCheckLoop++;
          }
          if (cpu3result != 1 && cpu3result != 2) {
            DrawCardsCPU3();
            checkCardsOpponent(CPU3cardsAmount);
          }
          else if (cpu3result == 2) {
            CPU3cardsAmount--;
            checkCardsOpponent(CPU3cardsAmount);
          }
          else {
            System.out.println("Computer 3 placed a " + CPU3Cards[cpuCheckLoop][0] +" " + CPU3Cards[cpuCheckLoop][1]);
            CPU3Cards[cpuCheckLoop][0] = null;
            CPU3Cards[cpuCheckLoop][1] = null;
            CPU3cardsAmount--;
            checkCardsOpponent(CPU3cardsAmount);
          }
          if (cardType == "+4" && cpu3result == 1) {
            arrayPlayerCards = computerPlus2or4toUser(cardType, arrayPlayerCards);
            System.out.println("Computer 3 added 4 cards to your hand!");
          }
          else if (cardType == "+2" && cpu3result == 1) {
            arrayPlayerCards = computerPlus2or4toUser(cardType, arrayPlayerCards);
            System.out.println("Computer 3 added 2 cards to your hand!");
          }
          cpuCheckLoop = 0;
          cpuCheck = 0;
        }
        turns++;
        checkPile();
        System.out.println("Your turn shall now commence. You are currently at " + turns + " turns.");
        playGameUserTurn();
      }

      /******************************
        Method to check if any CPU runs out of cards. Method with parameters.
      *******************************/
      public static void checkCardsOpponent(int cards) throws IOException {
        if (cards <= 0) {
          System.out.println("An opponent has run out of cards and thus has beaten you. The game lasted for " + turns + " turns. As you have lost the game your score will not be included in the highscores page.");
          System.out.println("Returning to homepage.");
          reset();
          titleScreen();
          System.out.print("Enter Number Here:");
          nav = in.nextLine();//CONSOLE INPUT.
          if (nav.equals("1")) getInformation();
          else if (nav.equals("2")) helpPage();
          else if (nav.equals("3")) highscoresPage();
          else if (nav.equals("4")) aboutGame();
          else {
            System.out.println("Incorrect input, try again.");
            inputMain();
          }
        }
        else {
          System.out.println("This opponent has " + cards + " cards left.");
        }
      } 
      
      /**********************
        Method used to check the amount of cards left for the user and do something based upon it. Method without parameters.
      ***********************/
      public static void checkCardsLeft() throws IOException{
        if (cards <= 0) {
          BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt", true));//File writing inplemented.
          BufferedWriter bw2 = new BufferedWriter(new FileWriter("names.txt", true));//File writing inplemented.
          BufferedWriter bw3 = new BufferedWriter(new FileWriter("scoresAndNames.txt", true));//File writing inplemented.
          System.out.println("You have completed the game. It took you " + turns + " turns to beat " + numOpponentShuffle + " opponents.");
          System.out.println("Returning to title screen.");
          bw.write(turns + "\r\n");
          bw2.write(name + "\r\n");
          bw3.write(name + ", " + turns + "\r\n");
          bw.close();
          bw2.close();
          bw3.close();
          titleScreen();
          System.out.print("Enter Number Here:");
          nav = in.nextLine();//CONSOLE INPUT.
          if (nav.equals("1")) getInformation();
          else if (nav.equals("2")) helpPage();
          else if (nav.equals("3")) highscoresPage();
          else if (nav.equals("4")) aboutGame();
          else {
            System.out.println("Incorrect input, try again.");
            inputMain();
          }
        }
      }

      /**********************
        Method used to print the current card in the pile. 
      ***********************/  
      public static void checkPile() {
        System.out.println("The current card in the pile is " + cardInPileType + " with color " + cardInPileColor);
      }

      /************************
        Method used to reset variables when the game ends. 
      *************************/
      public static void reset() {
        CPU1cardsAmount = 6;
        CPU2cardsAmount = 6;
        CPU3cardsAmount = 6;
        turns = 0;
        cards = 6;
      }

      /**********************
        Method used to sort the highscores page in proper order. Method without parameters.
      ***********************/
      public static void highscores() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("names.txt"));//File reading inplemented.
        BufferedReader br2 = new BufferedReader(new FileReader("scores.txt"));//File reading inplemented.
        BufferedReader br3 = new BufferedReader(new FileReader("scoresAndNames.txt"));//File reading inplemented.
        BufferedReader br4 = new BufferedReader(new FileReader("names.txt"));//File reading inplemented.
        int temp = 0;
        String check = "";
        String checkScore = "";
        String line = "";
        String nameCheck = "";
        int counter = 0;
        for (int a = 0; line != null; a++) {
          line = br.readLine();
          if (line != null) counter++;
        }
        line = "";
        String[] names = new String[counter];//1D array.
        String[][] finalHighscoresArray = new String[counter][2];//2D array.
        int[] scores = new int[counter];//1D array.
        for (int x = 0; line != null; x++) {
          line = br4.readLine();
          if (line != null) names[x] = line;
        }
        line = "";
        for (int y = 0; line != null; y++) {
          int newScore = 0;
          line = br2.readLine();
          if (line != null) {
            newScore = Integer.parseInt(line);
            scores[y] = newScore;
          }
        }
        for (int i = 0; i < scores.length-1; i++) {
          for (int j = 0; j < scores.length-1-i; j++) {
            if (scores[j] > scores[j+1]) {
              temp = scores[j];
              scores[j] = scores[j+1];
              scores[j+1] = temp;
            }
          }
        }
        for (int k = 0; k < scores.length; k++) {
          if (scores[k] != 0) {
            checkScore = Integer.toString(scores[k]);
            check = br3.readLine();
            if (check != null) {
              if (check.contains(checkScore) == true) {
                finalHighscoresArray[k][0] = names[k];
                finalHighscoresArray[k][1] = checkScore;
              }
            }
          }
        }
        br.close();
        br2.close();
        br3.close();
        br4.close();
        stateHighscores(finalHighscoresArray, scores);
    }

    /**********************
      Method used to print the highscores in the highscores page. Method with parameters. Method with 2D array as parameter. 
    ***********************/
    public static void stateHighscores(String [][] array, int[] arrayNumbers) throws IOException {
      int counter = 1;
      System.out.println("Here are the current highscores: ");
      for (int i = 0; i < arrayNumbers.length; i++) {
        if (array[i][0] != null && array[i][1] != null) {
          System.out.println("Place: " + counter);
          System.out.println("Name: " + array[i][0]);
          System.out.println("Turns: " + array[i][1]);
          counter++;
        }
      }
    }
}
