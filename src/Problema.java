import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Problema {
	static private List<String> done = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.nextLine();
		char[] colin = new char[n];
		int[] rowin = new int[n];
		for (int i = 0; i < n; i++) {
			char[] arr = sc.nextLine().toCharArray();
			colin[i] = arr[0];
			rowin[i] = Character.getNumericValue(arr[1]);
		}

		sc.close();

		for (int i = 0; i < n; i++) {
			System.out.println(" >" + colin[i] + rowin[i]);
			Map<String, Integer> map = new HashMap<String, Integer>();
			check(map, Column.valueOf(String.valueOf(colin[i]).toUpperCase()), rowin[i]);
			steps(map);
			break;
		}

	}

	private static void steps(Map<String, Integer> map) {
		while (done.size() != 63) {
			Set<String> set = new HashSet<String>(map.keySet());
			for (String s : set) {
				char[] arr = s.toCharArray();
				check(map, Column.valueOf(String.valueOf(arr[0]).toUpperCase()), Character.getNumericValue(arr[1]));

			}
		}
		

		


		System.out.println("ok:"+done.size());
		Set<String> set = map.keySet();
		int large = 0;
		for (String s : set) {
			int val = map.get(s).intValue() ;
			if (val > large) large = val;
			//System.out.println(s + ":" + map.get(s));
		}
		for (String s : set) {
			int val = map.get(s).intValue() ;
			if (val == 6) System.out.println(s + ":" + map.get(s));
		}
	}
	
//	Comp comp = new Comp(map);
//
//	TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(comp);
//	sorted.putAll(map);
//	static class Comp implements Comparator {
//		Map<String, Integer> map;
//	 
//		public Comp(Map<String, Integer> map) {
//			this.map = map;
//		}
//	 
//		public int compare(Object o1, Object o2) {
//			String a = (String)o1;
//			String b = (String)o2;
//			
//
//			return map.get(a).compareTo(map.get(b));
//		}
//	}

	private static void check(Map<String, Integer> map, Column col, int row) {

		final Column[] val = Column.values();

		Pos pos = new Pos();

		if (isValid(val, row, 2, col, 1, pos))
			addToMap(pos, map);
		if (isValid(val, row, -2, col, 1, pos))
			addToMap(pos, map);
		if (isValid(val, row, 1, col, 2, pos))
			addToMap(pos, map);
		if (isValid(val, row, 1, col, -2, pos))
			addToMap(pos, map);
		String cur = new Pos(row, col).toString();
		if(!done.contains(cur))done.add(cur);

		// System.out.println(isvalid + "|" + pos.toString());

//		Boolean top = isItThat(arr, i - 1, j, row, col, checkFor);
//		Boolean left = isItThat(arr, i, j - 1, row, col, checkFor);
//		Boolean right = isItThat(arr, i, j + 1, row, col, checkFor);
//		Boolean bottom = isItThat(arr, i + 1, j, row, col, checkFor);
//
//		if ((top != null && top.booleanValue()) || (left != null && left.booleanValue())
//				|| (right != null && right.booleanValue()) || (bottom != null && bottom.booleanValue()))
//			arr[i][j] = setAs;
//		// System.out.println("cloud:" + i + ':' + j + top + left + right + bottom +
//		// arr[i][j]);

	}

	private static void addToMap(Pos pos, Map<String, Integer> map) {
		if (done.contains(pos.toString()))
			return;
		Integer i = map.putIfAbsent(pos.toString(), 1);
		if (i != null)
			map.put(pos.toString(), new Integer(i.intValue() + 1));
//		if (map.containsKey(pos.toString())) {
//			Integer i = map.get(pos.toString());
//			map.put(pos.toString(), new Integer(i.intValue() + 1));
//		} else map.put(pos.toString(), 1);

	}

	private static boolean isValid(Column[] val, int row, int i, Column col, int j, Pos pos) {
		row += i;
		if (row < 1 || row > 8)
			return false;
		int c = 0;
		for (; c < val.length; c++)
			if (col == val[c])
				break;
		c += j;
		try {
			Column column = val[c];
			pos.setRow(row);
			pos.setColumn(column);
		} catch (RuntimeException r) {
			return false;
		}

		return true;
	}

	static enum Column {
		A, B, C, D, E, F, G, H;
	}

	static class Pos {
		int row;
		Column column;

		public Pos() {
			super();
			// this.row = 0;
			// this.column = Column.A;
		}

		public Pos(int row, Column col) {
			super();
			this.column = col;
			this.row = row;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			try {
				return this.column.toString().toLowerCase() + row;
			} catch (RuntimeException e) {
				return "";
			}
		}

		/**
		 * @return the row
		 */
		public int getRow() {
			return row;
		}

		/**
		 * @param row the row to set
		 */
		public void setRow(int row) {
			this.row = row;
		}

		/**
		 * @return the column
		 */
		public Column getColumn() {
			return column;
		}

		/**
		 * @param column the column to set
		 */
		public void setColumn(Column column) {
			this.column = column;
		}

	}

	private static int ver(char[][] arr, int row, int col, char c, char c2) {
		int res = 0;
		boolean unint = false;
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {
				if (arr[i][j] == c || arr[i][j] == c2) {
					if (!unint) {
						res++;
						unint = true;
					}
				} else
					unint = false;
			}
		}
		return res;
	}

//	private static int hor(char[][] arr, int row, int col, char c, char c2) {
//		int res = 0;
//		boolean unint = false;
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				if (arr[i][j] == c || arr[i][j] == c2) {
//					if (!unint) {
//						res++;
//						unint = true;
//					}
//				} else
//					unint = false;
//			}
//		}
//		return res;
//	}
//
//	private static int hor(char[][] arr, int row, int col, char c) {
//		int res = 0;
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				if (arr[i][j] == c)
//					res++;
//			}
//		}
//		return res;
//	}
//	private static Boolean isItThat(char[][] arr, int i, int j, int row, int col, char checkFor) {
//		if (i < 0 || j < 0 || i >= row || j >= col)
//			return null;
//
//		if (arr[i][j] != checkFor)
//			return Boolean.FALSE;
//
//		return Boolean.TRUE;
//	}
}