package casino;

public class ConcreteHand  implements Hand{
	
	private Card[] cards;
	private int cardsAdded;

	public ConcreteHand(int n){
		cards = new Card[n];
		cardsAdded = 0;
	}
	
	/*
	 * This method adds a Card to the cards array
	 */
	
	public void addCard(Card card){
		//You'll need to have kept track of how many cards have been added already
		//so that you add the card in the right place (i.e. immediately after the last added one)
		cards[cardsAdded++] = card;
	}
	
	/*
	 * This method prints out the hand
	 * e.g. Ace of Clubs, 3 of Diamonds, Jack of Hearts, etc
	 */
	
	public void show() {
		String hand = "Hand: ";
		for (int i = 0; i < cards.length; i++) {
			hand += cards[i]; // My initial version had a redundant .toString() here.
			if (i < cards.length - 1) { // Stops list from ending on a comma that trails off.
				hand += ", ";
			}
		}
		hand += "\n";
		System.out.print(hand);
	}
}
