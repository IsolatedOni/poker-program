public class Main{
  public static void main(String[] args){
    DeckOfCards alpha = new DeckOfCards();
     alpha.createDeck();
     alpha.shuffle();
     alpha.drawHand();
     alpha.checkHand();
  }
}
