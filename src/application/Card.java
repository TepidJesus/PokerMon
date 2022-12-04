package application;

public class Card {

    int rank;
    int suit;
    private final int cardValue;

    // application.Card Ranks
    public static final int DEUCE = 0;
    public static final int THREE = 1;
    public static final int FOUR = 2;
    public static final int FIVE = 3;
    public static final int SIX = 4;
    public static final int SEVEN = 5;
    public static final int EIGHT = 6;
    public static final int NINE = 7;
    public static final int TEN = 8;
    public static final int JACK = 9;
    public static final int QUEEN = 10;
    public static final int KING = 11;
    public static final int ACE = 12;

    // application.Card Suits
    public static final int CLUBS = 0x8000; // 32768
    public static final int DIAMONDS = 0x4000; // 16384
    public static final int HEARTS = 0x2000; // 8192
    public static final int SPADES = 0x1000; // 4096

    // application.Card Rank symbols
    private static final String RANKS = "23456789TJQKA";
    private static final String SUITS = "shdc";


    Card(int rank, int suit) {

        this.cardValue = (1 << (rank + 16)) | suit | (rank << 8) | HandTables.PRIMES[rank];
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return this.rank + " of " + this.suit;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    public int getValue() {
        return cardValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Card.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Card other = (Card) obj;
        if (this.rank != other.rank) {
            return false;
        }
        if (this.suit != other.suit) {
            return false;
        }
        return true;
    }
}