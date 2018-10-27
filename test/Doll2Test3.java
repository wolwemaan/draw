import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

// Junit test wrapper for typical kattis problems
class Doll2Test3 {

	final String baseDir = "/home/ev/doll/";
	final InputStream originalIn = System.in;
	final OutputStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;

	@Before
	public void setUpStreams() {

	}

	@After
	public void restoreStreams() {

		try {
			// outContent.close();
			errContent.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test() throws IOException {

		String[] args = null;
		final String testNameBase = "sample-testcase1";
		final InputStream fips = new FileInputStream(new File(baseDir + testNameBase + ".in"));
		System.setIn(fips);

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));

		Doll2.main(args);
		fips.close();

		System.out.flush();

		System.setIn(originalIn);
		System.setOut(new PrintStream(originalOut));
		System.setErr(originalErr);

//		assertSame("Unexpected Output: ", readFileAsString(baseDir + testNameBase + ".ans"),
//				);
		
		Assertions.assertEquals(readFileAsString(baseDir + testNameBase + ".ans"), readByteArrayAsString(outContent));
		Assertions.assertEquals("", readByteArrayAsString(errContent));
		

//		org.junit.jupiter.api.Assertions.assertAll(
//				() -> Assertions.assertEquals(readFileAsString(baseDir + testNameBase + ".ans"),
//						"x" + readByteArrayAsString(outContent)),
//				() -> Assertions.assertEquals("", readByteArrayAsString(errContent)));

		// this used to work well - not anymore ;/
//		org.junit.Assert.assertEquals(readFileAsString(baseDir + testNameBase + ".ans"), "x"+readByteArrayAsString(outContent));
//		org.junit.Assert.assertEquals("", readByteArrayAsString(errContent));

		// fail("Not yet implemented");
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
