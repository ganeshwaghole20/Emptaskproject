import java.util.*;
import java.sql.*;

public class EmpDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mstuddb","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into empt(fname,lname,gender,dob,email,password,rdate,hash) values (?,?,?,?,?,?,?,?)");
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3,e.getGender());
			ps.setString(4,e.getDob());
			ps.setString(5,e.getEmail());
			ps.setString(6,e.getPassword());
			ps.setTimestamp(7, date);
			ps.setString(8, e.getMyhash());
			
			status=ps.executeUpdate();
			
			if(status!=0)
			{
				SendingEmail se=new SendingEmail(e.getEmail(),e.getMyhash());
				se.sendMail();
				
			}
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	

	
	public static int activate(int id){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
//			PreparedStatement ps=con.prepareStatement("delete from empt where id=?");
			PreparedStatement ps=con.prepareStatement("update empt set isact=1 where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	
	public static int deactivate(int id){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
//			PreparedStatement ps=con.prepareStatement("delete from empt where id=?");
			PreparedStatement ps=con.prepareStatement("update empt set isact=0 where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	
	
	public static boolean login(Emp e){
		boolean stats=false;
		try{
			Connection con=EmpDao.getConnection();
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from empt where email='"+e.getEmail()+"' and password='"+e.getPassword()+"'");
			
			rs.next();
			if(rs.getString("password").equals(e.getPassword())&&rs.getString("email").equals(e.getEmail())&&rs.getString("email").equals("sonia@gmail.com")&&rs.getString("password").equals("sonia12")&&rs.getInt("isact")==1)
			{
				
				stats=true;
			
			}
			else{
				stats=false;
			}
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return stats;
	}
	
	
	public static boolean loginuser(Emp e){
		boolean user=false;
		try{
			Connection con=EmpDao.getConnection();
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from empt where email='"+e.getEmail()+"' and password='"+e.getPassword()+"'");
			
			rs.next();
			if(rs.getString("password").equals(e.getPassword())&&rs.getString("email").equals(e.getEmail()))
			{
				
				user=true;
			
			}
			else{
				user=false;
			}
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return user;
	}
	
	
	
	public static boolean isact(Emp e){
		boolean isactivate=false;
		try{
			Connection con=EmpDao.getConnection();
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from empt where email='"+e.getEmail()+"' and password='"+e.getPassword()+"'");
			
			rs.next();
			if(rs.getString("password").equals(e.getPassword())&&rs.getString("email").equals(e.getEmail())&&rs.getInt("isact")==1)
			{
				
				isactivate=true;
			
			}
			else{
				isactivate=false;
			}
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return isactivate;
	}
	
	
	
	
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from empt where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setFname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setDob(rs.getString(5));
				e.setEmail(rs.getString(6));
				e.setPassword(rs.getString(7));
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from empt");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				
				e.setFname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setDob(rs.getString(5));
				e.setEmail(rs.getString(6));
				e.setPassword(rs.getString(7));
				e.setStatus(rs.getInt(8));
				
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static int saveTask(Task t){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into task(tname,tdesc,tstatus,tdate) values (?,?,?,?)");
			java.sql.Timestamp date1 = new java.sql.Timestamp(new java.util.Date().getTime());
			ps.setString(1,t.getTname());
			ps.setString(2,t.getTdesc());
			ps.setString(3,t.getTstatus());
			ps.setTimestamp(4, date1);
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	
	public static int updateTask(Task t){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update task set tname=?,tdesc=? where tid=?");
			ps.setString(1,t.getTname());
			ps.setString(2,t.getTdesc());
			ps.setInt(3,t.getTid());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	
	
	public static int deleteTask(int tid){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from task where tid=?");
			ps.setInt(1,tid);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	
	public static int updateTaskStat(int tid){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update task set tstatus='completed' where tid=?");
			ps.setInt(1,tid);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	
	
	
	
	public static Task getTaskById(int tid){
		Task t=new Task();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from task where tid=?");
			ps.setInt(1,tid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTdesc(rs.getString(3));
				t.setTstatus(rs.getString(4));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return t;
	}
	
	
	
	
	public static List<Task> getAllTasks(){
		List<Task> list1=new ArrayList<Task>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps1=con.prepareStatement("select * from task");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				Task t=new Task();
			
				t.setTid(rs1.getInt(1));
				t.setTname(rs1.getString(2));
				t.setTdesc(rs1.getString(3));
				t.setTstatus(rs1.getString(4));
				list1.add(t);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list1;
	}
	
	
	public static EmpGraph getEmployee(){
		EmpGraph eg=new EmpGraph();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select count(*) as numuser from empt where rdate>DATE_SUB(NOW(), INTERVAL 7 day)");
		
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				eg.setNewuser(rs.getInt(1));
				
			}
			
			PreparedStatement ps1=con.prepareStatement("select count(*) as activate from empt where rdate>DATE_SUB(NOW(), INTERVAL 7 day) and isact=1");
			
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()){
				
				eg.setActivateuser(rs1.getInt(1));
				
			}
			
			
			
			PreparedStatement ps2=con.prepareStatement("select count(*) as task from task where tdate>DATE_SUB(NOW(), INTERVAL 7 day)");
			
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()){
				
				eg.setTotaltask(rs2.getInt(1));
				
			}
			
			
			
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return eg;
	}
	
	
	
	
	
}
