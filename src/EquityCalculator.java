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
            boardStrength = evaluateHand(board);

            int heroMaxHandStrength = 0;
            Card[] combinedCards = new Card[7];
            System.arraycopy(heroCards, 0, combinedCards, 0, 2);
            System.arraycopy(board, 0, combinedCards, 2, 5);

            Card[][] heroCombinations = getCombinations(combinedCards, 5);

            for (Card[] heroHand : heroCombinations) {
                int heroHandStrength = evaluateHand(heroHand);
                if (heroHandStrength < heroMaxHandStrength) {
                    heroMaxHandStrength = heroHandStrength;
                }
            }

            // Create a new deck
            // Deal the heroHand and the villainHands
            // Determine the winner
            // Update the win counts
        }
    }

    public int evaluateHand(Card[] cards) {

        final int c1 = cards[0].getValue();
        final int c2 = cards[1].getValue();
        final int c3 = cards[2].getValue();
        final int c4 = cards[3].getValue();
        final int c5 = cards[4].getValue();


        final int index = (c1 | c2 | c3 | c4 | c5) >> 16;

        if ((c1 & c2 & c3 & c4 & c5 & 0xF000) != 0) {
            return HandTables.Flushes.TABLE[index];
        }

        // Straight and high card hands
        final int value = HandTables.Unique.TABLE[index];
        if (value != 0) {
            return value;
        }

        // Remaining cards
        final int product = (c1 & 0xFF) * (c2 & 0xFF) * (c3 & 0xFF) * (c4 & 0xFF) * (c5 & 0xFF);
        return HandTables.Hash.Values.TABLE[hash(product)];

    }

    private static int hash(int key) {
        key += 0xE91AAA35;
        key ^= key >>> 16;
        key += key << 8;
        key ^= key >>> 4;
        return ((key + (key << 2)) >>> 19) ^ HandTables.Hash.Adjust.TABLE[(key >>> 8) & 0x1FF];
    }

    public Card[][] getCombinations(Card[] cards, int numCards) {
        Card[][] combinations = new Card[21][5];
        int index = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    for (int l = k + 1; l < cards.length; l++) {
                        for (int m = l + 1; m < cards.length; m++) {
                            combinations[index][0] = cards[i];
                            combinations[index][1] = cards[j];
                            combinations[index][2] = cards[k];
                            combinations[index][3] = cards[l];
                            combinations[index][4] = cards[m];
                            index++;
                        }
                    }
                }
            }
        }
        return combinations;
    }

}
