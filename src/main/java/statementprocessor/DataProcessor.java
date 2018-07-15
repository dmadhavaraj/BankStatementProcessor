package statementprocessor;

import model.*;
import java.util.*;

/**
 * @author Madhav
 * This class processes the records and generates ResultRecord list
 */
public class DataProcessor {
	private List<Record> records;

	public DataProcessor(List<Record> records) {
		this.records = records;
	}

	/**
	 * @return : the list of duplicate reference number records
	 */
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

	/**
	 * @return : the list of invalid mutation records
	 */
	public List<Record> findInvalidMutations() {

		List<Record> invalidMutationsRecords = new ArrayList<Record>();
		for (Record record : this.records) {
			if (record.getStartBalance() + record.getMutation() != record.getEndBalance()) {
				invalidMutationsRecords.add(record);
			}
		}
		return invalidMutationsRecords;
	}

	/**
	 * @param duplicateReferencerecords
	 * @param invalidMutationsRecords
	 * @return : list of ResultRecord for generating html report
	 */
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
			if (description.length() == 0) {
				description.append("ok");
			}
			result.setDescription(description.toString());
			results.add(result);
		}
		return results;
	}

}
