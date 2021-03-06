package bankstatementprocessor;

import model.*;
import statementprocessor.DataProcessor;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataProcessorTest {
	List<Record> lst = null;
	DataProcessor processor = null;

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

		processor = new DataProcessor(lst);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testFindDuplicateReferenceRecords() {
		List<Record> duplicates = processor.findDuplicateReferenceRecords();
		assertEquals(duplicates.size(), 1);
	}

	@Test
	public void testFindInvalidMutations() {
		List<Record> invalidMutation = processor.findInvalidMutations();
		assertEquals(invalidMutation.size(), 1);
	}

}
