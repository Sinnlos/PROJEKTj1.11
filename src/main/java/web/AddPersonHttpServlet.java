package web;

import domain.model.Person;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns="/addPerson")
public class AddPersonHttpServlet extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String nameSession = request.getParameter("name");
		String surnameSession = request.getParameter("surname");

		if (nameSession != null && !nameSession.equals("") && surnameSession != null && !surnameSession.equals("")) {


		Person person = new Person();
		person.setName(nameSession);
		person.setSurname(surnameSession);
		session.setAttribute("person", person);
			response.sendRedirect("addBook.html");
	}
	else {
			response.sendRedirect("addPerson.html");
		}



	}
	
}
