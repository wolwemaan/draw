
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nnn {
	static int loads = 0;

	private static int ck(List<Integer> rem, int c, int k, int[] mm, int n, int t) {
		int ret = 0;
		for (int j = 0; j < mm.length; j++) {
			int cdiff = t - mm[j];
			if (cdiff <= k && loads < c) {
				rem.add(Integer.valueOf(j));
				loads++;
				ret = ck(rem, c, k, mm, c, cdiff);
			}
		}

		return ret;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();

		sc.nextLine();

		int neg = 0;
		int[] mm = new int[n];
		for (int z = 0; z < n; z++) {
			mm[z] = sc.nextInt();
		}
		int f = 0;
		int wash = 0;
		int[] nn = copyall(mm);
		for (int i = 0; i < n; i++) {
			loads = 0;
			
			List<Integer> rem = new ArrayList<Integer>();
			int compthis = mm[i];
			nn = addallexcept(nn, i);
			if ( ck(rem, c, k, nn, n, compthis) <= c) {
				//rem.add(i);
				wash++;
				for (Integer ra : rem) {
				   nn=	addallexcept(nn, ra.intValue());
				}
			}
			
		}
		System.out.println(wash);

		sc.close();

	}

	private static int[] copyall(int[] mm) {
		int[]r = new int[mm.length];
		int ct=0;
		for (int i = 0; i < mm.length; i++) {
			r[ct++] = mm[i]; 
		}
		return r;
	}

	private static int[] addallexcept(int[] mm, int t) {
		if (mm.length == 0) return mm;
		int[]r = new int[mm.length - 1];
		int ct=0;
		for (int i = 0; i < mm.length; i++) {
			if (i!=t) r[ct++] = mm[i]; 
		}
		return r;
	}

}