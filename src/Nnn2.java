
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Nnn2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();

		List<Integer> v2 = new Vector<Integer>();

		sc.nextLine();

		int washct2 = 0;
		Integer old = null;
		int[] mm = new int[n];
		for (int z = (n-1); z >= 0; z--) {
			
			mm[z] = sc.nextInt();
		}
		Arrays.sort(mm);
		
		for (int z = (n-1); z >= 0; z--) {
			if (washct2 < c && ((old == null) || (Math.abs(old - mm[z]) <= k)))
				washct2++;
			else {
				//System.out.println("xx"+washct2);
				v2.add(Integer.valueOf(washct2));
				washct2 = 0;
			}
			old = Integer.valueOf(mm[z]);
		}
		//System.out.println("xx"+washct2);
		v2.add(Integer.valueOf(washct2));
		old =0;

		sc.close();

		System.out.println(v2.size());
	}

}