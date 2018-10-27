
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

public class Doll {
	final static String _imp = "impossible";
	final static String _unq = "unique";
	final static String _amb = "ambiguous";
	final static String del = "=|@=";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int supermarkets = sc.nextInt();
		sc.nextLine();
		int p = sc.nextInt();
		sc.nextLine();

//		System.out.println("p=" + p + ",q=" + supermarkets);
		int mcnt = 0;
		int starcount = 0;
		Map<Integer, String> list = new TreeMap<Integer, String>();
//		Set<Object> newlist = new TreeSet<Object>();
//		Set<Integer> block = new TreeSet<Integer>();
		for (int z = 0; z < p; z++) {

			Integer l = Integer.valueOf(sc.nextInt());
//			sc.nextLine();
			String s = sc.next();
			sc.nextLine();

			String str = del;
			if (list.containsKey(l))
				str = list.get(l);
			str += s + del;
			list.put(l, str);
		}

		int items = sc.nextInt();
		String[] arr = new String[items];
		sc.nextLine();
		for (int j = 0; j < items; j++) {

			String s = sc.next();
			sc.nextLine();

//			System.out.println("->" + s);
			arr[j] = s;
		}

		sc.close();
/*
		String status = "";
		int ct = -1;
		boolean sequenceStart = false;
		boolean sequenceBroken = false;
		String que = del + arr[++ct] + del;
		Iterator<Integer> iter = list.keySet().iterator();
		while (iter.hasNext()) {
			if (sequenceBroken && ct == (arr.length - 1)) {
				status = _imp;
				break;
			} else if (sequenceStart && ct == (arr.length - 1)) {
				status = _unq;
				break;
			} else if (sequenceStart)
				que = del + arr[++ct] + del;
			Integer key = iter.next();
			String val = list.get(key);
			if (val.contains(que))
				sequenceStart = true;
			else
				sequenceBroken = true;
//			System.out.println(key + "=>" + val);
		}
		if (status.length() == 0) {
			if (!sequenceBroken && ct == (arr.length - 1))
				status = _unq;
			else if (sequenceBroken)
				status = _imp;
		}
		
		*/
//		if (status.compareTo(_imp) == 0)
		String	status = checkForambiguous(list, arr);
//		System.out.println(ct);
		System.out.println(status);

	}

	private static String checkForambiguous(Map<Integer, String> list, String[] arr) {
		// int ct = -1;
		String status = _imp;

		Map<String, List<Integer>> groz = new LinkedHashMap<String, List<Integer>>();
		for (int t = 0; t < arr.length; t++) {
			groz.put(arr[t], null);
//			System.out.println(arr[t]);
		}

//		Iterator<String> iter3 = groz.keySet().iterator();
//		while (iter3.hasNext()) {
//			String key2 = iter3.next();
//			List<Integer> lis = groz.get(key2);
//			System.out.println("="+key2 );
//
//		}

//		String que = del + arr[++ct] + del;
		Iterator<Integer> iter = list.keySet().iterator();
		while (iter.hasNext()) {
			Integer key = iter.next();
			String val = list.get(key);

			Iterator<String> iter1 = groz.keySet().iterator();
			while (iter1.hasNext()) {
				String key1 = iter1.next();
				List<Integer> lis = groz.get(key1);
				if (lis == null)
					lis = new Vector<Integer>();
				if (val.contains(del + key1 + del))
					lis.add(key);
				groz.put(key1, lis);
				System.out.println(key + "=>" + val);
			}
		}

		List<Integer> lis = groz.get(arr[0]);
		Map<Integer, Integer> route = new HashMap<Integer, Integer>(lis.size());
		for (Integer in : lis) {
			route.put(in, 1);
		}

		for (int t = 0; t < arr.length; t++) {
			String prod = arr[t];

			Iterator<String> iter2 = groz.keySet().iterator();
			iter2.next();
			while (iter2.hasNext()) {
				String key2 = iter2.next();
				if (prod.compareTo(key2) == 0) {
					List<Integer> lisx = groz.get(key2);
					for (Integer x : lisx) {
						for (Integer mm : lis) {
							if (x == mm || (mm + 1) == x)
								route.put(mm, route.get(mm) + 1);
						}
					}

				}

			System.out.println(key2 + lis.toString());
			
			char x = 'x';
			String.valueOf(x);

			}
		}
		int ct = 0;
		Iterator<Integer> mm = route.keySet().iterator();
		while (mm.hasNext()) {
			Integer key = mm.next();
			Integer mmm = route.get(key);
			System.out.println("===" + key + "=" + mmm);
			if (mmm >= arr.length) ct++;
		}
		if (ct >= 2) status = _amb;
		else if (ct == 1) status = _unq;
		else status = _imp;
		
		
		System.out.println(ct);

		return status;
	}

}