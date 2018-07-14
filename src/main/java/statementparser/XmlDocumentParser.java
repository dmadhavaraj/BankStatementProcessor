package statementparser;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.ListOfRecords;
import model.Record;

public class XmlDocumentParser implements DocumentParser {
	String fileName;

	public XmlDocumentParser(String fileName) {
		this.fileName = fileName;
	}

	public List<Record> parse() throws IOException {
		List<Record> records = new ArrayList<Record>();

		try {

			// File file = new File(fileName);
			File file = new File("records.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ListOfRecords.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ListOfRecords lstRecord = (ListOfRecords) jaxbUnmarshaller.unmarshal(file);
			records = lstRecord.getRecords();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return records;
	}

}
