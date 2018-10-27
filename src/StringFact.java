import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class StringFact {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String string = sc.nextLine();
		// string = "abcdefg";//
		// string = "ABABA";//;
		string = "PRATTATTATTIC";//
		sc.close();

		int half = 0;
		if (string != null && string.length() > 0)
			half = string.length() / 2;

//		half = 2;
		int smallestFactor = string.length();
		
		for (int i = half; i > 0; i--) {
			Info result = go(i, string);
			String claim = getstring(result.getFactElements(),0,result.getFactElements().size());
			int countOfFact = result.getCountOfFact();
			boolean isSmaller = countOfFact < smallestFactor;
			boolean oklen = claim.length() >= countOfFact;
            System.out.println("================:" + countOfFact + "[" + claim + "]" + "isSMaller:" + isSmaller + "oklen:" + oklen);
			if (isSmaller)  //&& oklen) {
				smallestFactor = countOfFact;
			
			
		}
		System.out.println(smallestFactor);

	}

	static class Info {

		public Info(int countOfFact, Vector<Character> factElements) {
			super();
			this.countOfFact = countOfFact;
			this.factElements = factElements;
		}

		private int countOfFact;
	

		/**
		 * @return the countOfFact
		 */
		public int getCountOfFact() {
			return countOfFact;
		}

		/**
		 * @return the factElements
		 */
		public Vector<Character> getFactElements() {
			return factElements;
		}

		private Vector<Character> factElements;
	}

	private static Info go(int max, String string) {
		Vector<Character> v = getVectorFromString(string);

		int fact = 0;
//		System.out.println("x" + max);

		boolean selfcalling = false;
		String factStr = "";
		String old = null; 
		for (int i = max; i > 0; i--) {
			old = null;
			int found = 0;
			for (int j = 0; j < v.size(); j += i) {
				String s = getstring(v, j, i);
				if (old != null && old.compareTo(s) == 0) {
					found++;
				} else if (found != 0) {
					found++;
					break;
				}
				old = s;
				// System.out.println(">" + s);
			}
			if (found != 0) {
				// System.out.println("oops>" + old + ":" + found);
				int tryOnSubstring = old.length();
				
//-				if (old.length() > 2) {
//-					System.out.println("oldlen:" + old.length() + ":" + old);
//					Info out = go(old.length(), old);
//					selfcalling = true;
//					tryOnSubstring = out.getCountOfFact();
//					if (tryOnSubstring < old.length()) {
//	
//						System.out.println("=>" + tryOnSubstring + "|" + out.getFactElements().size() + ":"+out.getFactElements().toString() + "=" + old);
//						fact += tryOnSubstring;
//						v = out.getFactElements();
//						//v = makeVectSkippingStr(v, old);
//					} else {
						fact +=  old.length();
						factStr += old;
						v = makeVectSkippingStr(v, old);
//					}
//-				} else {
//-
//-					fact += old.length();
//-					v = makeVectSkippingStr(v, old);
//-				}

			}
			// break;
		}

		//fact +=  old.length();
		//factStr += old;

		Vector<Character> resultv = v;
		
		System.out.println("-->" +
				
				getstring(v,0,v.size())
				);
		
		int result = v.size();//fact;
		System.out.println(factStr + ":" + fact + "=" + v.size());
		
		//int result = fact + v.size();
//		if (!selfcalling) System.out.println("m:" + v.toString() + "|" + old);

		// System.out.println(string.length() + "FAIL" + half + ":" + string + "|" +
		// v.size() + "|" + getstring(v, 0, v.size()));

		//return (!selfcalling) ? 
			//return	new Info(result, getVectorFromString(new String(old + getstring(v, 0, v.size())))) ;
					//: 
			return new Info(result, resultv);

	}

	private static Vector<Character> getVectorFromString(String string) {
		char[] arr = string.toCharArray();
		Character[] arr2 = new Character[arr.length];
		int m = 0;
		for (char r : arr) {
			arr2[m++] = Character.valueOf(r);
		}

		List<Character> t = Arrays.asList(arr2);
		Vector<Character> v = new Vector<Character>(t);
		return v;
	}

	private static Vector<Character> makeVectSkippingStr(Vector<Character> v, String old) {
		String n = getstring(v, 0, v.size());// makeString(v);
		String result = n.replace(old, "");
		// System.out.println("ok:" + result);
		// TODO Auto-generated method stub
		return getVectorFromString(result);
	}

//	private static String getstring(v, 0, v.size());//makeString(Vector<Character> v) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private static String getstring(Vector<Character> v, int j, int i) {
		String ret = "";// "" + j + "|" + i;
		for (int k = 0; k < v.size(); k++) {
			if (k < (j))
				continue;
			if (k > (j + i - 1))
				continue;
			ret += v.get(k).charValue();
		}
		return ret;
	}

}