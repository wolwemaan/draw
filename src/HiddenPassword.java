import java.util.Scanner;

public class HiddenPassword {
	
	 static int memnum = 0;

	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] string = sc.nextLine().split("\\s+", 2);
		sc.close();
		char[] passwd = string[0].toCharArray();

		int ct = 0;
		boolean match = true;

		int matchi = 0;
		int matchp = 0;
		
		char[] mem = new char[string[1].length()];
		//System.out.println(string[1]);
		int ctt=0;

		for (char c : passwd) {
			
			matchi = string[1].indexOf(c);
			//System.out.println(matchi+ ","+c);
			if (matchi < 0) { // Not found
				match = false;
				break;
			}
			if (matchi >= matchp) {
				matchi = string[1].indexOf(c, matchp);
				if (matchi < matchp) match = false;
				//ctt=matchi;
				mem[ct++] = c; // Keep in memory that this character was a success
				matchp = matchi;
				
			} else {
				match = false;
				// START Handle the false FAIL that test case 4 cause, the following
				// SECRET SOMECHORESARETOUGH
				// Should be PASS
				memnum = 0;
				boolean foundbefore = foundBefore(mem, c); // Check if this character succeeded earlier
			//System.out.println(foundbefore);
				if (foundbefore) {
//					if (c == 'E') {
//						System.out.println("yes memnum:" + memnum);
//					}
					int matchi2 = -1;
					int indexfrom = 0;
					boolean more = true;
					// Character was valid before, so for each time it was valid before,
					// find where the index is for that valid case and move it on for the next test
					for (int j = 0; j <= memnum; j++) {
						matchi2 = string[1].indexOf(c, indexfrom);
						if (matchi2 < 0) { // Not found
							more = false;
							break;
						}
						indexfrom = matchi2 + 1;
						if (matchi2 >= string[1].length()) break;
					}
					if (more && matchi2 >= matchp) {
							mem[ct++] = c;
							matchp = matchi2;
							match = true;
					}
				}
				// END Handle the false FAIL that test case 4 cause
				break;
			}
		}
	
		
		System.out.println((match) ? "PASS" : "FAIL");

	}

	private static boolean foundBefore(char[] mem, char c) {
		if (mem == null || mem.length == 0) return false;
		
		int foundnum = 0;
		for (char ch : mem) {
			if (ch == c) foundnum++;
		}
		if (foundnum > 0) {
			HiddenPassword.memnum = foundnum;
			return true;
		} else
		return false;
	}
}