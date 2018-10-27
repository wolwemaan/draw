
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Rock {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();

		int[][] arr = new int[n][k];
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < k; j++) {
				arr[i][j] = sc.nextInt();
				// System.out.print( ">" + arr[i][j] );

			}
			// System.out.println();
			sc.nextLine();
		}

		sc.close();

//		Set<Integer> set =go(n,k, arr);
//
//		
//		Stream<Integer> stream = set.stream();
//		
//		// should use mapToObj instead of map?
//		String joinString = stream.map(i -> ((Integer) i).toString()).collect(Collectors.joining(" "));
//
//		System.out.println(joinString);

	}

	private static Set<Integer> go(int n, int k, int start, int[][] arr) {
		Set<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < n; i++) {
			set.add(Integer.valueOf(arr[i][start]));
		}

		Set<Integer> setother = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			Set<Integer> setlocal = new TreeSet<Integer>();
			for (Integer in : set) {
				for (int j = 0; j < k; j++) {
					if (in.intValue() == arr[i][j])
						break;
					setlocal.add(Integer.valueOf(arr[i][j]));
					// System.out.print( ">" + arr[i][j] );

				}
			}
			setother.addAll(setlocal);
			// System.out.println();
		}
		set.addAll(setother);

		System.out.println(set.size());
		
		return set;

	}

}