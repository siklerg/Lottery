package lotteryGames;

public class BackwardPlay extends OriginalPlay {

	int oneHit = 0;
	int twoHits = 0;
	int threeHits = 0;
	int fourHits = 0;
	int counter = 0;

	public void play() {
		makingTipps(5, 90);
		System.out.println();
		System.out.println("A húzások elkezdődtek...");
		System.out.println();
		findWinnerCombo();

	}

	private void findWinnerCombo() {
		while (numberOfHits != 5) {
			counter += 1;
			numbers = generateNumbers(90);
			numberOfHits = checkNumbers();
			switch (numberOfHits) {
			case 4:
				fourHits += 1;
				numbers.clear();
				break;
			case 3:
				threeHits += 1;
				numbers.clear();
				break;
			case 2:
				twoHits += 1;
				numbers.clear();
				break;
			case 1:
				oneHit += 1;
				numbers.clear();
				break;
			case 0:
				numbers.clear();
				break;
			}
		}
		System.out.println();
		System.out.println("Megvan a győztes szelvény!");
		System.out.println(numbers);
		System.out.println();
		System.out.println("HÚZÁSOK SZÁMA: " + counter);
		System.out.println("1 találatosok száma: " + oneHit);
		System.out.println("2 találatosok száma: " + twoHits);
		System.out.println("3 találatosok száma: " + threeHits);
		System.out.println("4 találatosok száma: " + fourHits);
		System.out.println("5 találatos - 1 db :)");
	}

}
