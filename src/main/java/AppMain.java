import statementparser.DocumentParser;
import statementparser.DocumentParserFactory;
import java.util.*;
import model.*;

public class AppMain {

	public static void main(String[] args) {
		try {
			DocumentParser parser = DocumentParserFactory.getParserFactory("records.xml");
			List<Record> records = parser.parse();
			System.out.println(records);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
