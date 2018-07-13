import statementparser.DocumentParser;
import statementparser.DocumentParserFactory;
import java.util.*;
import model.*;

public class AppMain {

	public static void main(String[] args) {
		try {
			DocumentParser parser = DocumentParserFactory.getParserFactory("records.csv");
			List<TransactionRecord> records = parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
