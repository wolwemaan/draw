import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author ev
 *
 */
public class ListEx {

	static public int field = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Item> list = new ArrayList<Item>();

		Item i = new Item(new ArrayList<String>() {
			{
				add("Chopin");
				add("Scherzo_no_1_in_B_minor");
			}
		});
		list.add(i);

		i = new Item(new ArrayList<String>() {
			{
				add("Chopin");
				add("Polonaise_no_3_in_A");
			}
		});

		list.add(i);

		field = 0;

//		Collections.sort(list, (Item arg0, Item arg1) -> arg0.get(ListEx.field).compareTo(arg1.get(ListEx.field)));

		Collections.sort(list, new Comparator<Item>() {

			@Override
			public int compare(Item arg0, Item arg1) {
				return arg0.getStrings().get(ListEx.field).compareTo(arg1.getStrings().get(ListEx.field));
			}
		});

		for (Item item : list) {
			List<String> strings = item.getStrings();
			String joinString = String.join(" ", strings);

			System.out.println(joinString);

		}

	}
}

class Sort implements Comparator<Item> {

	@Override
	public int compare(Item arg0, Item arg1) {
		return arg0.getStrings().get(ListEx.field).compareTo(arg1.getStrings().get(ListEx.field));
	}
}

class Item {
	List<String> strings;

	public Item(List<String> strings) {
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
