import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

// Junit test wrapper for typical kattis problems
class HrBdTest {

	final String baseDir = "./hr/";
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
		final String filenameBase = "bd";
		
		InputStream fips = kattiPrepare(filenameBase);

		// [to change!] Change class name
		HrBd.main(args);

		kattiAssert(fips, filenameBase);
	}

//	@Test
//	void test2() throws IOException {
//
//		String[] args = null;
//		
//		// [to change!] Specific filename base to testcase 
//		final String filenameBase = "sample-testcase2";
//		
//		InputStream fips = kattiPrepare(filenameBase);
//
//		// [to change!] Change class name
//		Doll2.main(args);
//
//		kattiAssert(fips, filenameBase);
//	}
//	
//	@Test
//	void test3() throws IOException {
//
//		String[] args = null;
//		
//		// [to change!] Specific filename base to testcase 
//		final String filenameBase = "sample-testcase3";
//		
//		InputStream fips = kattiPrepare(filenameBase);
//
//		// [to change!] Change class name
//		Doll2.main(args);
//
//		kattiAssert(fips, filenameBase);
//	}
//
//	@Test
//	void test4() throws IOException {
//
//		String[] args = null;
//		
//		// [to change!] Specific filename base to testcase 
//		final String filenameBase = "sample-testcase4";
//		
//		InputStream fips = kattiPrepare(filenameBase);
//
//		// [to change!] Change class name
//		Doll2.main(args);
//
//		kattiAssert(fips, filenameBase);
//	}
	
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
