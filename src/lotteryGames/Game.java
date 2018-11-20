package lotteryGames;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		OriginalPlay originalPlay = new OriginalPlay();
		BackwardPlay backwardPlay = new BackwardPlay();

		System.out.println("Üdvözöljük a LOTTO játékban!");

		while (choice != 4) {
			printMenu();
			System.out.println("Kérjük válasszon a fenti opciókból: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				originalPlay.play(5, 90);
				break;
			case 2:
				originalPlay.play(6, 45);
				break;
			case 3:
				backwardPlay.play();
				break;
			case 4:
				System.out.println("Köszönjük a játékot!");
				break;
			default:
				System.out.println("--- Csak 1-4-ig tud választani! ---");
				break;
			}
		}

	}

	protected static void printMenu() {
		System.out.println("\nELÉRHETŐ JÁTÉKOK:\n 1: hagyományos LOTTO - 5 tipp a 90 számból "
				+ "\n 2: hagyományos LOTTO - 6 tipp a 45 számból "
				+ "\n 3: fordított LOTTO - addig folynak a húzások, amig nem lesz teli találatos a megadott öt tipp"
				+ "\n 4: KILÉPÉS");
		System.out.println();
	}

}
