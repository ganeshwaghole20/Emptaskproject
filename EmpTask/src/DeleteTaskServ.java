

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteTaskServ")
public class DeleteTaskServ extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("tid");
		int id=Integer.parseInt(sid);
		EmpDao.deleteTask(id);
		response.sendRedirect("ViewTaskServ");
	}
}
