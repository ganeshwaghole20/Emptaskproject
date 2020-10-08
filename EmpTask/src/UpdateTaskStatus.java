
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UpdateTaskStatus")
public class UpdateTaskStatus extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nid[]=request.getParameterValues("name1");
		int id1;
		
		
		for(int i=0;i<nid.length;i++)
		{
			id1=Integer.parseInt(nid[i]);
			EmpDao.updateTaskStat(id1);
		}
		
		
//		int id=Integer.parseInt(sid);
//		EmpDao.deleteTask(id);
		response.sendRedirect("ViewTaskServ");
	}
}