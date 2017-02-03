package web;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.model.Book;
import domain.model.Person;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/finalize")
public class FinalizeHttpServlet extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		IRepositoryCatalog catalog;
		try {
			catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
			Person person = (Person)session.getAttribute("person");
			List<Book> books = (List<Book>)session.getAttribute("books");
			
			catalog.people().add(person);
			catalog.save();
			int id = catalog.people().getMaxId();
			for(Book book : books)
				{
					book.setPersonId(id);
					catalog.books().add(book);
					catalog.save();
					book.setId(catalog.books().getMaxId());

					catalog.save();
					System.out.println("Zapisano !!");
				}
			catalog.saveAndClose();
			session.removeAttribute("person");
			session.removeAttribute("books");
			response.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
	
}
