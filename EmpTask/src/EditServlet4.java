

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet4")
public class EditServlet4 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("tid");
		int id=Integer.parseInt(sid);
		String tname=request.getParameter("tname");
		String tdescri=request.getParameter("tdescri");
		//String tstatus=request.getParameter("tstatus");
			
		Task t=new Task();
		t.setTid(id);
        t.setTname(tname);
        t.setTdesc(tdescri);
     //   t.setTstatus(tstatus);
        
        
		int status=EmpDao.updateTask(t);
		if(status>0){
			response.sendRedirect("ViewTaskServ");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
