

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");
		
		List<Emp> list=EmpDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'");
	//	out.print("<tr><th>Id</th><th>FirstName</th><th>Lastname</th><th>Gender</th><th>DOB</th><th>Email</th><th>Password</th><th>Activate user</th><th>DeActivate user</th></tr>");
		out.print("<tr><th>Id</th><th>FirstName</th><th>Lastname</th><th>status</th><th>Activate user</th><th>DeActivate user</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFname()+"</td><td>"+e.getLname()+"</td><td>"+e.getStatus()+"</td><td><a href='ActivateServlet?id="+e.getId()+"'>Activate</a></td><td><a href='DeActivateServlet?id="+e.getId()+"'>DeActivate</a></td></tr>");
		}
		out.print("</table>");
		
		out.print("<a href='index.html'>Logout</a>");
	
		
		out.close();
	}
}
