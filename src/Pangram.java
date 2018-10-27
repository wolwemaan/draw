import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Pangram {

	private static String what3(Set<Character> s) {
		Set<Character> h = new TreeSet<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
		h.removeAll(s);
		return h.toString().replaceAll("[\\[\\]\\s,]", "");
		//return String.join("", h); 
	}
	private static String what(Set<Character> s) {
		StringBuffer sb = new StringBuffer();
		int i = 97;
		for (Character c : s) {
			// if ((int) c.charValue() != i)
			while ((int) c.charValue() != i) {
				// System.out.println("[" + c.charValue() + "] vs [" + ((char)i)+"]");
				sb.append((char) i);
				i++;

			}

			i++;
			// break;
		}
		return sb.toString();
	}

	private static String what2(Set<Character> s) {

		StringBuffer sb = new StringBuffer();
		int len = s.size();
		Iterator<Character> i = s.iterator();
		int pre = 97;
		while (i.hasNext() && len <= 26) {
			int c = i.next().charValue();
			if (c == pre) {
				pre++;
				len++;
			} else {
				while (c != pre) {
					sb.append((char) pre);
					len++;
					pre++;
				}
				pre++;
			}

		}
		for (int t = pre; t <= 122; t++) {
			sb.append((char) t);
			if (++len >= 26)
				break;
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine()).intValue();

		for (int i = 0; i < n; i++) {
			// System.out.println(i + ">>"+sc.nextLine());
			// if (true)continue;
			byte[] c = sc.nextLine().getBytes();
			Set<Character> set = new TreeSet<Character>();
			for (int j = 0; j < c.length; j++) {
				// Character x = Caracterc[j];
				// System.out.println((int) c[j]);
				if ((int) c[j] >= 65 && (int) c[j] <= 90)
					c[j] += 32;
				if ((int) c[j] >= 97 && (int) c[j] <= 122)
					set.add(Character.valueOf((char) c[j]));
				else
					continue;

				// System.out.print("" + (char) c[j]);
			}
			//System.out.println(set.toString());
			if (set.size() == 26) {
				System.out.println("pangram");
				continue;
			}

			/*String s = what(set);
			if (s.length() + set.size() == 26) System.out.println("missing " + s);
			else */System.out.println("missing " + what3(set));
			
			// System.out.println();
		}

		sc.close();

	}

}