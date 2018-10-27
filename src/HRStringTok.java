import java.util.Scanner;

public class HRStringTok {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.replaceAll("^\\s+", "");
        if (s.length() == 0) {
        	System.out.println("0");
        	return;
        }
        String [] s1 = s.split("[\\s\\p{Punct}]+");
        System.out.println(s1.length  );
        for (String ss : s1) {
            
            System.out.println(ss);
        }
        scan.close();
	}
}