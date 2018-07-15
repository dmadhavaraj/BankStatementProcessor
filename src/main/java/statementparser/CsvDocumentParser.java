package statementparser;

import model.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * @author Madhav 
 * This class is responsible for parsing .csv type statement records.
 *         
 */
public class CsvDocumentParser implements DocumentParser {
	File file;
	static Logger logger = Logger.getLogger(CsvDocumentParser.class.getName());

	public CsvDocumentParser(File file) {
		this.file = file;
	}

	public List<Record> parse() throws IOException, FileNotFoundException {

		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
		List<Record> records = new ArrayList<Record>();
		CSVParser parser = null;
		try {
			parser = new CSVParser(new FileReader(this.file), format);

			for (CSVRecord entry : parser) {
				Record record = new Record();
				record.setReference(Integer.parseInt(entry.get("Reference")));
				record.setAccountNumber(entry.get("AccountNumber"));
				record.setDescripton(entry.get("Description"));
				record.setStartBalance(Double.parseDouble(entry.get("Start Balance")));
				record.setMutation(Double.parseDouble(entry.get("Mutation")));
				record.setEndBalance(Double.parseDouble(entry.get("End Balance")));
				records.add(record);
			}

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			logger.info("There is no file exists with name :" + this.file.getName());
		} catch (IOException e ) {
			// e.printStackTrace();
			logger.info("Exception occured while reading the file :" + this.file.getName());
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("Exception occured while reading the file :" + this.file.getName());
		} finally {
			parser.close();
		}
		return records;
	}

}
