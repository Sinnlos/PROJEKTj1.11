package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BookDto {
	
	private int id;
	private int personId;
	private double amount;
	private String title;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return title;
	}
	public void setCurrency(String currency) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
