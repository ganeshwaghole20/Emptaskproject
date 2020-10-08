

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewGraph")
public class ViewGraph extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		EmpGraph eg=EmpDao.getEmployee();
		
		out.print("<table border='1' width='100%'");
	//	out.print("<tr><th>Id</th><th>FirstName</th><th>Lastname</th><th>Gender</th><th>DOB</th><th>Email</th><th>Password</th><th>Activate user</th><th>DeActivate user</th></tr>");
		out.print("<tr><th>new user</th><th>Activate user</th><th>total task</th></tr>");
		
			out.print("<tr><td>"+eg.getNewuser()+"</td><td>"+eg.getActivateuser()+"</td><td>"+eg.getTotaltask()+"</td></tr>");
		
		out.print("</table>");
		
		
		
		
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>BarGraph</title>\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"BarGraph.css\">\r\n" + 
				"	  <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
				"\r\n" + 
				"	<script type=\"text/javascript\">\r\n" + 
				"		google.charts.load('current', {packages: ['corechart', 'bar']});\r\n" + 
				"google.charts.setOnLoadCallback(drawBasic);\r\n" + 
				"\r\n" + 
				"function drawBasic() \r\n" + 
				"{\r\n" + 
				"        var data = google.visualization.arrayToDataTable\r\n" + 
				"        ([\r\n" + 
				"         ['Element', 'In last seven days', { role: 'style' }],\r\n" + 
				"         ['New Users', "+eg.getNewuser()+", '#b87333'],      \r\n" + 
				"         ['Active Users', "+eg.getActivateuser()+", 'blue'],        \r\n" + 
				"         ['Total Task',"+eg.getTotaltask()+", 'green'],\r\n" + 
				"         ]);\r\n" + 
				"      var options = {\r\n" + 
				"        title: 'Report',\r\n" + 
				"        chartArea:{width :'30%'},\r\n" + 
				"        bar: {groupWidth: \"60%\"},\r\n" + 
				"        hAxis: \r\n" + 
				"        {\r\n" + 
				"          title: 'Users data in last seven days',\r\n" + 
				"        },\r\n" + 
				"        vAxis: \r\n" + 
				"        {\r\n" + 
				"          title: 'Users (scale of 1-50)'\r\n" + 
				"        }\r\n" + 
				"      };\r\n" + 
				"\r\n" + 
				"      var chart = new google.visualization.ColumnChart(\r\n" + 
				"        document.getElementById('chart_div'));\r\n" + 
				"\r\n" + 
				"      chart.draw(data, options);\r\n" + 
				"    }\r\n" + 
				"	</script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div id=\"chart_div\" class=\"chart\"></div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		out.print("<a href='index.html'>Logout</a>");
	
		
		out.close();
	}
}
