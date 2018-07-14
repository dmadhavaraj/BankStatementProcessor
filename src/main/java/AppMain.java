import statementparser.DocumentParser;
import statementparser.DocumentParserFactory;
import statementprocessor.DataProcessor;

import java.util.*;
import model.*;

public class AppMain {

	public static void main(String[] args) {
		try {
			DocumentParser parser = DocumentParserFactory.getParserFactory("records.xml");
			List<Record> records = parser.parse();
			System.out.println(records);
			DataProcessor processor = new DataProcessor(records);
			System.out.println("Invalid Mutation :" + processor.findInvalidMutations());
			System.out.println("Duplicate Reference :" + processor.findDuplicateReferenceRecords());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
