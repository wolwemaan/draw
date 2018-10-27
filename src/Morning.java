import java.util.Scanner;

public class Morning {

	private static int[][] numericPad = new int[][] { { 1, 4, 7 }, { 2, 5, 8, 0 }, { 3, 6, 9 } };
	private static int rowMem, colMem;

	private static boolean isAcceptedSequenceForNumber(int i) {
		char[] arr = String.valueOf(i).toCharArray();

		rowMem = colMem = 0;
		for (int number : arr) {
			if (!checkPartitionOfNumericPad(Character.getNumericValue(number)))
				return false;
		}
		return true;
	}

	private static boolean checkPartitionOfNumericPad(int value) {
		for (int r = rowMem; r < numericPad.length; r++) {
			for (int c = colMem; c < numericPad[r].length; c++) {
				if (numericPad[r][c] == value) {
					rowMem = r;
					colMem = c;
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine()).intValue();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.valueOf(sc.nextLine()).intValue();
		sc.close();

		for (int value : arr) {
			int deviationValue = 0;
			// Safe time finding closest number, check up and down for each loop iteration
			for (int i = 0; i < value; i++) {

				deviationValue = value + i;
				if (isAcceptedSequenceForNumber(deviationValue))
					break;

				deviationValue = value - i;
				if (deviationValue > 0 && isAcceptedSequenceForNumber(deviationValue))
					break;

			}
			System.out.println(deviationValue);
		}
	}
}