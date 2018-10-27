import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




// Junit test wrapper for typical kattis problems
public class SyncListsTest {
	final String baseDir = "./synclists/";

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
		void test1() throws IOException {

			String[] args = null;
			
			// [to change!] Specific filename base to testcase 
			final String filenameBase = "sample";
			
			InputStream fips = kattiPrepare(filenameBase);

			// [to change!] Change class name
			SyncLists.main(args);

			kattiAssert(fips, filenameBase);
		}
//
//		@Test
//		void test2() throws IOException {
//
//			String[] args = null;
//			
//			// [to change!] Specific filename base to testcase 
//			final String filenameBase = "2";
//			
//			InputStream fips = kattiPrepare(filenameBase);
//
//			// [to change!] Change class name
//			Stack.main(args);
//
//			kattiAssert(fips, filenameBase);
//		}
//		
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
//			Stack.main(args);
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
//			Stack.main(args);
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
//			Stack.main(args);
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
//			Stack.main(args);
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
//			Stack.main(args);
//
//			kattiAssert(fips, filenameBase);
//		}
		
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

	
