package luciDemoProject;

import java.sql.*;

public class Jdbc {

	public static  Connection con;
	public static PreparedStatement ps;
	
	public static void  createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucifer", "root", "root");
			System.out.println("Connection created.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void insertValues(int stuid, String stuname, double stuphn) {
		try {
			ps = con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, stuid);
			ps.setString(2,stuname);
			ps.setDouble(3, stuphn);
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("Inserted.");
			}else {
				System.out.println("Not Inserted.");
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
	
	public static void deleteRow(int stuid) {
		try {
			ps = con.prepareStatement("delete from student where stuid = "+ stuid);
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("Deleted.");
			}else {
				System.out.println("Not Deleted.");
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
	
	public static void updateMethod(int stuid , String stuname) {
		try {
			ps = con.prepareStatement("update student set stuname='"+stuname+"' where stuid = "+stuid);
			int a = ps.executeUpdate();
			if(a>0) {
				System.out.println("Updated.");
			}else{
				System.out.println("Not Updated.");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ResultSet selectValues() {
		try {
			ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			
			return rs;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void updateOneColumn(int id, String name) {
		try {
			PreparedStatement ps = con.prepareStatement("update student set stuname='"+name+"' where stuid = "+id);
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("UPDATED ONE COLUMN.");
			}else {
				System.out.println("NOT UPDATED ONE COLUMN.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void updateMultipleColumn(int stuid, String stuname, double stuphn) {
		try {
			String queryForMultipleColumnUpdate = "update student set stuname='"+stuname+"', stuphn="+stuphn+" where stuid = "+stuid;
			System.out.println(queryForMultipleColumnUpdate);
			PreparedStatement ps = con.prepareStatement(queryForMultipleColumnUpdate);
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("UPDATED MULTIPLE COLUMN.");
			}else {
				System.out.println("NOT UPDATED MULTIPLE COLUMN.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
