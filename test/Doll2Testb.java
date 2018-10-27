import static org.junit.Assert.assertSame;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

// Junit test wrapper for typical kattis problems
class Doll2Testb {

	final String baseDir = "/home/ev/doll/";
	final InputStream originalIn = System.in;
	// final OutputStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	// ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private ConsoleOutputCapturer capturer;

	@Before
	public void setUpStreams() {
		// outContent = new ByteArrayOutputStream();
		// System.setOut(new PrintStream(outContent));

		errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setIn(originalIn);
		// System.setOut(new PrintStream(originalOut));
		System.setErr(originalErr);

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

		capturer = new ConsoleOutputCapturer();
		capturer.start();

		
		Doll2.main(args);
		fips.close();

		System.out.flush();

//		assertSame("Unexpected Output: ", readFileAsString(baseDir + testNameBase + ".ans"),
//				readByteArrayAsString(outContent));
		
		String outString = capturer.stop();
		
		assertSame("Unexpected Output: ", readFileAsString(baseDir + testNameBase + ".ans"), outString);
		assertSame("Unexpected Error: ", "", readByteArrayAsString(errContent));

		// fail("Not yet implemented");
	}

	private String readByteArrayAsString(ByteArrayOutputStream out) {
		if (out == null)
			return "xxx";
		StringBuffer sb = new StringBuffer();
		byte[] bytes = out.toByteArray();
		for (byte b : bytes) {
			sb.append(b);
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
