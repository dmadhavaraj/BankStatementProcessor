package statementparser;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.ListOfRecords;
import model.Record;

/**
 * @author Madhav 
 * This class is responsible for parsing .xml type statement
 * records.
 * 
 */

public class XmlDocumentParser implements DocumentParser {
	File file;
	static Logger logger = Logger.getLogger(DocumentParser.class.getName());

	public XmlDocumentParser(File file) {
		this.file = file;
	}

	public List<Record> parse() throws IOException, FileNotFoundException {
		List<Record> records = new ArrayList<Record>();

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ListOfRecords.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ListOfRecords lstRecord = (ListOfRecords) jaxbUnmarshaller.unmarshal(this.file);
			records = lstRecord.getRecords();
		} catch (JAXBException e) {
			// e.printStackTrace();
			logger.info("Exception occured while parsing the file :" + this.file.getName());
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("Exception occured while parsing the file :" + this.file.getName());
		} finally {

		}
		return records;
	}

}
