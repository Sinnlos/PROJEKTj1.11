package web;

import domain.model.Book;
import domain.model.Person;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addBook")
public class AddAccountHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String amount = request.getParameter("amount");

		if (title == null  || title.equals("") ||amount==null || amount.equals("")) {
			response.sendRedirect("addBook.html");
		} 
			Person person = (Person) session.getAttribute("person");
		
		if (person == null) {
			response.sendRedirect("addPerson.html");
		}
		
		Book book = new Book();
		book.setAmount(Integer.parseInt(amount));
		book.setTitle(title);
		book.setPerson(person);
		List<Book> books = new ArrayList<Book>();
		if(session.getAttribute("books")!=null)
			books =(List<Book>) session.getAttribute("books");
		books.add(book);
		session.setAttribute("books", books);
		response.sendRedirect("addBook.html");

	}

}
