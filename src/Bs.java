import java.util.Scanner;

public class Bs {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final char del = '<';

		String string = sc.nextLine();
		sc.close();
		char[] news = string.toCharArray();

		StringBuffer sb = new StringBuffer();
		int delct = 0;
		for (int i = news.length - 1; i >= 0; i--) {
			
			if (news[i] == del) delct++;
			else if (news[i] != del && delct > 0) 
				delct--;
			else 
				sb.insert(0, news[i]);
			
			
		}
		System.out.println(sb.toString() );
	}
}