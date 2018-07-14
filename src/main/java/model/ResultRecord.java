package model;

public class ResultRecord {
	int referenceNum;
	String description;

	public int getReferenceNum() {
		return referenceNum;
	}

	public void setReferenceNum(int referenceNum) {
		this.referenceNum = referenceNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResultRecord [referenceNum=" + referenceNum + ", description=" + description + "]";
	}
}
