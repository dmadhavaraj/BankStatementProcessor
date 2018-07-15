package bankstatementprocessor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Record;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import statementparser.CsvDocumentParser;

public class CsvDocumentParserTest {
	List<Record> lst = null;

	@Before
	public void setUp() throws Exception {
		lst = new ArrayList<Record>();
		Record record = null;

		record = new Record();
		record.setReference(1001);
		record.setAccountNumber("1");
		record.setDescripton("test1");
		record.setStartBalance(10);
		record.setMutation(-5);
		record.setEndBalance(5);
		lst.add(record);

		record = new Record();
		record.setReference(1002);
		record.setAccountNumber("2");
		record.setDescripton("test2");
		record.setStartBalance(10);
		record.setMutation(+4);
		record.setEndBalance(5);
		lst.add(record);

		record = new Record();
		record.setReference(1001);
		record.setAccountNumber("3");
		record.setDescripton("test3");
		record.setStartBalance(10);
		record.setMutation(-30);
		record.setEndBalance(-20);
		lst.add(record);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParse() throws IOException {
		CsvDocumentParser mock = mock(CsvDocumentParser.class);

		when(mock.parse()).thenReturn(lst);

		assertEquals(mock.parse().size(), 3);
	}

}
