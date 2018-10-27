import java.util.Scanner;

public class Greedy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine()).intValue();

		int ctr = -1;
		int now = 0;
		int not = 0;
		StringBuffer string = new StringBuffer();
		while (++ctr < n) {
			int i = sc.nextInt();
			if (i > now) {
				string.append(' ');
				string.append(i);
				now = i;
			} else
				not++;

		}

		sc.close();

		System.out.println(ctr - not);
		string.delete(0, 1);
		System.out.println();

	}

}

//System.out.println("n=" + n);
//int[] arr = new int[n];
//arr[ctr] =sc.nextInt();
//System.out.println(arr[ctr]);
//for (int i = 0; i < n; i++) {
//	arr[ctr]
//
//	
//}
