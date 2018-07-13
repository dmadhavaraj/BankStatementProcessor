package statementparser;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.TransactionRecord;

public class XmlDocumentParser implements DocumentParser {
	String fileName;

	public XmlDocumentParser(String fileName) {
		this.fileName = fileName;
	}

	public List<TransactionRecord> parse() {
		List<TransactionRecord> records = new ArrayList<TransactionRecord>();

		try {

			//File file = new File(fileName);
			File file = new File("records.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(TransactionRecord.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			TransactionRecord record = (TransactionRecord) jaxbUnmarshaller.unmarshal(file);
			System.out.println(record);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return records;
	}

}
