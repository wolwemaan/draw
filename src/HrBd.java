
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class HrBd {
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

		sc.nextLine();

		String[] mm = new String[n];
		List<BigDecimal> nn = new ArrayList<BigDecimal>();
		
		for (int z = 0; z < n; z++) {
			mm[z] = sc.next();
			System.out.println(">" + mm[z]);
			nn.add(BigDecimal.valueOf(Double.valueOf(mm[z]).doubleValue()));
		}
		
		Collections.sort(nn, Collections.reverseOrder());

		for (BigDecimal m : nn) {
			String t = null;
			for (String s : mm) {
				if (Double.valueOf(s).doubleValue() == m.doubleValue()) {
					t = s;
					break;
				}
			}
			System.out.println(t);
			
		}
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