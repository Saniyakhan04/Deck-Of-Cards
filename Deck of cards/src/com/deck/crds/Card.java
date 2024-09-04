package com.deck.crds;
import java.util.*;
public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
}

class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {// 4
			for (Rank rank : Rank.values()) {// 13
				cards.add(new Card(suit, rank));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card drawCard() {
		if (cards.isEmpty()) {
			throw new NoSuchElementException("Deck is empty");
		}
		return cards.remove(0);
	}

	public int size() {
		return cards.size();
	}
}

@Deprecated
class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card card1, Card card2) {
		// Compare by color first
		int colorComparison = Integer.compare(card1.getSuit().ordinal() % 2, card2.getSuit().ordinal() % 2);
		if (colorComparison != 0) {
			return colorComparison;
		}

		// Compare by suit within color
		int suitComparison = Integer.compare(card1.getSuit().ordinal(), card2.getSuit().ordinal());
		if (suitComparison != 0) {
			return suitComparison;
		}

		// Compare by rank value
		return Integer.compare(card1.getRank().getValue(), card2.getRank().getValue());
	}
}