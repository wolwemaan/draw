import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;






// Junit test wrapper for typical kattis problems
public class IslandsTest {
	final String baseDir = "./islands/";

		final InputStream originalIn = System.in;
		final OutputStream originalOut = System.out;
		private final PrintStream originalErr = System.err;
		ByteArrayOutputStream outContent;
		private ByteArrayOutputStream errContent;

		@BeforeEach
		public void setUpStreams() {

			outContent = new ByteArrayOutputStream();
			System.setOut(new PrintStream(outContent));

			errContent = new ByteArrayOutputStream();
			System.setErr(new PrintStream(errContent));
		}
		
		
		@Test
		void test5() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "Islands-0005";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			Islands.main(args);

			kattiAssert(fips, filenameBase);
		}
		
		@Test
		void test6() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "Islands-0006";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			Islands.main(args);

			kattiAssert(fips, filenameBase);
		}
		
		
		
		@Test
		void test3() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "Islands-0003";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			Islands.main(args);

			kattiAssert(fips, filenameBase);
		}
		
		@Test
		void test4() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "Islands-0004";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			Islands.main(args);

			kattiAssert(fips, filenameBase);
		}

		@AfterEach
		public void restoreStreams() {

			System.out.flush();

			System.setIn(originalIn);
			System.setOut(new PrintStream(originalOut));
			System.setErr(originalErr);
			try {
				outContent.close();
				errContent.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Test
		void test0() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "Islands-0000";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			Islands.main(args);

			kattiAssert(fips, filenameBase);
		}

		@Test
		void test1() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "Islands-0001";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			Islands.main(args);

			kattiAssert(fips, filenameBase);
		}

		@Test
		void test2() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "Islands-0002";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			Islands.main(args);

			kattiAssert(fips, filenameBase);
		}
		
//		@Test
//		void test3() throws IOException {
//
//			String[] args = null;
//			
//			// [to change!] Specific filename base to testcase 
//			final String filenameBase = "3";
//			
//			InputStream fips = kattiPrepare(filenameBase);
//
//			// [to change!] Change class name
//			Islands.main(args);
//
//			kattiAssert(fips, filenameBase);
//		}
//
//		@Test
//		void test4() throws IOException {
//
//			String[] args = null;
//			
//			// [to change!] Specific filename base to testcase 
//			final String filenameBase = "4";
//			
//			InputStream fips = kattiPrepare(filenameBase);
//
//			// [to change!] Change class name
//			Islands.main(args);
//
//			kattiAssert(fips, filenameBase);
//		}
//		
//		@Test
//		void test5() throws IOException {
//
//			String[] args = null;
//			
//			// [to change!] Specific filename base to testcase 
//			final String filenameBase = "5";
//			
//			InputStream fips = kattiPrepare(filenameBase);
//
//			// [to change!] Change class name
//			Islands.main(args);
//
//			kattiAssert(fips, filenameBase);
//		}
//		
//		@Test
//		void test6() throws IOException {
//
//			String[] args = null;
//			
//			// [to change!] Specific filename base to testcase 
//			final String filenameBase = "6";
//			
//			InputStream fips = kattiPrepare(filenameBase);
//
//			// [to change!] Change class name
//			Islands.main(args);
//
//			kattiAssert(fips, filenameBase);
//		}
//		
//		@Test
//		void test7() throws IOException {
//
//			String[] args = null;
//			
//			// [to change!] Specific filename base to testcase 
//			final String filenameBase = "7";
//			
//			InputStream fips = kattiPrepare(filenameBase);
//
//			// [to change!] Change class name
//			Islands.main(args);
//
//			kattiAssert(fips, filenameBase);
//		}
		// if (!top && !left && !right && !bottom) arr[i][j] = water;
		// if (hor(arr, row, col, cloud) == (row * col) || hor(arr, row, col, cloud) ==
		// (row * col)) {
		// System.out.println("0");
		// return;
		// }

		// Set<Pair> landmap =
		// hor2(arr, row, col, land);
		//
		// Set<Pair> cloudmap =
		// hor2(arr, row, col, cloud);
		//
		// Iterator <Pair> iter = landmap.iterator();
		// while (iter.hasNext()) {
		// Pair pair = iter.next();
		// }
		// int vct = ver(arr, row, col, land, cloud);

		// System.out.println(Math.abs(hct - vct));

		// }

		// private static int ver(char[][] arr, int row, int col, char c, char c2) {
		// int res = 0;
		// boolean unint = false;
		// for (int j = 0; j < col; j++) {
		// for (int i = 0; i < row; i++) {
		// if (arr[i][j] == c || arr[i][j] == c2 ) {
		// if (!unint) {
		// res++;
		// unint = true;
		// }
		// } else unint = false;
		// }
		// }
		// return res;
		// }

		private static Set<Pair> hor2(char[][] arr, int row, int col, char c) {
			Set<Pair> map = new LinkedHashSet<Pair>();

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == c) {
						map.add(new Pair(i, j));
					}
				}
			}
			return map;
		}

		private static int hor(char[][] arr, int row, int col, char c) {
			int res = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == c)
						res++;
				}
			}
			return res;
		}
		


		static class Pair {
			int key;
			int value;

			public Pair(int key, int value) {
				super();
				this.key = key;
				this.value = value;
			}

			public int getKey() {
				return key;
			}

			public void setKey(int key) {
				this.key = key;
			}

			public int getValue() {
				return value;
			}

			public void setValue(int value) {
				this.value = value;
			}

		}
		
		private void kattiAssert(InputStream fips, String filenameBase) throws IOException {
			fips.close();

			Assertions.assertEquals(readFileAsString(baseDir + filenameBase + ".ans"), readByteArrayAsString(outContent));
			Assertions.assertEquals("", readByteArrayAsString(errContent));

			// fail("Not yet implemented");

		}

		private InputStream kattiPrepare(String filename) throws FileNotFoundException {
			final String testNameBase = filename;
			InputStream fips = new FileInputStream(new File(baseDir + testNameBase + ".in"));
			System.setIn(fips);
			return fips;
		}

		private String readByteArrayAsString(ByteArrayOutputStream out) {
			StringBuffer sb = new StringBuffer();
			byte[] bytes = out.toByteArray();
			for (byte b : bytes) {
				sb.append((char) b);
			}
			return sb.toString();
		}

		private String readFileAsString(String filename) throws IOException {
			final InputStream inputstream = new FileInputStream(new File(filename));
			int data = inputstream.read();
			StringBuffer sb = new StringBuffer();
			while (data != -1) {
				sb.append((char) data);
				data = inputstream.read();
			}
			inputstream.close();
			return sb.toString();
		}
	}

	
