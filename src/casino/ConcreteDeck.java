package casino;

import java.util.Random;

public class ConcreteDeck  implements Deck{

	private Card[] cards = null; 
	
	/*
	 * public Constructor with arguments.
	 */
	public ConcreteDeck() {
		cards = new Card[52];
		for (int suit = 0, card = 0; suit < 4; suit++) {
			for (int rank = 1; rank <= 13; rank++, card++) {
				cards[card] = new Card(suit, rank);
			}
		}
	}
	
	/*
	 * returns a String representation of the array of Card
	 * e.g Ace of Clubs, Two of Clubs, Three of Clubs,..
	 */
	public String toString(){
		String deck = "";
		for (int i = 0; i < cards.length; i++) {
			deck += cards[i]; // My initial version had a redundant .toString() here.
			if (i < cards.length - 1) { // Stops list from ending on a comma that trails off.
				deck += ", ";
			}
		}
		return deck;
	}
	
	@Override
	public void shuffle(){
		Random r = new Random(); // I personally prefer to get random numbers using the java.util.Random class.
		for (int i = 0; i < cards.length; i++) {
			Card temp;
			int swapWith;
			while ((swapWith = r.nextInt(cards.length)) == i);
			
			temp = cards[i];
			cards[i] = cards[swapWith];
			cards[swapWith] = temp;
		}
	}
	
	@Override
	public Card removeTopCard(){
		Card topCard = cards[0];
		Card[] newCards = new Card[cards.length - 1];
		for (int i = 0; i < newCards.length; i++) {
			newCards[i] = cards[i + 1];
		}
		cards = newCards;
		return topCard;
	}
}
