

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveTaskser")
public class SaveTaskser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String tname=request.getParameter("tname");
		String tdescri=request.getParameter("tdescri");
		String tstatus="new";
	
		Task t=new Task();
		t.setTname(tname);
		t.setTdesc(tdescri);
		t.setTstatus(tstatus);
		
		int status=EmpDao.saveTask(t);
		if(status>0){
			out.print("<p>Task added successfully!</p>");
			request.getRequestDispatcher("taskadd.html").include(request, response);
			out.print("<a href='index.html'>Logout</a>");
		}else{
			out.println("Sorry! unable to add task");
			out.print("<a href='index.html'>Back</a>");
		}
		
		out.close();
	}

}

