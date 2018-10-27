
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Pangram2 {

	private static String what3(Set<Character> s) {
		Set<Character> h = new TreeSet<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
		h.removeAll(s);
		return h.toString().replaceAll("[\\[\\]\\s,]", "");
		// return String.join("", h);
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
				if (Character.isAlphabetic((int) c[j])) {
					set.add(Character.valueOf(
							(Character.isLowerCase((char) c[j])) ? (char) c[j] : Character.toLowerCase((char) c[j])));

				}
			}
			// System.out.println(set.toString());
			if (set.size() == 26) {
				System.out.println("pangram");
				continue;
			}

			/*
			 * String s = what(set); if (s.length() + set.size() == 26)
			 * System.out.println("missing " + s); else
			 */System.out.println("missing " + what3(set));

			// System.out.println();
		}

		sc.close();

	}

}