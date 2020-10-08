

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet3")
public class EditServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update task Status</h1>");
		String sid=request.getParameter("tid");
		int id=Integer.parseInt(sid);
		
		Task t=EmpDao.getTaskById(id);
		
		out.print("<form action='EditServlet4' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='tid' value='"+t.getTid()+"'/></td></tr>");
		out.print("<tr><td>Task name</td><td><input type='text' name='tname' value='"+t.getTname()+"'/></td></tr>");
		out.print("<tr><td>Task Desrcription</td><td><input type='text' name='tdescri' value='"+t.getTdesc()+"'/></td></tr>");
//		out.print("<tr><td>Task Status</td><td><input type='text' name='tstatus' value='"+t.getTstatus()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("<tr><td><a href=\"ViewTaskServ\">Back</a></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
