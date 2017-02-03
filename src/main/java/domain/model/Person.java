package domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
	@NamedQuery(name = "person.all", query = "SELECT p FROM Person p"),
	@NamedQuery(name = "person.id", query = "SELECT p FROM Person p WHERE p.id=:personId")

})
public class Person implements IHaveId{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;

	@OneToMany(mappedBy="person")
	private List<Book> books;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

