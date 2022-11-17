import java.util.ArrayList;
import java.security.SecureRandom;
public class CardDeck {
    ArrayList<String> suits = new ArrayList<String>() {{
        add("Hearts");
        add("Diamonds");
        add("Spades");
        add("Clubs");
    }};

    ArrayList<Integer> values = new ArrayList<Integer>() {{
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
        add(10);
        add(11);
        add(12);
        add(13);
        add(14);
    }};

    ArrayList<Card> deck = new ArrayList<Card>();
    SecureRandom randomGen;
    CardDeck () {

         for (String suit : suits) {
             for (Integer value : values) {
                 deck.add(new Card(value, suit));
             }
         }

         randomGen = new SecureRandom();

    }

    CardDeck(ArrayList<Card> deckTemplate) {

        deck.addAll(deckTemplate);
        randomGen = new SecureRandom();
    }

    public Card getRandCard() {
        // remove the card from the deck and return it
        int randomInt = randomGen.nextInt(deck.size());
        int rand = (int) (randomInt);
        return deck.remove(rand);
    }

    public void removeCard(Card card) {
        deck.remove(card);
    }

}

public class Card {

    int rank;
    String suit;
    private final int cardValue;

    // Card Ranks
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

    // Card Suits
    public static final int CLUBS = 0x8000;
    public static final int DIAMONDS = 0x4000;
    public static final int HEARTS = 0x2000;
    public static final int SPADES = 0x1000;

    // Card Rank symbols
    private static final String RANKS = "23456789TJQKA";
    private static final String SUITS = "shdc";


    Card(int rank, int suit) {

        this.cardValue = (1 << (rank + 16)) | suit | (rank << 8) | Tables.PRIMES[rank];

    }

    public String toString() {
        return this.rank + " of " + this.suit;
    }

    public int getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
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
        if (this.suit.equals(other.suit)) {
            return false;
        }
        return true;
    }
}
