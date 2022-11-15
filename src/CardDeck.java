import java.util.ArrayList;

public class CardDeck {

    private static class Card {
        int rank;
        String suit;

        Card (int value, String suit) {
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
    }

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

    CardDeck () {
         for (String suit : suits) {
             for (Integer value : values) {
                 deck.add(new Card(value, suit));
             }
         }

    }



}
