


import java.util.Scanner;

class Mmm {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine()).intValue();

		int neg = 0;
		for (int i = 0; i < n; i++) {
			if (sc.nextInt() < 0) neg++;
		}
		System.out.println(neg);

		sc.close();

	}

}