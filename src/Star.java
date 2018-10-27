
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Star {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			int y = sc.nextInt();
			int x = sc.nextInt();

			sc.nextLine();

			int mcnt = 0;
			int starcount = 0;
			Set<Object> list = new TreeSet<Object>();
			Set<Object> newlist = new TreeSet<Object>();
			Set<Integer> block = new TreeSet<Integer>();
			for (int z = 0; z < y; z++) {
				char[] l = sc.nextLine().toCharArray();
				boolean added = false;
				for (int t = 0; t<l.length;t++) {
					if (l[t] != '#') {
						block.add(Integer.valueOf(t));
						added = true;
					} else if (added && block.size() > 0) {
						added = false;
						newlist.add(block);
					}
				}
				if (added) {
					newlist.add(block);
				}
				if (list.size() == 0) list.addAll(newlist);
				else {
					int starCountThisLine = 0;
					for (Object item: newlist) {
						TreeSet<Integer> k = (TreeSet<Integer>)item;
						for (Integer in : k) {
							for (Object olditem: list) {
								TreeSet<Integer> o = (TreeSet<Integer>)olditem;
								if (o.contains(in)) {
									starCountThisLine++;
									break;
								}
							}
						}
					}
	//				if (starCountThisLine == 0)
				}
			}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; i < n; i++) {
//				int cdiff = mm[i] - mm[j];
//			}
//		}
			
			System.out.println("one done");
		}

		sc.close();

	}

}