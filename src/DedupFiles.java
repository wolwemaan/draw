import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DedupFiles {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		do {
			Map<Byte, List<String>> map  = new HashMap<Byte, List<String>>();
			Set<String> set = new HashSet<String>();
			Set<Byte> bset = new HashSet<Byte>();
			for (int i = 0; i < n;i++) {
				String string = sc.nextLine();
				set.add(string);
				byte hash = getHash(string); 
				addToCollection(map, Byte.valueOf(hash), string);
				bset.add(Byte.valueOf(hash));
				//System.out.println(string + "|" + hash );
			}
			
			//int collisions = n * (n - 1)/2;
			
			//System.out.println(set.size() + " " + bset.size());
			int coll = collisionCount(map);
			
			System.out.println(set.size() + " " + coll);
			
			//System.out.println(set.size() + "|" + bset.size() +'|'+ collisions);
			//System.out.println(set.size() + " " +( (bset.size() == 1) ?  collisions : bset.size()));
			//System.out.println(set.size() + " =" +calculate(set.size(), bset.size()));
			//String string = sc.nextLine();
			
			n = sc.nextInt();
			sc.nextLine();
		} while (n != 0);
		sc.close();
	
	
	//System.out.println((match) ? "PASS" : "FAIL");

	}

	private static int collisionCount(Map<Byte, List<String>> mapval) {

		Set <Byte> set = mapval.keySet();
		Iterator<Byte> iter = set.iterator();
		int ctr = 0;
		while (iter.hasNext()) {
			Byte key = iter.next();
			List<String> value =  mapval.get(key);
			
			List<String> value2 = new LinkedList<String> (value);
			
			if (value != null && value.size() > 1) {
				
//				for (int a = 0; a < value.size(); a++) {
//					for (int b = 0; b < value.size(); b++) {
//						if (b == a) continue;
//						if (value.get(a).compareTo(value.get(b)) != 0) ctr++;
//					}
//				}
				
				
				
				for (String g : value) {
					//System.out.println(g);
					if (value2 != null && value2.size() > 1) for (String f : value2) {
						if (f.compareTo(g) != 0) ctr++;
						
					}
					value2.remove(g);
					//System.out.println(value.size()+","+value2.size()+","+ctr);
				}
			}
			//System.out.println("___");
		}
		
		//System.out.println(ctr+">"+set.size());
		return ctr;
	}

	private static void addToCollection(Map<Byte, List<String>> mapval, Byte key, String string) {
		List<String> value =  mapval.get(key);
		if (value == null ) value = new LinkedList<String>();
		value.add(string);
		
		mapval.put(key, value);
		
	}
	
//	static int calculate(int n, int k)
//	{
//		double result = n - k + (k * Math.pow(((k-1)/k  ),n));
////
////	    int result =1;
////	    for (int i=0; i<k; i++){
////	        result=result*n/(n-i);
////	    }
////	    result=(1-1/result)*100;
//	    return (int) result;
//	}

	private static byte getHash(String string) {
		byte [] b = string.getBytes(StandardCharsets.UTF_8 );
		//char [] b = string.toCharArray();
		//int [] b = {60, 13};
		
		byte result = (byte) b[0];
		for (int i = 1; i<b.length;i++) {
			result ^= b[i]; 
		}
		
		return result;
	}

	
}