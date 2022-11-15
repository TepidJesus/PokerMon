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
    SecureRandom randomGen = new SecureRandom();
    CardDeck () {

         for (String suit : suits) {
             for (Integer value : values) {
                 deck.add(new Card(value, suit));
             }
         }

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

    private static class Card {
        int rank;
        String suit;

        Card(int value, String suit) {
            this.rank = value;
            this.suit = suit;

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



}
