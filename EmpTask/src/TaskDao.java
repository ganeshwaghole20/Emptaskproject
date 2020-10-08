import java.util.*;
import java.sql.*;

public class TaskDao {
	
//	public static Connection getConnection(){
//		Connection con=null;
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mstuddb","root","root");
//		}catch(Exception e){System.out.println(e);}
//		return con;
//	}
//	
//	
//	
//	public static List<Task> getAllTasks(){
//		List<Task> list1=new ArrayList<Task>();
//		
//		try{
//			Connection con=TaskDao.getConnection();
//			PreparedStatement ps=con.prepareStatement("select * from task");
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()){
//				Task t=new Task();
//			
//				t.setTid(rs.getInt(1));
//				t.setTname(rs.getNString(2));
//				t.setTdesc(rs.getString(3));
//				t.setTstatus(rs.getString(4));
//				list1.add(t);
//			}
//			con.close();
//		}catch(Exception e){e.printStackTrace();}
//		
//		return list1;
//	}
//	
//	
//	

}
