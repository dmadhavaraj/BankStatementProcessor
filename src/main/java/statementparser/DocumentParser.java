package statementparser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import model.*;

public interface DocumentParser {
	public List<Record> parse() throws IOException,FileNotFoundException; 
}
