package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO {
	private Connection con ;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public StudentDAOImpl() {
		this.con = Connector.requestConnection();
	}


	
	public boolean insertStudent(Student s) {
		String query = "INSERT INTO STUDENT VALUES (0,?,?,?,?,?,?,SYSDATE())";
		int res=0;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
	}
		
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
}

	
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		 String query="UPDATE STUDENT SET name=?,phone=?,mail=?,branch=?,location=?,password=?,date=SYSDATE() WHERE ID=?";
		 int res=0;
		 try {
		 ps=con.prepareStatement(query);
		 ps.setString(1, s.getName());
		 ps.setLong(2,s.getPhone());
		 ps.setString(3, s.getMail());
		 ps.setString(4, s.getBranch());
		 ps.setString(5, s.getLocation());
		 ps.setString(6, s.getPassword());
		 ps.setInt(7, s.getId());
		 res=ps.executeUpdate();
	
	} catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 if(res>0) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}



	public boolean deleteStudent(int id) {
		PreparedStatement ps=null;
		 String query="DELETE FROM STUDENT WHERE id=? AND id!=1";
		 int res=0;
		 try {
		 ps=con.prepareStatement(query);
		
		 ps.setInt(1, id); 
		 res=ps.executeUpdate();
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 if(res>0) {
			 return true;
		 }else {
			 return false;
		 }
		}

		
	
	public Student getStudent(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query = "SELECT * FROM STUDENT WHERE mail = ?  AND password = ?";
		Student s=null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						s = new Student();
						s.setId(rs.getInt("id"));
						s.setName(rs.getString("name"));
						s.setPhone(rs.getLong("phone"));
						s.setMail(rs.getString("mail"));
						s.setBranch(rs.getString("branch"));
						s.setLocation(rs.getString("location"));
						s.setPassword(rs.getString("password"));
						s.setDate(rs.getString("date"));
						
						
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return s;
	}

	
	public Student getStudent(long phone, String mail) {
		 PreparedStatement ps=null;
		 String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?";
		 Student s=null;
		 try {
		 ps=con.prepareStatement(query);
		
		 ps.setLong(1, phone);
		 ps.setString(2, mail);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
		 s=new Student();
		 s.setId(rs.getInt("id"));
		 s.setName(rs.getString("name"));
		 s.setPhone(rs.getLong("phone"));
		 s.setMail(rs.getString("mail"));
		 s.setBranch(rs.getString("branch"));
		 s.setLocation(rs.getString("location"));
		 s.setPassword(rs.getString("password"));
		 s.setDate(rs.getString("date"));
		 }
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 return s;
		}
	


	public ArrayList<Student> getStudent() {
		PreparedStatement ps=null;
		 String query="SELECT * FROM STUDENT where id!=1";
		 ArrayList<Student> studentsList=new ArrayList<>();
		 Student s=null;
		 try {
		 ps=con.prepareStatement(query);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
		 s=new Student();
		 s.setId(rs.getInt("id"));
		 s.setName(rs.getString("name"));
		 s.setPhone(rs.getLong("phone"));
		 s.setMail(rs.getString("mail"));
		 s.setBranch(rs.getString("branch"));
		 s.setLocation(rs.getString("location"));
		 s.setPassword(rs.getString("password"));
		 s.setDate(rs.getString("date"));
		 
		 studentsList.add(s);
		 }
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } 
		 // TODO Auto-generated method stub
		 return studentsList;
		}

	



public ArrayList<Student> getStudent(String name) {
	 PreparedStatement ps=null;
	 String query="SELECT * FROM STUDENT WHERE NAME=?";
	 ArrayList<Student> students=new ArrayList<>();
	 Student s=null;
	 try {
	 ps=con.prepareStatement(query);
	 ps.setString(1,name);
	 ResultSet rs=ps.executeQuery();
	 while(rs.next()) {
	 s=new Student();
	 s.setId(rs.getInt("id"));
	 s.setName(rs.getString("name"));
	 s.setPhone(rs.getLong("phone"));
	 s.setMail(rs.getString("mail"));
	 s.setBranch(rs.getString("branch"));
	 s.setLocation(rs.getString("location"));
	 s.setPassword(rs.getString("password"));
	 s.setDate(rs.getString("date"));
	 students.add(s);
	 }
	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 } 
	 // TODO Auto-generated method stub
	 return students;
	}



//public Student getStudentByEmail(String mail) {
//    Student s = null;
//    String query = "SELECT * FROM STUDENT WHERE MAIL=?";
//    try {
//        PreparedStatement ps = con.prepareStatement(query);
//        ps.setString(1, mail);
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            s = new Student();
//            s.setId(rs.getInt("id"));
//            s.setName(rs.getString("name"));
//            s.setPhone(rs.getLong("phone"));
//            s.setMail(rs.getString("mail"));
//            s.setBranch(rs.getString("branch"));
//            s.setLocation(rs.getString("location"));
//            s.setPassword(rs.getString("password"));
//            s.setDate(rs.getString("date"));
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return s;
//}


}
