

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.codec.digest.DigestUtils;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		String npass=DigestUtils.md5Hex(password);    //new
	
		
		
		String myHash;
		Random random=new Random();
		random.nextInt(999999);
		myHash=DigestUtils.md5Hex(""+random);
		
		
		
		Emp e=new Emp();
		e.setFname(fname);
		e.setLname(lname);
		e.setGender(gender);
		e.setDob(dob);
		e.setEmail(email);
		e.setPassword(password);
		e.setMyhash(myHash);
		
		
		
		int status=EmpDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			out.print("<p>plz check your email for activation link!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
