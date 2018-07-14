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

	public List<ResultRecord> prepareReport(List<Record> duplicateReferencerecords,
			List<Record> invalidMutationsRecords) {
		List<ResultRecord> results = new ArrayList<ResultRecord>();
		for (Record record : this.records) {
			ResultRecord result = new ResultRecord();
			result.setReferenceNum(record.getReference());
			StringBuffer description = new StringBuffer();
			if (duplicateReferencerecords.contains(record)) {
				description.append("Duplicate Reference Number ");
			}
			if (invalidMutationsRecords.contains(record)) {
				description.append(" Invalid Mutation Found");
			}
			if(description.length() == 0) {
				description.append("ok");
			}
			result.setDescription(description.toString());
			results.add(result);
		}
		return results;
	}

}
