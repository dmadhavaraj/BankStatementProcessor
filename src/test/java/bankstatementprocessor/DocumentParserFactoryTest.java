package bankstatementprocessor;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import statementparser.DocumentParser;
import statementparser.DocumentParserFactory;
import statementparser.XmlDocumentParser;

public class DocumentParserFactoryTest {
	File file = null;

	@Before
	public void setUp() throws Exception {
		file = new File("test.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetParserFactory() throws Exception {
		DocumentParser parser = DocumentParserFactory.getParserFactory(file);
		assertSame(parser.getClass(), new XmlDocumentParser(file).getClass());
		// file = new File("test.csv");
		// assertSame(parser.getClass(), new XmlDocumentParser(file).getClass());

	}

}
