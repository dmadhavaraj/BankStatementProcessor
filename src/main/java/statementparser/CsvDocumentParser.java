package statementparser;

import model.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvDocumentParser implements DocumentParser {
	File file;

	public CsvDocumentParser(File file) {
		this.file = file;
	}

	public List<Record> parse() throws IOException {

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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			parser.close();
		}

		return records;
	}

}
