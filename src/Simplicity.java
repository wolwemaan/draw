import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Simplicity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		sc.close();

		char[] arr = s.toCharArray();
		StringBuffer sb = new StringBuffer();

		List<Element> a = new ArrayList<Element>();

		for (char val : arr) {
			int i = sb.indexOf(String.valueOf(val));
			if (i == -1)
				sb.append(val);
			// System.out.println(i);
		}

		char[] uniq = sb.toString().toCharArray();
		for (char val : uniq) {
			int c = getoccur(val, s);
			if (c != 0)
				addIt(a, Character.valueOf(val), Integer.valueOf(c));

		}

		Collections.sort(a, new Comparator<Element>() {

			@Override
			public int compare(Element arg0, Element arg1) {

				return arg1.getInteger().compareTo(arg0.getInteger());
			}
		});

		int eraze = 0;
		for (Element elem : a) {
			//System.out.println(elem.toString());
			sb  = new StringBuffer(sb.toString().replace(String.valueOf(elem.getCharacter()), ""));
			eraze++;
			if (sb.length() <= 2) break;
		
		}
		System.out.println((sb.toString().length() == 0) ? 0 : eraze);
		

	}

	private static void addIt(List<Element> a, Character character, Integer integer) {
		boolean notfound = true;
		Iterator<Element> iter = a.iterator();
		while (iter.hasNext()) {
			Element e = iter.next();

			if (e.getCharacter() == character) {
				e.setInteger(new Integer(e.getInteger().intValue() + integer.intValue()));
				notfound = false;
			}
		}
		if (notfound)
			a.add(new Element(character, integer));

	}

	static class Element {
		Character character;
		Integer integer;

		public Element(Character character, Integer integer) {
			super();
			this.character = character;
			this.integer = integer;
		}

		/**
		 * @return the character
		 */
		public Character getCharacter() {
			return character;
		}

		/**
		 * @param character the character to set
		 */
		public void setCharacter(Character character) {
			this.character = character;
		}

		/**
		 * @return the integer
		 */
		public Integer getInteger() {
			return integer;
		}

		/**
		 * @param integer the integer to set
		 */
		public void setInteger(Integer integer) {
			this.integer = integer;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {

			return " >" + character + ":" + integer;
		}

	}

	private static int getoccur(char val, String s) {
		return s.length() - s.replace(String.valueOf(val), "").length();
	}

}