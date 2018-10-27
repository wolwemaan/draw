import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SyncLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		int n = 0;
		n = Integer.valueOf(sc.nextLine()).intValue();

		for(;n!=0;) {
			List<Integer> a = new ArrayList<Integer>(n);
			for (int i = 0; i < n; i++) {

				Integer val = sc.nextInt();
				a.add(val);
				// sc.nextLine();
				// System.out.print(" >" + val);

			}
			List<Integer> mem = new ArrayList<Integer>(a);

			Collections.sort(a);

			List<Integer> b = new ArrayList<Integer>(n);
			// System.out.println("/");
			for (int i = 0; i < n; i++) {

				Integer val = sc.nextInt();
				b.add(val);
				// sc.nextLine();
				// System.out.print(" >" + val);

			}

			Collections.sort(b);

			Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
			Iterator<Integer> iterA = a.iterator();
			Iterator<Integer> iterB = b.iterator();
			// since the 2 lists are guaranteed to be the same size this should be ok
			while (iterA.hasNext() && iterB.hasNext()) map.put(iterA.next(), iterB.next());
			for (Integer value : mem) System.out.println(map.get(value));
			n = sc.nextInt(); // Integer.valueOf(sc.nextLine()).intValue();
			if (n!=0) System.out.println();

		}
		sc.close();
	}

}