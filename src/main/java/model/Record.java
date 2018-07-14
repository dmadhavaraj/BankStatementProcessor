package model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement( name = "record" )
@XmlAccessorType (XmlAccessType.FIELD)
public class Record {
	
	int referenceNum;
	String accountNumber;
	String description;
	double startBalance;
	double mutation;
	double endBalance;

	public int getReference() {
		return referenceNum;
	}

    @XmlAttribute( name = "reference")
	public void setReference(int reference) {
		this.referenceNum = reference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(double startBalance) {
		this.startBalance = startBalance;
	}

	public double getMutation() {
		return mutation;
	}

	public void setMutation(double mutation) {
		this.mutation = mutation;
	}

	public String getDescripton() {
		return description;
	}

	public void setDescripton(String descripton) {
		this.description = descripton;
	}

	public double getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(double endBalance) {
		this.endBalance = endBalance;
	}

	@Override
	public String toString() {
		return "Record [reference=" + referenceNum + ", accountNumber=" + accountNumber + ", startBalance="
				+ startBalance + ", mutation=" + mutation + ", descripton=" + description + ", endBalance=" + endBalance
				+ "]";
	}

}
