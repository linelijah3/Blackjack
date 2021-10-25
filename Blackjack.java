import java.util.Scanner;

public class Blackjack {

    //method to display the menu options and user prompt
    static void displayMenu(){
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit\n");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        //initializing scanner object
        Scanner scnr = new Scanner(System.in);

        //boolean to be used in the while loop
        boolean isLooping = true;

        P1Random randomGen = new P1Random();

        //arrays for cards and their corresponding values
        String[] userCards = new String[] {"ACE","2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING"};
        int[] userCardValues = new int[] {1,2,3,4,5,6,7,8,9,10,10,10,10};

        //initializing and declaration of various variables to be used
        int gameNumber = 1;
        int playerWinCount = 0;
        int dealerWinCount = 0;
        int tieCount = 0;
        int playerSelection;
        int userCardNumber = randomGen.nextInt(13) + 1;
        int currentUserHandValue = 0;

        //initial printing of first card + menu + input
        System.out.println("START GAME #" + gameNumber + "\n");
        System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
        currentUserHandValue += userCardValues[userCardNumber - 1];
        System.out.println("Your hand is: " + currentUserHandValue + "\n");
        displayMenu();
        playerSelection = scnr.nextInt();

        //while loop used to accept integer values from 1 - 4, with corresponding code
while(isLooping){
    if (playerSelection == 1) {
        //code before if-elseif statement to deal player another card
        userCardNumber = randomGen.nextInt(13) + 1;
        System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
        currentUserHandValue += userCardValues[userCardNumber - 1];
        System.out.println("Your hand is: " + currentUserHandValue + "\n");

        //if-elseif branch for cases with different values of the user's hand
        if (currentUserHandValue > 21) {
            System.out.println("You exceeded 21! You lose.");

            //incrementing gameNumber and dealerWinCount after player loses
            dealerWinCount += 1;
            gameNumber += 1;

            System.out.println("START GAME #" + gameNumber + "\n");

            //resets hand value and user card value after a new game starts
            currentUserHandValue = 0;
            userCardNumber = randomGen.nextInt(13) + 1;
            System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
            currentUserHandValue += userCardValues[userCardNumber - 1];
            System.out.println("Your hand is: " + currentUserHandValue + "\n");
            displayMenu();
            playerSelection = scnr.nextInt();
        } else if(currentUserHandValue == 21){
            System.out.println("BLACKJACK! You win!");

            //incrementing gameNumber and playerWinCount after player wins
            playerWinCount += 1;
            gameNumber += 1;

            System.out.println("START GAME #" + gameNumber + "\n");

            //resets hand value and user card value after a new game starts
            currentUserHandValue = 0;
            userCardNumber = randomGen.nextInt(13) + 1;
            System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
            currentUserHandValue += userCardValues[userCardNumber - 1];
            System.out.println("Your hand is: " + currentUserHandValue + "\n");
            displayMenu();
            playerSelection = scnr.nextInt();
        } else {
            displayMenu();
            playerSelection = scnr.nextInt();
        }

    } else if (playerSelection == 2) {

        //code before if-elseif branch to generate the value of the dealer's hand
        int dealerHandValue = randomGen.nextInt(11) + 16;

        System.out.println("Dealer's hand: " + dealerHandValue);
        System.out.println("Your hand is: " + currentUserHandValue + "\n");

        //if-elseif branch for different values of dealer's hand when compared with other values
        if (dealerHandValue > 21) {
            System.out.println("You win!");

            //incrementing gameNumber and playerWinCount after player wins
            playerWinCount += 1;
            gameNumber += 1;

            System.out.println("START GAME #" + gameNumber + "\n");

            //resets hand value and user card value after a new game starts
            currentUserHandValue = 0;
            userCardNumber = randomGen.nextInt(13) + 1;
            System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
            currentUserHandValue += userCardValues[userCardNumber - 1];
            System.out.println("Your hand is: " + currentUserHandValue + "\n");
            displayMenu();
            playerSelection = scnr.nextInt();
        } else if (dealerHandValue == currentUserHandValue) {
            System.out.println("It's a tie! No one wins!");

            //incrementing gameNumber and tieCount after player and dealer tie
            tieCount += 1;
            gameNumber += 1;

            System.out.println("START GAME #" + gameNumber + "\n");

            //resets hand value and user card value after a new game starts
            currentUserHandValue = 0;
            userCardNumber = randomGen.nextInt(13) + 1;
            System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
            currentUserHandValue += userCardValues[userCardNumber - 1];
            System.out.println("Your hand is: " + currentUserHandValue + "\n");
            displayMenu();
            playerSelection = scnr.nextInt();
        } else if (dealerHandValue > currentUserHandValue) {
            System.out.println("Dealer wins!");

            //incrementing gameNumber and dealerWinCount after player loses
            dealerWinCount += 1;
            gameNumber += 1;

            System.out.println("START GAME #" + gameNumber + "\n");

            //resets hand value and user card value after a new game starts
            currentUserHandValue = 0;
            userCardNumber = randomGen.nextInt(13) + 1;
            System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
            currentUserHandValue += userCardValues[userCardNumber - 1];
            System.out.println("Your hand is: " + currentUserHandValue + "\n");
            displayMenu();
            playerSelection = scnr.nextInt();
        } else {
            System.out.println("You win!");

            //incrementing gameNumber and playerWinCount after player wins
            playerWinCount += 1;
            gameNumber += 1;

            System.out.println("START GAME #" + gameNumber + "\n");

            //resets hand value and user card value after a new game starts
            currentUserHandValue = 0;
            userCardNumber = randomGen.nextInt(13) + 1;
            System.out.println("Your card is a " + userCards[userCardNumber - 1] + "!");
            currentUserHandValue += userCardValues[userCardNumber - 1];
            System.out.println("Your hand is: " + currentUserHandValue + "\n");
            displayMenu();
            playerSelection = scnr.nextInt();
        }
    } else if (playerSelection == 3) {
        System.out.println("Number of Player wins: " + playerWinCount);
        System.out.println("Number of Dealer wins: " + dealerWinCount);
        System.out.println("Number of tie games: " + tieCount);
        System.out.println("Total # of games played is: " + (gameNumber - 1));

        //double to display percentage with correct amount of decimal points
        double percentagePlayerWins = 100.0 * playerWinCount / (gameNumber - 1);
        System.out.println("Percentage of Player wins: " + percentagePlayerWins + "%");
        displayMenu();
        playerSelection = scnr.nextInt();
    } else if (playerSelection == 4) {

        //exits the program because condition for while loop no longer met
        isLooping = false;
    } else {

        //redisplays menu and prompts user for a valid integer
        System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
        displayMenu();
        playerSelection = scnr.nextInt();
    }
}
    }
}