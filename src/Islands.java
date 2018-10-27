import java.util.Scanner;
import java.util.function.BiFunction;

public class Islands {

	final static char land = 'L';
	final static char water = 'W';
	final static char cloud = 'C';

	private static Boolean isItThat(char[][] arr, int i, int j, int row, int col, char checkFor) {
		if (i < 0 || j < 0 || i >= row || j >= col)
			return null;

		if (arr[i][j] != checkFor)
			return Boolean.FALSE;

		return Boolean.TRUE;
	}

	public static void main(String[] args) {
		
		// Get Input
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		sc.nextLine();
		char[][] arr = new char[row][col];
		for (int i = 0; i < row; i++) arr[i] = sc.nextLine().toCharArray();

		sc.close();

		// Get rid of clouds and make optimistic guess to get maximum amount of land
		BiFunction<Integer, Integer, Boolean> lamdaA = (i, j) -> {
			checkForAndSetPositive(arr, row, col, i, j, land, land);
			checkForAndSetNegative(arr, row, col, i, j, water, water);
			return Boolean.TRUE;
		};

		BiFunction<Integer, Integer, Boolean> lamdaB = (i, j) -> {
			checkForAndSetPositive(arr, row, col, i, j, cloud, water);
			checkForAndSetPositive(arr, row, col, i, j, water, water);
			return Boolean.TRUE;
		};

		exhaustIterationsUntilNothingChangesAnymore(lamdaA, row, col, arr);
		exhaustIterationsUntilNothingChangesAnymore(lamdaB, row, col, arr);

		// At this point arr is prepared and should not contain not any clouds at all
		// TODO Comment print out and add the star count code here
		System.out.print(getGridAsString(row, col, arr));

	}

	private static void exhaustIterationsUntilNothingChangesAnymore(BiFunction<Integer, Integer, Boolean> lamda,
			int row, int col, char[][] arr) {
		String old = "";
		while (haveClouds(row, col, arr)) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++)
					lamda.apply(i, j);

			}
			String now = getGridAsString(row, col, arr);
			if (now.compareTo(old) == 0)
				break;
			old = now;
		}

	}

	private static void checkForAndSetPositive(char[][] arr, int row, int col, int i, int j, char checkFor,
			char setAs) {
		// System.out.println(":"+i+':'+j);
		if (arr[i][j] == cloud) {
			Boolean top = isItThat(arr, i - 1, j, row, col, checkFor);
			Boolean left = isItThat(arr, i, j - 1, row, col, checkFor);
			Boolean right = isItThat(arr, i, j + 1, row, col, checkFor);
			Boolean bottom = isItThat(arr, i + 1, j, row, col, checkFor);

			if ((top != null && top.booleanValue()) || (left != null && left.booleanValue())
					|| (right != null && right.booleanValue()) || (bottom != null && bottom.booleanValue()))
				arr[i][j] = setAs;
			//System.out.println("cloud:" + i + ':' + j + top + left + right + bottom + arr[i][j]);

		}

	}

	private static void checkForAndSetNegative(char[][] arr, int row, int col, int i, int j, char checkFor,
			char setAs) {
		if (arr[i][j] == cloud) {
			Boolean top = isItThat(arr, i - 1, j, row, col, checkFor);
			Boolean left = isItThat(arr, i, j - 1, row, col, checkFor);
			Boolean right = isItThat(arr, i, j + 1, row, col, checkFor);
			Boolean bottom = isItThat(arr, i + 1, j, row, col, checkFor);

			if ((top == null || top.booleanValue()) && (left == null || left.booleanValue())
					&& (right == null || right.booleanValue()) && (bottom == null || bottom.booleanValue()))
				arr[i][j] = setAs;
			// System.out.println("cloud:"+i+':'+j+top+left+right+bottom + arr[i][j]);

		}

	}

	private static String getGridAsString(int row, int col, char[][] arr) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		return sb.toString();

	}

	private static boolean haveClouds(int row, int col, char[][] arr) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == cloud)
					return true;
			}
		}
		return false;
	}



}