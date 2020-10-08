

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActivateAccount
 */
@WebServlet("/ActivateAccount")
public class ActivateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("key1");
		String hash=request.getParameter("key2");
		
		Connection con=EmpDao.getConnection();
		
		try
		{
			PreparedStatement pst=con.prepareStatement("select email,hash,isact from empt where email=? AND hash=?");
			pst.setString(1, email);
			pst.setString(2, hash);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				PreparedStatement pst1=con.prepareStatement("update empt set isact=1 where email=? AND hash=?");
				pst1.setString(1, email);
				pst1.setString(2, hash);
				int i=pst1.executeUpdate();
				if(i==1)
				{
					//response.sendRedirect("index.html");
					out.print("<p>Email Verified Successfully</p>");
					request.getRequestDispatcher("index.html").include(request, response);
				}
				
				else
				{
					response.sendRedirect("index1.html");
				}
				
			}
		}
		
		catch(Exception ex)
		{
			System.out.println("Activate Account"+ex);
		}
		
		
		
		
	}

	

}
