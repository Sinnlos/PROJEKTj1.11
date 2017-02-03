package dao;

import domain.model.Person;

import java.util.List;

public interface IPersonRepository 
	extends IRepository<Person>{
	
	public List<Person> withName(String name);
}
