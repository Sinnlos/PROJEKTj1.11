package dao.mappers;

import dao.IRepository;
import domain.model.Book;
import domain.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements IMapResultSetIntoEntity<Book>{

	IRepository<Person> personRepo;
	
	
	
	public IRepository<Person> getPersonRepo() {
		return personRepo;
	}



	public void setPersonRepo(IRepository<Person> personRepo) {
		this.personRepo = personRepo;
	}



	public Book map(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setPersonId(rs.getInt("personid"));
		book.setAmount(rs.getDouble("amount"));
		book.setTitle(rs.getString("title"));
		if(personRepo!=null)
		book.setPerson(this.personRepo.get(book.getPersonId()));
		
		return book;
	}

}