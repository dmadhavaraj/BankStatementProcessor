package statementparser;

import java.io.File;

public class DocumentParserFactory {
	public static DocumentParser getParserFactory(File file) throws ParserNotSupportedException{
		DocumentParser parser = null;
		String fileName = file.getName();
		if(fileName.endsWith(".xml")) {
			parser = new XmlDocumentParser(file);
		} else if(fileName.endsWith(".csv")) {
			parser = new CsvDocumentParser(file);
		} else {
			throw new ParserNotSupportedException("Paser is not supported yet. Please check the file type. ");
		}
		return parser;
	}
}
