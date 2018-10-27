import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Akcija {

	static int  maxGroup = 3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine()).intValue();

		System.out.println("n=" + n);
		int ctr = -1;
		Integer[] arr = new Integer[n];
		while (++ctr < n) {
			arr[ctr] = Integer.valueOf(sc.nextLine());
			//System.out.println(arr[ctr]);

		}

		sc.close();
		
		
		Arrays.sort(arr, Collections.reverseOrder()); 
		int tot = 0;
		int group[] = new int[maxGroup];
		int j = -1;
		for (int i = 0; i < n; i++) {
			
			if (++j < maxGroup) group[j] = arr[i];
			else {
//				int calc = calcGroup(group);
				j = -1;
			}
			
		}
		

		System.out.println("PASS" + "FAIL");

	}

}