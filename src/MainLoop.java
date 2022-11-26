public class MainLoop {

    public static void main(String[] args) {

        // create a new deck
        // run a simulation
        // print the results


        CardDeck deck = new CardDeck();
        Card[] heroCards = new Card[2];
        Card[][] villainCards = new Card[2][2];

        heroCards[0] = new Card(Card.ACE, Card.CLUBS);
        heroCards[1] = new Card(Card.ACE, Card.DIAMONDS);
        System.out.println("Hero Cards: " + heroCards[0].toString() + " & " + heroCards[1].toString());

        villainCards[0][0] = new Card(Card.QUEEN, Card.HEARTS);
        villainCards[0][1] = new Card(Card.DEUCE, Card.SPADES);
        System.out.println("Villain 1 Cards: " + villainCards[0][0].toString() + " & " + villainCards[0][1].toString());

        villainCards[1][0] = new Card(Card.JACK, Card.DIAMONDS);
        villainCards[1][1] = new Card(Card.JACK, Card.HEARTS);
        System.out.println("Villain 2 Cards: " + villainCards[1][0].toString() + " & " + villainCards[1][1].toString());

        EquityCalculator calculator = new EquityCalculator(2, 100000 , heroCards, villainCards);
        calculator.runSimulation();
        calculator.printResults();


    }


    public void randomSim() {
        CardDeck deck = new CardDeck();
        Card[] heroCards = new Card[2];
        Card[][] villainCards = new Card[2][2];

        heroCards[0] = deck.getRandCard();
        heroCards[1] = deck.getRandCard();
        System.out.println("Hero Cards: " + heroCards[0].toString() + " & " + heroCards[1].toString());

        villainCards[0][0] = deck.getRandCard();
        villainCards[0][1] = deck.getRandCard();
        System.out.println("Villain 1 Cards: " + villainCards[0][0].toString() + " & " + villainCards[0][1].toString());

        villainCards[1][0] = deck.getRandCard();
        villainCards[1][1] = deck.getRandCard();
        System.out.println("Villain 2 Cards: " + villainCards[1][0].toString() + " & " + villainCards[1][1].toString());

        EquityCalculator calculator = new EquityCalculator(2, 100000, heroCards, villainCards);
        calculator.runSimulation();
        calculator.printResults();
    }

}
