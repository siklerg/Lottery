package lotteryGames;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OriginalPlay {

	Random generator = new Random();
	Scanner scanner = new Scanner(System.in);

	ArrayList<Integer> tipps = new ArrayList<Integer>();
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	ArrayList<Integer> matchingNumbers = new ArrayList<Integer>();
	int numberOfHits;

	/** Játék futtatása */
	public void play(int numberOfTips, int maxNumber) {
		makingTipps(numberOfTips, maxNumber);
		generateNumbers(maxNumber);
		System.out.println("A nyerő számok: " + numbers);
		checkNumbers();
		System.out.println(numberOfHits == 0 ? "Sajnos nincs találat!"
				: "Találatok száma: " + numberOfHits + "\nEltalált számok: " + matchingNumbers);
	}

	/** Tippek bekérése */
	protected void makingTipps(int numberOfTips, int maxNumber) {
		System.out.println();
		System.out.println("Kérjük adja meg a tippjeit!");
		int tipp;
		for (int i = 0; i < numberOfTips; i++) {
			System.out.print(i + 1 + ". tipp? ");
			tipp = scanner.nextInt();
			while ((tipp < 1 || tipp > maxNumber) || (tipps.contains(tipp))) {
				System.out.println(tipps.contains(tipp) ? "--- Ez a szám már volt! ---" : "--- A számnak 1 és 90 közé kell esnie! ---");
				System.out.print(i + 1 + ". tipp? ");
				tipp = scanner.nextInt();
			}
			tipps.add(tipp);
		}
		sort(tipps);
		System.out.println("A tippek növekő sorrendben: " + tipps);
		System.out.println();
	}

	/** Nyerő számok generálása és rendezése */
	protected ArrayList<Integer> generateNumbers(int maxNumber) {

		// generálás
		int actualNumber = generator.nextInt(maxNumber) + 1;
		numbers.add(actualNumber);
		for (int i = 0; i < 4; i++) {
			actualNumber = generator.nextInt(maxNumber) + 1;
			while (numbers.contains(actualNumber)) {
				actualNumber = generator.nextInt(maxNumber) + 1;
			}
			numbers.add(actualNumber);
		}
		sort(numbers);
		return numbers;
	}

	/** Számok rendezése */
	protected ArrayList<Integer> sort(ArrayList<Integer> numbers) {

		for (int i = 0; i < numbers.size() - 1; i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				if (numbers.get(i) > numbers.get(j)) {
					int helpBox = numbers.get(i);
					numbers.set(i, numbers.get(j));
					numbers.set(j, helpBox);
				}
			}

		}
		return numbers;
	}

	/** Nyerő számok kikeresése */
	protected int checkNumbers() {
		numberOfHits = 0;
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < tipps.size(); j++) {
				if (numbers.get(i) == tipps.get(j)) {
					numberOfHits += 1;
					matchingNumbers.add(numbers.get(i));
				}
			}
		}
		return numberOfHits;
	}

}
