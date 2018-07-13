package model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name = "record" )
public class TransactionRecord {
	int reference;
	String accountNumber;
	int startBalance;
	int mutation;
	String descripton;
	int endBalance;

	public int getReference() {
		return reference;
	}

	public void setReference(int transactionReference) {
		this.reference = transactionReference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(int startBalance) {
		this.startBalance = startBalance;
	}

	public int getMutation() {
		return mutation;
	}

	public void setMutation(int mutation) {
		this.mutation = mutation;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public int getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(int endBalance) {
		this.endBalance = endBalance;
	}

	@Override
	public String toString() {
		return "TransactionRecord [reference=" + reference + ", accountNumber=" + accountNumber + ", startBalance="
				+ startBalance + ", mutation=" + mutation + ", descripton=" + descripton + ", endBalance=" + endBalance
				+ "]";
	}

}
