public class EquityCalculator {
    // Run a Monte Carlo simulation to calculate the equity of a hand given by heroHand against hands given in a list of villainHands.
    // Two


    // The number of simulations to run in the Monte Carlo simulation is given by numSimulations

    int numHeros;
    int numVillains;
    int heroWins;
    int villainWins;
    int numSimulations;


    EquityCalculator() {
        this.numHeros = 1;
        this.numVillains = 1;
        this.heroWins = 0;
        this.villainWins = 0;
        this.numSimulations = 10000;
    }

    EquityCalculator (int numVillains, int numSimulations) {
        this.numHeros = 1;
        this.numVillains = numVillains;

        this.heroWins = 0;
        this.villainWins = 0;

        this.numSimulations = numSimulations;
    }

    public void runSimulation() {
        for (int i = 0; i < numSimulations; i++) {
            CardDeck deck = new CardDeck();
            // Create a new deck
            // Deal the heroHand and the villainHands
            // Determine the winner
            // Update the win counts
        }
    }

}
