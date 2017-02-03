package dao.mappers;

import domain.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements IMapResultSetIntoEntity<Person> {

	public Person map(ResultSet rs) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setSurname(rs.getString("surname"));
		return p;
	}

}
