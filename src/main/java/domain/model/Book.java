package domain.model;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name = "book.all", query = "SELECT b FROM Book b"),
	@NamedQuery(name = "book.id", query = "SELECT b FROM Book  b where b.id=:id"),
	@NamedQuery(name = "book.byPerson", query = "SELECT b FROM Book  b where b.person.id=:person_Id")
})
public class Book implements IHaveId{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int personId;
	@ManyToOne
	private Person person;

	private double amount;
	private String title;
	

	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
