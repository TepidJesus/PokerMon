public class EquityCalculator {
    int numHeros;
    int numVillains;
    int heroWins;
    int villainWins;
    int numSimulations;

    Card[] heroCards;
    Card[][] villainCards;


    EquityCalculator() {
        this.numHeros = 1;
        this.numVillains = 1;
        this.heroWins = 0;
        this.villainWins = 0;
        this.numSimulations = 10000;
    }

    EquityCalculator (int numVillains, int numSimulations, Card[] heroCards, Card[][] villainCards) {
        this.numHeros = 1;
        this.heroCards = heroCards;

        this.numVillains = numVillains;
        this.villainCards = villainCards;

        this.heroWins = 0;
        this.villainWins = 0;

        this.numSimulations = numSimulations;
    }

    public void runSimulation() {

        CardDeck deckTemplate = new CardDeck();

        for (Card card : heroCards) {
            deckTemplate.removeCard(card);
        }

        for (Card[] villain : villainCards) {
            for (Card card : villain) {
                deckTemplate.removeCard(card);
            }
        }



        // Simulation Starts Here
        for (int i = 0; i < numSimulations; i++) {
            CardDeck deck = new CardDeck(deckTemplate.deck);
            Card[] board = new Card[5];

            // Getting the board
            for (int j = 0; j < 5; j++) {
                board[j] = deck.getRandCard();
            }

            int boardStrength = 0;
            boardStrength = (Card[] cards);

            // Finding Heroes Max Hand Strength
            // Implement a 7 choose 5 algorithm
            int heroMaxHandStrength = 0;
            for (int j = 0; j < 7; j++) {
                for (int k = j + 1; k < 7; k++) {
                    Card[] heroHand = new Card[2];
                    heroHand[0] = heroCards[j];
                    heroHand[1] = heroCards[k];
                    int heroHandStrength = evaluateHand(this.heroCards, board);
                    if (heroHandStrength < heroMaxHandStrength) {
                        heroMaxHandStrength = heroHandStrength;
                    }
                }
            }



            // Create a new deck
            // Deal the heroHand and the villainHands
            // Determine the winner
            // Update the win counts
        }
    }

    public int evaluateHand(Card[] cards) {
        int handStrength = 0;



        return handStrength;

    }

}
