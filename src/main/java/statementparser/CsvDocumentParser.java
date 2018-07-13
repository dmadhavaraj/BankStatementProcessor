package statementparser;

import model.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvDocumentParser implements DocumentParser {
	String fileName;

	public CsvDocumentParser(String fileName) {
		this.fileName = fileName;
	}

	public List<TransactionRecord> parse() {

		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
		List<TransactionRecord> records = new ArrayList<TransactionRecord>();
		CSVParser parser;
		try {
			parser = new CSVParser(new FileReader("records.csv"), format);

			for (CSVRecord entry : parser) {
				TransactionRecord record = new TransactionRecord();
				record.setReference(Integer.parseInt(entry.get("Reference")));
				record.setAccountNumber(entry.get("AccountNumber"));
				record.setDescripton(entry.get("Description"));
				record.setStartBalance(Integer.parseInt(entry.get("Start Balance")));
				record.setMutation(Integer.parseInt(entry.get("Mutation")));
				record.setEndBalance(Integer.parseInt(entry.get("End Balance")));
				records.add(record);
			}
			parser.close();
			System.out.println(records);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return records;
	}

}
