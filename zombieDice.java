import java.util.*;

//2960774 Evandro Gomez Quintino
class zombieDice {

	// Turn global veriables
	public static int generalScore = 0;
	public static int turnScore = 0;
	public static int lives = 3;

	// Footprint global variables
	public static int footprints = 0;
	public static int diceGreen = 0;
	public static int diceYellow = 0;
	public static int diceRed = 0;
	public static int total_dice = 0;
	public static String random1 = "";
	public static String random2 = "";
	public static String random3 = "";

	// Player global variables
	public static ArrayList<String> players = new ArrayList<String>(0);
	public static int totalPlayers = 2;

	// The main menu / introduction
	public static void main(String[] args) {

		intro();
		menu();

	}

	// Introduction of the game
	public static void intro() {

		// User input
		Scanner enter = new Scanner(System.in);

		// Game's logo
		System.out.println(" _______  _______  _______  ______  _________ _______ ");
		System.out.println("/ ___   )(  ___  )(       )(  ___ \\ \\__   __/(  ____ \\              (()))");
		System.out.println("\\/   )  || (   ) || () () || (   ) )   ) (   | (    \\/             /|x x|");
		System.out.println("    /   )| |   | || || || || (__/ /    | |   | (__                /\\( - )");
		System.out.println("   /   / | |   | || |(_)| ||  __ (     | |   |  __)       ___.-._/\\/");
		System.out.println("  /   /  | |   | || |   | || (  \\ \\    | |   | (         /=`_'-'-'/  !!");
		System.out.println(" /   (_/\\| (___) || )   ( || \\___) )___) (___| (____/\\   |-{-_-_-}   !! !");
		System.out.println("(_______/(_______)|/     \\||_______/\\_______/(_______/   (-{-_-_-}    !");
		System.out.println("      	  ______  _________ _______  _______              \\{_-_-_}   !");
		System.out.println("     	 (  __  \\ \\__   __/(  ____ \\(  ____ \\              }-_-_-}    !");
		System.out.println("     	 | (  \\  )   ) (   | (    \\/| (    \\/              {-_|-_}    ! !");
		System.out.println("     	 | |   ) |   | |   | |      | (__                  {-_|_-}   !  !");
		System.out.println("     	 | |   | |   | |   | |      |  __)                 {_-|-_}   ! !");
		System.out.println("     	 | |   ) |   | |   | |      | (                    {_-|-_}    !");
		System.out.println("     	 | (__/  )___) (___| (____/\\| (____/\\          ____%%@ @%%_______");
		System.out.println("     	 (______/ \\_______/(_______/(_______/");

		// Welcome message based in games from 80-90's
		System.out.println("\n                  Press ENTER to START.");
		System.out.println("\n\n      © RAMISAR STUDIOS.LTD 2018 ALL RIGHTS RESERVED.");
		// User input
		enter.nextLine();

	}

	// Main menu Method
	public static void menu() {

		// User input
		Scanner kb = new Scanner(System.in);

		// Counter used for the looping when user is selecting an option
		int counter = 0;

		// Looping of the menu options
		while (counter != 1) {
			System.out.println("\n      1)New Game");
			System.out.println("      2)Credits");
			System.out.println("      3)Quit");

			// Var `Char` instead of integer because I was trying to avoid crash the game
			// when the user
			// types any different key
			char menuNumber = kb.next().charAt(0);

			// Acessing a New Game
			if (menuNumber == '1') {
				// User is transferred first to the tutorial section
				tutorial();
				counter++;
			}

			// Acessing the credits for the game
			else if (menuNumber == '2') {
				credits();
				counter++;
			}
			// Quitting the program
			else if (menuNumber == '3') {
				System.exit(0);
				counter++;
			}
			// Error msg
			else {
				System.out.println("------------------------------------------");
				System.out.println("|Please provide one of the options below!|");
				System.out.println("------------------------------------------");
			}

		}

	}

	// Tutorial Method - Rules
	public static void tutorial() {

		// Counter for the lopping when selecting tutorial's options
		int counter = 0;

		// User input
		Scanner kb = new Scanner(System.in);

		// Looping created to get user's choice
		while (counter != 1) {
			// User has the option of skip the tutorial section
			System.out.println("      Would you like to read the instructions?");
			System.out.println("      1)Yes        2)No");

			// Var `Char` instead of integer because I was trying to avoid crash the game
			// when the user
			// types any different key
			char skip_tutorial = kb.next().charAt(0);

			// User skips this section and goes for the next section
			if (skip_tutorial == '2') {
				counter++;

				// User reads the instructions
			} else if (skip_tutorial == '1') {

				System.out.println(
						"      ***** Game Rules ****** \n\n      On each turn, the game will generate three randomly dice. Each one represents a human victim.  \n      There are 3 different types of dice in the game:");
				System.out.println(
						"\n      - Red: the toughest. They have 3 Shotguns sides, 2 Footprints sides and 1 Brain side");
				System.out.println(
						"      - Green: the easiest.  They have 1 Shotgun side, 2 Footprints sides and 3 Brains sides");
				System.out.println(
						"      - Yellow: the medium tough. They have 2 Shotguns sides, 2 Footprints sides and 2 Brains sides");
				System.out.println(
						"\n      -Brain: You ate your victim's brain. \n      Wins the game the first player who reaches 13 brains.");
				System.out.println(
						"\n      -Shotgun: The victim fought back! \n      You were attacked by the victim and accumulating three shoots will result in the end of your turn (losing the brains won this turn).");
				System.out
						.println("\n      -Footprints: Your victim escaped.\n      Save this dice for the next turn.");
				System.out.println(
						"\n      Every turn you have the option of 'RollTheDice!' to try your luck with the dices or \n      'Pass&Save!' which finishes your turn and save the brains won on your turn.");
				System.out.println("\n      ***** Good Luck! ***** ");
				counter++;

				// Error msg
			} else {
				System.out.println("      ------------------------------------------");
				System.out.println("      |Please provide one of the options below!|");
				System.out.println("      ------------------------------------------");
			}
		}

		// User moves to the main method of this program
		newgame();
	}

	// The main method of my project
	public static void newgame() {

		// User input
		Scanner option = new Scanner(System.in);

		// Player's choice
		int playerOption = 0;

		// First, second and third dices
		int diceRolling1 = 0;
		int diceRolling2 = 0;
		int diceRolling3 = 0;

		// Random dices results
		Random rand = new Random();

		// Getting player's name
		playersName();

		// Player's Turn
		// The turn's number is similar to player's index position in the ArrayList
		int turn = 0;

		// Array created to save player's score. Size is linked with total of players.
		// Player index [0] in the ArrayList will correspond to Score [0] in the Array
		// above
		int[] playerScore = new int[totalPlayers];

		// Infinite lopping created intentionally
		while (turn < totalPlayers) {

			// Main looping for the turn
			while (playerScore[turn] < 13) {

				// Player's turn message
				System.out.println("\n      *****************************");
				System.out.println("               " + players.get(turn) + " Turn");
				System.out.println("      *****************************");

				// User's game option.
				// Selected 1: Play the dices
				// Selectec 2: Pass the turn and save the turn's score
				// Selected 3: Quit the game.
				System.out.println("\n      1)Roll the Dice!      2)Pass&Save         3)Quit ");

				// User input
				playerOption = option.nextInt();

				// Selected 2: Pass the turn and save the brains collected this turn.
				if (playerOption == 2) {

					// Sum total score with the score saved this turn
					playerScore[turn] = playerScore[turn] + turnScore;

					// Reset lives, score of the turn and any footprint saved this turn
					lives = 3;
					turnScore = 0;
					footprints = 0;

					// User's message showing total of brains so far
					System.out.println("              You have saved some brains!");
					System.out.println("                  Total of Brains: " + playerScore[turn] + "\n\n");

					// Checks if the user has reached the total score or higher
					if (playerScore[turn] >= 13) {

						// Congratulations message
						System.out.println("\n\n      Congratulations " + players.get(turn) + "!");

						// USer has option to play it again
						System.out.println("      You have eaten 13 victims! Would you like to play it again?");
						System.out.println("      1) Yes       2) No");

						// User input
						playerOption = option.nextInt();

						// Selected 1: Array with scores is reseted and a newgame start
						if (playerOption == 1) {
							playerScore = null;
							newgame();
						}

						// Checks if user wants to quit the game. Clear the array and return to the menu
						else {
							playerScore = null;
							menu();
						}
					}

					// Turn increased, resulting in the next player's turn
					turn++;

					// Statement created to keep the 'turn' level linked with the Arrays's index.
					// Creating a looping.
					if (turn == totalPlayers) {
						turn = 0;
					}

					// Breaking this looping so the program can move back to the previous looping
					// and restart the process, resulting
					// in the next player's turn
					break;
				}

				// Selected 1: Player rolls the dice
				if (playerOption == 1) {

					// The logic here is deduce the total of footprints from the total of dices per
					// turn (3)
					// So I can play the correct number of dices per turn. Saving the footprints to
					// be played separately
					total_dice = 3 - footprints;

					// Dices ordened by position: first, second, third.
					diceRolling1 = 0;
					diceRolling2 = 0;
					diceRolling3 = 0;

					// Checks if total of dices is 1 (deducting footprints) . Plays only one dice
					if (total_dice == 1) {
						diceRolling1 = rand.nextInt(13) + 1;

						// Reset total of dices
						total_dice = 0;

						// Checks if total of dices is 2 (deducting footprints). Plays two dices
					} else if (total_dice == 2) {
						diceRolling1 = rand.nextInt(13) + 1;
						diceRolling2 = rand.nextInt(13) + 1;

						// Reset total of dices
						total_dice = 0;

						// Checks if total of dices is 3. Plays all dices
					} else if (total_dice == 3) {
						diceRolling1 = rand.nextInt(13) + 1;
						diceRolling2 = rand.nextInt(13) + 1;
						diceRolling3 = rand.nextInt(13) + 1;

						// Reset total of dices
						total_dice = 0;
					}

					// Counter created because otherwise the lopping would create more dices if used
					// the 'footprints' variable.
					int footCounter = footprints;

					// Looping used to check number of footprints and print the specific color
					while (footCounter > 0) {

						// Checks how many green footprints the user has and print a new random
						// greendice.
						if (diceGreen > 0) {
							diceGreen--;
							footprints--;
							footCounter--;
							green_dice();
							System.out.println("      (Green Footprint from the Previous Turn)");
						}
						// Checks how many yellow footprints the user has and print a new random
						// yellowdice.
						else if (diceYellow > 0) {
							diceYellow--;
							footprints--;
							footCounter--;
							yellow_dice();
							System.out.println("      (Yellow Footprint from the Previous Turn)");
						}
						// Checks how many red footprints the user has and print a new random reddice.
						else if (diceRed > 0) {
							diceRed--;
							footprints--;
							footCounter--;
							red_dice();
							System.out.println("      (Red Footprint from the Previous Turn)");
						}
					}
				}

				/*
				 * After check how many dices the user has deducting the footprints; And after
				 * playing the specific number of footprints; The program will check the random
				 * number generate between 1-13 for dicesRolling and apply one of the statements
				 * below.
				 * 
				 * The game consists in:
				 * 
				 * 6 Green Dices 4 Yellow Dices 3 Red Dices
				 * 
				 */

				// Checks value bigger than 10 and plays a redDice for first position
				if (diceRolling1 >= 11) {
					red_dice();
				}
				// Checks value bigger than 6 and plays a yellowDice for first position
				else if (diceRolling1 >= 7) {
					yellow_dice();
				}
				// Checks value bigger than 0 and plays a greenDice for first position
				else if (diceRolling1 >= 1) {
					green_dice();
				}

				// Checks value bigger than 10 and plays a redDice for second position
				if (diceRolling2 >= 11) {
					red_dice();
				}
				// Checks value bigger than 6 and plays a yellowDice for second position
				else if (diceRolling2 >= 7) {
					yellow_dice();
				}
				// Checks value bigger than 0 and plays a greenDice for second position
				else if (diceRolling2 >= 1) {
					green_dice();
				}
				// Checks value bigger than 10 and plays a redDice for third position
				if (diceRolling3 >= 11) {
					red_dice();
				}
				// Checks value bigger than 6 and plays a yellowDice for third position
				else if (diceRolling3 >= 7) {
					yellow_dice();
				}
				// Checks value bigger than 0 and plays a greenDice for third position
				else if (diceRolling3 >= 1) {
					green_dice();
				}

				// If user decide to quit the game
				if (playerOption == 3) {
					menu();
				}

				// Checks if user has lost all lives
				if (lives <= 0) {
					// Reset score, footprints and lives
					turnScore = 0;
					footprints = 0;
					lives = 3;

					// User message and total score so far
					System.out.println("\n********************************************************");
					System.out.println("*            You have lost all your lives!!!           *");
					System.out.println(
							"*                 Total Brains Saved: " + playerScore[turn] + "                *");
					System.out.println("********************************************************");

					// Moves to the next turn
					turn++;

					// Statement created to keep the 'turn' level linked with the Arrays's index.
					// Creating a looping.
					if (turn == totalPlayers) {
						turn = 0;
					}

					// Breaking this looping so the program can move back to the previous looping
					// and restart the process, resulting
					// in the next player's turn
					break;
				}

				System.out.println("\n      Score: " + turnScore + "         Lives:" + lives + "\n\n      Total Score:"
						+ playerScore[turn]);

			}
		}
	}

	// Gets name and quantity of players
	public static void playersName() {

		// User input
		Scanner kb = new Scanner(System.in);

		// Option Menu
		char option = 0;

		// Total players + counters
		int counter = 0;
		int playerNumber = 1;
		String playerName = "";

		// User message regarding the minimum of players
		System.out.println("\n\n-----------------------------------------------------------------------------------");
		System.out.println("\n\n      This game should be played by at least two players.");

		// Looping to get the user's option
		while (option != 1) {
			// User has the option to increase the arrayList unlimited
			System.out.println("\n      Would you like to increase the number of players?");
			System.out.println("      1) Yes        2) No");

			// Var `Char` instead of integer because I was trying to avoid crash the game
			// when the user
			// types any different key
			char playersOption = kb.next().charAt(0);

			// Selected 1: user increase the number of players
			if (playersOption == '1') {
				System.out.println("      Please inform the number of players to be increased:");
				// User input
				totalPlayers = totalPlayers + kb.nextInt();
				// Clear the Scanner
				kb.nextLine();
				// Counter increased so the looping finishes
				option++;
			}

			// Selected 2: user increase the number of players
			else if (playersOption == '2') {
				// Clear the Scanner
				kb.nextLine();
				// Counter increased so the looping finishes
				option++;
			}

			// Error message
			else {
				System.out.println("      ------------------------------------------");
				System.out.println("      |Please provide one of the options below!|");
				System.out.println("      ------------------------------------------");
			}
		}
		// Counter created to get player's names
		counter = totalPlayers;
		// Clears players list before getting names because the user could be playing
		// for the second time.
		players.clear();

		// Looping to get the player's name
		while (counter > 0) {
			// Message increasing the player's number for each loop
			System.out.print("      Zombie " + playerNumber + ": ");
			// User input
			playerName = kb.nextLine();
			// Adding name to the list
			players.add(playerName);
			// Increasing player's number
			playerNumber++;
			// Reducing counter
			counter--;
		}

	}

	// Credist Method
	public static void credits() {

		// A thanks message for the user
		System.out.println("\n\n      Thank you for playing the 'ZombieDice' game. I hope that you have enjoyed!");
		System.out.println(
				"\n\n      My name is Evandro and I'm a young program developer, coursing Griffith College.\n      I wish to become in the future a game designer and have my own game studio (Ramisar Studios) so I hope that you \n      find my code clear and easy to understand. \n      Sorry by any mistake but I'm still practing, thanks!");
		// My future studio
		System.out.println("        ____                 _                  ____  _             _ _");
		System.out.println("       |  _ \\ __ _ _ __ ___ (_)___  __ _ _ __  / ___|| |_ _   _  __| (_) ___  ___ ");
		System.out.println("       | |_) / _` | '_ ` _ \\| / __|/ _` | '__| \\___ \\| __| | | |/ _` | |/ _ \\/ __|");
		System.out.println("       |  _ < (_| | | | | | | \\__ \\ (_| | |     ___) | |_| |_| | (_| | | (_) \\__ \\");
		System.out.println("       |_| \\_\\__,_|_| |_| |_|_|___/\\__,_|_|    |____/ \\__|\\__,_|\\__,_|_|\\___/|___/");

		// Waiting key
		System.out.println("\n\n      Press any KEY to Return.");

		// User input
		Scanner kb = new Scanner(System.in);
		// Clear scanner
		kb.nextLine();
		// Back to menu method
		menu();

	}

	// Dices rolling methods divided by color
	// Green Dices
	public static void green_dice() {
		// Array list for the dices.
		// I have chosen to use Strings instead of numbers just because it is easier to
		// read the code this way
		String[] greenDice = { "Brain", "Brain", "Brain", "Footprint", "Footprint", "Shoot" };

		// Getting a random POSITION
		int idx = new Random().nextInt(greenDice.length);
		random1 = (greenDice[idx]);

		// Checks if dice is a Brain. Prints brains image
		if (random1 == "Brain") {
			System.out.println("\n      Green Dice");
			brain();
		}
		// Checks if dice is a Footprint. Prints footprints image
		else if (random1 == "Footprint") {
			System.out.println("\n      Green Dice");
			footprint();
			// Increase number of footprints in general
			footprints = footprints + 1;
			// Increase number of green Footprints
			diceGreen = diceGreen + 1;
		}
		// Checks if dice is a Shoot. Prints shoots image
		else if (random1 == "Shoot") {
			System.out.println("\n      Green Dice");
			shoot();
		}
	}

	// Yellow Dices
	public static void yellow_dice() {

		// Array list for the dices.
		// I have chosen to use Strings instead of numbers just because it is easier to
		// read the code this way
		String[] yellowDice = { "Brain", "Brain", "Shoot", "Shoot", "Footprint", "Footprint" };

		// Getting a random POSITION
		int idx = new Random().nextInt(yellowDice.length);
		random2 = (yellowDice[idx]);

		// Checks if dice is a Brain. Prints brains image
		if (random2 == "Brain") {
			System.out.println("\n      Yellow Dice");
			brain();
		}
		// Checks if dice is a Footprint. Prints footprints image
		else if (random2 == "Footprint") {
			System.out.println("\n      Yellow Dice");
			footprint();
			// Increase number of footprints in general
			footprints = footprints + 1;
			// Increase number of yellow Footprints
			diceYellow = diceYellow + 1;
		}
		// Checks if dice is a Shoot. Prints shoots image
		else if (random2 == "Shoot") {
			System.out.println("\n      Yellow Dice");
			shoot();
		}
	}

	// Red Dices
	public static void red_dice() {

		// Array list for the dices.
		// I have chosen to use Strings instead of numbers just because it is easier to
		// read the code this way
		String[] redDice = { "Brain", "Shoot", "Shoot", "Shoot", "Footprint", "Footprint" };

		// Getting a random POSITION
		int idx = new Random().nextInt(redDice.length);
		random3 = (redDice[idx]);
		// Checks if dice is a Brain. Prints brains image
		if (random3 == "Brain") {
			System.out.println("\n      Red Dice");
			brain();
		}
		// Checks if dice is a Footprint. Prints footprints image
		else if (random3 == "Footprint") {
			System.out.println("\n      Red Dice");
			footprint();
			// Increase number of footprints in general
			footprints = footprints + 1;
			// Increase number of red Footprints
			diceRed = diceRed + 1;
		}
		// Checks if dice is a Shoot. Prints shoots image
		else if (random3 == "Shoot") {
			System.out.println("\n      Red Dice");
			shoot();
		}
	}

	// Brain ASCII Image
	public static void brain() {
		// Increase score
		turnScore++;
		System.out.println("       ________________________");
		System.out.println("      |      _---~~(~~-_.      |");
		System.out.println("      |    _{        )   )     |");
		System.out.println("      |  ,   ) -~~- ( ,-' )_   |");
		System.out.println("      | (  `-,_..`., )-- '_,)  |");
		System.out.println("      |( ` _)  (  -~( -_ `,  } |");
		System.out.println("      |(_-  _  ~_-~~~~`,  ,' ) |");
		System.out.println("      |  `~ -^(    __;-,((())) |");
		System.out.println("      |        ~~~~ {_ -_(())  |");
		System.out.println("      |               `\\  }    |");
		System.out.println("      |                 { }    |");
		System.out.println("      |________________________|");

	}

	// Footprint ASCII Text
	public static void footprint() {
		System.out.println("       ________________________");
		System.out.println("      |             ,-.        |");
		System.out.println("      |             (  \\()Oo   |");
		System.out.println("      |              `-,---.   |");
		System.out.println("      |      .-.       \\   |   |");
		System.out.println("      | oO()/   )       \\  \\   |");
		System.out.println("      | ,--- ,-'         |_/   |");
		System.out.println("      | |   /            ,-.   |");
		System.out.println("      | / _/             |_/   |");
		System.out.println("      | \\_/                    |");
		System.out.println("      | ,-.                    |");
		System.out.println("      | \\_/                    |");
		System.out.println("      |________________________|");
	}

	// Gunfire ASCII Text
	public static void shoot() {
		// Decrease lives
		lives--;
		System.out.println("       ________________________");
		System.out.println("      |                        |");
		System.out.println("      |                        |");
		System.out.println("      |                        |");
		System.out.println("      |  _  _________.-------. |");
		System.out.println("      |  \\`'  _______|_______| |");
		System.out.println("      |  /   (_(_]             |");
		System.out.println("      | |    |                 |");
		System.out.println("      | |.' '|                 |");
		System.out.println("      | |____]                 |");
		System.out.println("      |                        |");
		System.out.println("      |                        |");
		System.out.println("      |________________________|");

	}

}