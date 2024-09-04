package com.deck.crds;

enum Suit {
	HEARTS(1), SPADES(3), DIAMONDS(2), CLUBS(4);

//H D   S C
	private final int value;

	private Suit(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
