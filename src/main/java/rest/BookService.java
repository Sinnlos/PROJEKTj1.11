package rest;

import dao.IRepositoryCatalog;
import domain.model.Book;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.BookDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("books")
@Stateless
public class BookService {
	IRepositoryCatalog catalog;
	Mapper mapper = new DozerBeanMapper();
	
	@PersistenceContext
    EntityManager mgr;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookDto> getAll() throws SQLException{

		List<Book> books =  mgr.createNamedQuery("book.all",Book.class).getResultList();
		List<BookDto> results = new ArrayList<BookDto>();
		for(Book a: books)
			results.add(mapper.map(a, BookDto.class));

		return results;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getaccount(@PathParam("id") int accountId){
		Book a = mgr.createNamedQuery("book.id", Book.class)
				.setParameter("bookId",accountId)
				.getSingleResult();
		if(a==null) 
			return Response.status(404).build();
		
		return	Response.ok(mapper.map(a, BookDto.class)).build();
	}
	
	
}
