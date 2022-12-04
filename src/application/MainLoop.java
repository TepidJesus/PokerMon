
package application;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainLoop extends Application {

    public static void main(String[] args) {

        launch(args);

        Card[] heroCards = new Card[2];
        Card[][] villainCards = new Card[2][2];

        heroCards[0] = new Card(Card.ACE, Card.CLUBS);
        heroCards[1] = new Card(Card.ACE, Card.DIAMONDS);

        villainCards[0][0] = new Card(Card.QUEEN, Card.HEARTS);
        villainCards[0][1] = new Card(Card.DEUCE, Card.SPADES);

        villainCards[1][0] = new Card(Card.TEN, Card.DIAMONDS);
        villainCards[1][1] = new Card(Card.JACK, Card.HEARTS);

        fixedSimulation(heroCards, villainCards, 1000);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);

        Image cornerIcon = new Image("file:images/icon.png");
        primaryStage.getIcons().add(cornerIcon);
        primaryStage.setTitle("PokerMon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void fixedSimulation(Card[] heroCards, Card[][] villainCards, int numSimulations) {
        CardDeck deck = new CardDeck();


        System.out.println("Hero Cards: " + heroCards[0].toString() + " & " + heroCards[1].toString());


        System.out.println("Villain 1 Cards: " + villainCards[0][0].toString() + " & " + villainCards[0][1].toString());


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
