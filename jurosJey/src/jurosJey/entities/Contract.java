package jurosJey.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Contract {

	private int number;
	private Date Date;
	private double totalvalue;
	
	List<Installment> installment = new ArrayList<Installment>();
	
	public Contract() {
		
	}
	
	public Contract(int number, Date date, double totalvalue) {
		this.number = number;
		this.Date = date;
		this.totalvalue = totalvalue;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public double getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(double totalvalue) {
		this.totalvalue = totalvalue;
	}

	public List<Installment> getInstallment() {
		return installment;
	}
}
