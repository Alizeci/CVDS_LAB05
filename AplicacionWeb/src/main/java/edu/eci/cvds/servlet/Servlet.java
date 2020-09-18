package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.Service;
import edu.eci.cvds.servlet.model.Todo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	    urlPatterns = "/LJServlet"
)
public class Servlet extends HttpServlet{

    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Todo> todoList = new ArrayList<>();
        
    	Writer responseWriter = resp.getWriter();
    	
    	Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
        Integer idInt = (Integer.parseInt(optId.get()));
        
        try {
	    	Todo items = Service.getTodo(idInt);
	    	todoList.add(items);
	    		
	    	resp.setStatus(HttpServletResponse.SC_OK);
	    	resp.setContentType(Service.todosToHTMLTable(todoList));
	    	responseWriter.write(Service.todosToHTMLTable(todoList));
	    	responseWriter.flush();
	    	
        } catch (FileNotFoundException i) {
        	resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    		responseWriter.write("No existe un item con el identificador dado.");
        }
        
   }

}
