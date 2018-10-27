import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Palin {

	static List<String> result;
	static long startTime; static long elapsedTime;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			result = new Vector<String>();
			String string = sc.nextLine();
			
	//		tsStart();
			

			

			for (int i = 2; i < string.length(); i++) {

				check(string, i);
			}

	//		tsShow("cp1");
//			Iterator<String> iter = set.iterator();
//			while (iter.hasNext()) {
//				System.out.println(iter.next());
//			}
			
			//List<String> result = new ArrayList<String>(set);
			
//			tsStart();
			Collections.sort(result);
//			tsShow("cp2");
			for (String substr : result) {
				System.out.println(substr);
			}
			System.out.println();
		}
		sc.close();

	}

	private static void tsShow(String string) {
		elapsedTime = System.currentTimeMillis() - startTime;
//		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(elapsedTime));
//		Instant instant = new Timestamp(elapsedTime).toInstant(); 
//		ZoneId zoneId = ZoneId.of( "America/Montreal" );
//		ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );
//		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu.MM.dd.HH.mm.ss" );
//		String timeStamp = zdt.format( formatter );
//		System.out.println(timeStamp + " : " + string);
		System.out.println(elapsedTime + " : " + string);
	}

	private static void tsStart() {
		startTime = System.currentTimeMillis();
		
	}

	private static boolean isPalin(String string) {
		char[] arr = string.toCharArray();
		int i = arr.length / 2;
		boolean result = true;
		for (int j = 0; j < i; j++) {
			if (arr[j] != arr[arr.length - 1 - j])
				result = false;
		}
		// System.out.println(result);
		return result;

	}
	
	private static boolean isPalin2(String string) {
		char[] arr = string.toCharArray();
		int i = arr.length / 2;
		
//		String a = string.substring(0, i);
//		String b = string.substring(string.length() - i, string.length());
//		System.out.println(string + ":" + a + "|" + b);
		if (string.substring(0, i).compareTo(new 
				StringBuilder(string.substring(string.length() - i, string.length())).
				reverse().toString()) == 0) return true;
		else return false;


	}

	private static void check(String string, int len) {
		for (int i = 0; i < string.length(); i++) {
			String sub = "";
			try {
				sub = string.substring(i, i + len);
				if (isPalin2(sub) && !result.contains(sub)) {
					result.add(sub);
				}
			} catch (RuntimeException e) {
				break;
			}
		}
	}
}

// System.out.println(sub);
//	int ctr = -1;
//	Integer[] arr = new Integer[n];
//	while (++ctr < n) {
//		arr[ctr] = Integer.valueOf(sc.nextLine());
//		//System.out.println(arr[ctr]);
//
//	}
//
//	
//	
//	Arrays.sort(arr, Collections.reverseOrder()); 
//	int tot = 0;
//	int group[] = new int[maxGroup];
//	int j = -1;
//	for (int i = 0; i < n; i++) {
//		
//		if (++j < maxGroup) group[j] = arr[i];
//		else {
////			int calc = calcGroup(group);
//			j = -1;
//		}
//		
//	}
//	
//
//	System.out.println("PASS" + "FAIL");
