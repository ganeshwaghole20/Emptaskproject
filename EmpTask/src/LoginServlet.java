


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
//		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
//		String country=request.getParameter("country");
		
		Emp e=new Emp();
//		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
//		e.setCountry(country);
		
		boolean status=EmpDao.login(e);
		boolean user=EmpDao.loginuser(e);
		boolean isactivate=EmpDao.isact(e);
		
		if(status==true&&user==true){
			out.print("<p>login successfully as Admin!</p>");
//			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<a href=\"ViewServlet\">view employees</a>");
			out.print("<a href=\"ViewGraph\">view Graph</a>");
			out.print("<a href='index.html'>Back</a>");
			
		}else if(status==false&&user==true){
			
			if(isactivate==true)
			{
			
			out.print("<p>login successfully as User!</p>");
//			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<a href=\"ViewTaskServ\">view Task</a>");
			out.println("<a href='taskadd.html'>Add New Task</a>");
			out.print("<a href='index.html'>Logout</a>");
			
			}
			
			else
			{
				out.println("user is Deactivated");
				out.print("<a href='index.html'>Back</a>");
			}
			
			
		}
		
		
		else
		{
			out.println("invalid username and password");
			out.print("<a href='index.html'>Back</a>");
		}
		
		out.close();
	}

}
