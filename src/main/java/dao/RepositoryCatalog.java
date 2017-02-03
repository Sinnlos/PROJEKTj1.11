package dao;

import dao.mappers.BookMapper;
import dao.mappers.PersonMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryCatalog implements IRepositoryCatalog{

	IUnitOfWork uow;
	Connection connection;
	
	public RepositoryCatalog(String url) throws SQLException, ClassNotFoundException {
		super();

			Class.forName("org.hsqldb.jdbcDriver");
			this.connection = DriverManager.getConnection(url);
			this.uow = new UnitOfWork(this.connection);
	}
	
	public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
		super();
		this.uow = uow;
		this.connection = connection;
	}

	
	public IPersonRepository people() {
		return new PersonRepository(this.connection, new PersonMapper(), this.uow);
	}

	public IBookRepository books() {
		return new BookRepository(this.connection, new BookMapper(), people(), this.uow);
	}



	public void saveAndClose() {
		try{
		this.uow.commit();
		this.connection.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	public void save() {
		try {
			this.uow.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
