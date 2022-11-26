import java.util.ArrayList;
import java.security.SecureRandom;
public class CardDeck {
    ArrayList<Integer> suits = new ArrayList<Integer>() {{
        add(Card.HEARTS);
        add(Card.DIAMONDS);
        add(Card.SPADES);
        add(Card.CLUBS);
    }};

    ArrayList<Integer> values = new ArrayList<Integer>() {{
        add(0);
        add(1);
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

    }};

    ArrayList<Card> deck = new ArrayList<Card>();
    SecureRandom randomGen;
    CardDeck () {

         for (Integer suit : suits) {
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


