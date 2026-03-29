
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class DeckOfCards{
  private String[] descriptionSuit2 = {"Clubs","Hearts","Spades","Diamonds"};
	
  private String[] descriptionSuit = {"1","2","3","4"};
  
  private String[] descriptionRank2 = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};

  private String[] descriptionRank = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
	private static String[] hand = new String[5];
	public ArrayList<String> cards = new ArrayList<String>();
  
  public DeckOfCards(){

  }

  public void createDeck(){
	for(int i = 0; i < 4; i++){
      for(int j = 0; j < 13; j++){
        cards.add(descriptionRank[j] + " of " + descriptionSuit[i]);
      }
    } 
  }

  public void shuffle() {
		int random = 0;
		int exe = 0;
		int size = cards.size();
		
	  for(int i = 0; i < 52; i++) {
			exe = (int) (Math.random() * size);
			random = (int) (Math.random() * size);
			Collections.swap(cards, random, exe);
		}
	}

  public void drawHand() {
	Scanner scan = new Scanner(System.in);
    for(int i = 0; i < 5; i++){
      hand[i] = cards.get(i);
      cards.remove(i);    
    } 
		
    for(int i = 0; i < 5; i++){
      // System.out.println(hand[i]);
      System.out.println(descriptionRank2[Integer.parseInt(getRank(i)) - 1] + " of " + descriptionSuit2[Integer.parseInt(hand[i].substring(hand[i].length() - 1, hand[i].length())) - 1]);
    }
   String user = "";

   System.out.println("If you are satsified with your hand type exit else type remove.");
    user = scan.nextLine();
    if(user.equals("remove")){
      System.out.println("Type out the numbers in this format \" 1 2 3 4 5 \" Do not type cards you dont want to remove.");
      int x = 0;
      int y = 1;
      int counter = 0;
      user = scan.nextLine();

      for(int l = 0; l < user.length(); l++){
        String z = user.substring(x,y);
        if(z.equals(" ")){
          counter++;
        }
        x++;
        y++;
      }
      x = 0;
      y = 1;
      
      for(int k = 0; k < user.length() - counter; k++){
        hand[Integer.parseInt(user.substring(x,y)) - 1] = cards.get(0);
        cards.remove(0);
        x += 2;
        y += 2;
      }

    for(int i = 0; i < 5; i++){
      // System.out.println(hand[i]);
      System.out.println(descriptionRank2[Integer.parseInt(getRank(i)) - 1] + " of " + descriptionSuit2[Integer.parseInt(hand[i].substring(hand[i].length() - 1, hand[i].length())) - 1]);
    }
    
	}
  }

  public void checkHand(){
    boolean np = false;
    boolean op = false;
    boolean tp = false;
    boolean tk = false;
    boolean s = false;
    boolean f = isFlush();
    boolean fh = false;
    boolean fk = false;
    boolean rf = false;
    
  }

  public static String getRank(int num){
    String cardRank = hand[num];
    String cR = "";
    if(cardRank.substring(1,2).equals((" "))){
      cR = cardRank.substring(0,1);
    } else {
      cR = cardRank.substring(0,2);
    }

    return cR;
  }

  public static boolean isFlush(){
    String suit = hand[0].substring(hand[0].length() - 2, hand[0].length() - 1);
    for(int i = 1; i < 5; i++){
      if(hand[i].substring(hand[i].length() - 2, hand[i].length() - 1) != suit){
        return false;   
      }
    }
    return true;
  }

  // Implements the method as if hand is an array not an ArrayList
  public static boolean isStraight(){
    for(int i = 1;  i < hand.length; i++){
       if(Integer.parseInt(hand[i].getRank()) != Integer.parseInt(hand[i - 1].getRank()) + 1){
         return false;
        }
    }
    return true;
  }
	


}
