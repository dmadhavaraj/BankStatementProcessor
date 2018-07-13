package statementparser;

public class DocumentParserFactory {
	public static DocumentParser getParserFactory(String fileName) throws Exception{
		DocumentParser parser = null;
		if(fileName.endsWith(".xml")) {
			parser = new XmlDocumentParser(fileName);
		} else if(fileName.endsWith(".csv")) {
			parser = new CsvDocumentParser(fileName);
		} else {
			throw new Exception("Paser Not Supported");
		}
		return parser;
	}
}
