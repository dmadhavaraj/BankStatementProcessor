package statementparser;
import java.util.*;

import model.*;

public interface DocumentParser {
	public List<TransactionRecord> parse();
}
