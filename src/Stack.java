import java.util.Scanner;

public class Stack {

	static int memnum = 0;

	static char arr[];
	static int ctr;
	static final char CHAR_NULL = '\u0000';
	static final boolean DEBUG = true;

	boolean isEmpty() {
		return (ctr < 0);
	}

	// Is already on stack?
	static int already(char val) {
		int result = -1;
		int ct = 0;
		if (arr != null && arr.length > 0)
			for (char value : arr) {
				if (value == CHAR_NULL)
					break;
				else if (val != value) {
					ct++;
					continue;
				}
				result = ct;
				break;
			}
		return result;
	}

	static boolean push(char val) {
		//if (DEBUG)
			System.out.println(showstack() + " | push " + val);
		if (ctr >= (2000 - 1)) {
			System.err.println("invalid: too many in stack");
			return false;
		}
		arr[++ctr] = val;
//		System.out.println(val + " push ok");
		return true;

	}

	static char pop() {
		if (ctr < 0) {
			System.err.println("invalid: stack less than 0");
			return CHAR_NULL;
		}
		char val = arr[ctr--];
		//if (DEBUG)
			System.out.println(showstack() + " | pop - popped  " + val);
		return val;
	}
	
	private static String showstack() { 
		if (true) return "";
		if (arr == null || arr.length == 0) return "";
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}

	static void print() {
		//if (DEBUG)
			System.out.println(showstack() + " | print " + arr[arr.length - 1]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;

		int n = Integer.valueOf(sc.nextLine()).intValue();
		for (int i = 0; i < n; i++) {
		
			char[] s = sc.nextLine().toCharArray();
		
			//if (i == 0) continue;
			
			ctr = -1;
			arr = new char[2000];
			System.out.println("[" + getstring(s) + "]n=" + s.length);
			for (int j = 0; j < s.length; j++) {
				int index;
				if ((index = already(s[j])) >= 0) {
					for (int k = (index - 1); k >= index; k--) {
						char poppedChar = pop();
	//					System.out.println(poppedChar);
					}
				} else {
					boolean pushok = false;
					pushok = push(s[j]);
				}
//				char result = pop();
//				System.out.println(result);
				print();
			}
		//	if (i == 1)				break;

		}
		sc.close();

//		System.out.println(ans);

	}

	private static String getstring(char[] s) {
		String ans = "";
		for (char val : s) {
			ans += val;
		}
		return ans;
	}

}