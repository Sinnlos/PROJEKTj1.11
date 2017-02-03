package dao;

import domain.model.Book;
import domain.model.Person;

import java.util.List;

public interface IBookRepository extends IRepository<Book>{
	public List<Book> byPerson(Person person);
}
