package bankstatementprocessor;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import statementparser.CsvDocumentParser;
import statementparser.DocumentParser;
import statementparser.DocumentParserFactory;
import statementparser.ParserNotSupportedException;
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
	}
	
	@Test
	public void testGetParserFactoryCsv() throws Exception {
		file = new File("test.csv");
		DocumentParser parser = DocumentParserFactory.getParserFactory(file);
		assertSame(parser.getClass(), new CsvDocumentParser(file).getClass());
	}
	
	@Test(expected = ParserNotSupportedException.class)
	public void testGetParserFactoryText() throws ParserNotSupportedException {
		file = new File("test.txt");
		DocumentParser parser = DocumentParserFactory.getParserFactory(file);
	}

}
