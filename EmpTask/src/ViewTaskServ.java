
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewTaskServ")
public class ViewTaskServ extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//		out.println("<a href='taskadd.html'>Add new Task</a>");
		out.println("<h1>Task List</h1>");
		
		List<Task> list1=EmpDao.getAllTasks();
		
		out.print("<form method=\"get\" action=\"UpdateTaskStatus\" >");
		out.print("<table border='1' width='100%'");
	//	<form method="post" action="multiple-checkbox.jsp" >;
		
		out.print("<tr><th>select</th><th>taskid</th><th>Taskname</th><th>TaskDescri</th><th>TaskStatus</th><th>Edit</th><th>Delete</th></tr>");
		for(Task t:list1){
			out.print("<tr><td><input type=\"checkbox\" name=\"name1\" value="+t.getTid()+" />&nbsp;</td><td>"+t.getTid()+"</td><td>"+t.getTname()+"</td><td>"+t.getTdesc()+"</td><td>"+t.getTstatus()+"</td><td><a href='EditServlet3?tid="+t.getTid()+"'>edit</a></td><td><a href='DeleteTaskServ?tid="+t.getTid()+"'>delete</a></td></tr>");
		}
		
		out.print("<input type=\"submit\" value=\"complete\">");
		out.print("</table>");
		out.print("</form>");
	//	out.print("<a href=\"UpdateTaskStatus\">Complete</a>");
		out.print("<a href='index.html'>Logout</a>");
		
		out.close();
	}
}
