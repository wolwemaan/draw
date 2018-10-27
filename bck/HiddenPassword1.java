import java.util.Scanner;

public class HiddenPassword {
	
	 static int memnum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] string = sc.nextLine().split("\\s+", 2);
		char[] passwd = string[0].toCharArray();
		// char [] phrase = string[1].toCharArray();
		//int[] passwdMatch = new int[passwd.length];
		int ct = 0;
		boolean match = true;
		String s = new String(string[1]);
		int matchi = 0;
		int matchp = 0;
		
		char[] mem = new char[s.length()];
		System.out.println(s);
		for (char c : passwd) {
			matchi = s.indexOf(c);
			System.out.println(matchi+ ","+c);
			if (matchi < 0) {
				match = false;
				break;
			}
			if (matchi >= matchp) {
				mem[ct++] = c;
				matchp = matchi;
				
			} else {
				match = false;
				int memnum2 = 0;
				memnum = 0;
				boolean foundbefore = foundBefore(mem, c);
				memnum2 = memnum;
			
				if (foundbefore) {
					if (c == 'E') {
						System.out.println("yes");
					}
					int matchi2 = -1;
					int indexfrom = 0;
					boolean more = true;
					for (int j = 0; j <= memnum2; j++) {
						matchi2 = s.indexOf(c, indexfrom);
						if (matchi2 < 0) {
							more = false;
							break;
						}
						indexfrom = matchi2 + 1;
						if (matchi2 >= s.length()) break;
					}
					if (more && matchi2 >= matchp) {
							mem[ct++] = c;
							matchp = matchi2;
							match = true;
					}
				}
				break;
			}
			//s = s.substring(matchi, s.length());

//			ct++;
		}
//		if (!match) {
//			
//		}
//		int mem = 0;
////		try {
//			if (match) {
//				for (int i = 0; i < passwd.length; i++) {
//					if (passwdMatch[i] > mem) {
//						mem = passwdMatch[i];
//						continue;
//					}
//					//System.out.println(passwd[i] + " > " + i + ">"+passwdMatch[i - 1]);
//					passwdMatch[i] = string[1].indexOf(passwd[i]/*, (passwdMatch[i - 1])*/);
//					if (passwdMatch[i] < 0) {
//						System.out.println("faila");
//						match = false;
//						break;
//					}
//					if (passwdMatch[i] > mem) {
//						mem = passwdMatch[i];
//						continue;
//					}
//					if (i > 0) {
//					System.out.println("failb" + passwd[i]);
//						match = false;
//						break;
//						
//					}
////					{
////						
////					}
//					// if (passwdMatch[ct] < 0) {
//
//				}
//			}
//		} catch (RuntimeException e) {
//			System.out.println("fail");
//			e.printStackTrace();
//		}
		
		
		
//		int mem = 0;
//
//		if (match) {
//			for (int i = 0; i < passwd.length; i++) {
//				if (passwdMatch[i] > mem) {
//					mem = passwdMatch[i];
//					continue;
//				}
//				//System.out.println(passwd[i] + " > " + i + ">"+passwdMatch[i - 1]);
//				passwdMatch[i] = string[1].indexOf(passwd[i]/*, (passwdMatch[i - 1])*/);
//				if (passwdMatch[i] < 0) {
//					System.out.println("faila");
//					match = false;
//					break;
//				}
//				if (passwdMatch[i] > mem) {
//					mem = passwdMatch[i];
//					continue;
//				}
//				if (i > 0) {
//				System.out.println("failb" + passwd[i]);
//					match = false;
//					break;
//					
//				}
//
//
//			}
//		}

		
		
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