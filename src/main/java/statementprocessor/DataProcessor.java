package statementprocessor;

import model.*;
import java.util.*;

public class DataProcessor {
	private List<Record> records;

	public DataProcessor(List<Record> records) {
		this.records = records;
	}

	public List<Record> findDuplicateReferenceRecords() {
		List<Record> duplicateReferencerecords = new ArrayList<Record>();
		Set<Record> recordsSet = new HashSet<Record>();
		for (Record record : this.records) {
			if (!recordsSet.add(record)) {
				duplicateReferencerecords.add(record);
			}
		}
		return duplicateReferencerecords;
	}

	public List<Record> findInvalidMutations() {

		List<Record> invalidMutationsRecords = new ArrayList<Record>();
		for (Record record : this.records) {
			if (record.getStartBalance() + record.getMutation() != record.getEndBalance()) {
				invalidMutationsRecords.add(record);
			}
		}
		return invalidMutationsRecords;
	}

}
