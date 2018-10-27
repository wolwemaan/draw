import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author ev
 *
 */
public class MyTunes {

	static public int field = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String delimiter = " ";
		List<Element> elements = new ArrayList<Element>();

		Scanner sc = new Scanner(System.in);
		String[] header = sc.nextLine().split(delimiter);
		int n = Integer.valueOf(sc.nextLine()).intValue();
		for (int i = 0; i < n; i++) {
			String[] items = sc.nextLine().split(delimiter);
			List<String> strings = Arrays.asList(items);
			elements.add(new Element(strings));
		}
		int sortFieldNumberOfInputs = Integer.valueOf(sc.nextLine()).intValue();
		for (int i = 0; i < sortFieldNumberOfInputs; i++) {
			String sortField = sc.nextLine();
			int sortFieldNumber = 0;
			for (; sortFieldNumber < header.length; sortFieldNumber++) {

				if (sortField.compareTo(header[sortFieldNumber]) == 0)
					break;
			}
			field = sortFieldNumber;
			Collections.sort(elements, new Comparator<Element>() {

				@Override
				public int compare(Element arg0, Element arg1) {
					return arg0.getStrings().get(MyTunes.field).compareTo(arg1.getStrings().get(MyTunes.field));
				}
			});

			System.out.println(String.join(" ", Arrays.asList(header)));
			for (Element item : elements) {
				List<String> strings = item.getStrings();
				System.out.println(String.join(" ", strings));
			}
			if (i < (sortFieldNumberOfInputs - 1)) System.out.println();
		}
		sc.close();
	}
}

class Element {
	List<String> strings;

	public Element(List<String> strings) {
		super();
		this.strings = strings;
	}

	/**
	 * @return the strings
	 */
	public List<String> getStrings() {
		return strings;
	}

	/**
	 * @param strings the strings to set
	 */
	public void setStrings(List<String> strings) {
		this.strings = strings;
	}
}
