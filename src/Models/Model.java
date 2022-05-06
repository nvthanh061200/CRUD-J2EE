package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Obj.SinhVien;

public class Model {
	String SELECT = "SELECT * FROM sinhvien";
	Connection connection;
	private void open() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
            connection.setAutoCommit(false);
        } catch (Exception e) {
        	System.out.print(e.getMessage());
        }
	}
	
	public List<SinhVien> getAll(){
		List<SinhVien> list = new ArrayList<SinhVien>();
		try {
			open();
			PreparedStatement sta = connection.prepareStatement(SELECT);
			ResultSet resultSet = sta.executeQuery();
			while(resultSet.next()) {
				list.add(new SinhVien(
						resultSet.getString(1),
                        resultSet.getString(2)
						));
			}
			connection.commit();
			connection.close();
		}catch(Exception e) {
			System.out.print(e.getMessage());
			list = null;
		}
		return list;
	}
	
	public boolean insert(SinhVien sv) {
		try {
			open();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO sinhvien (name) VALUES(?)");
                statement.setString(1, sv.name);
                               
                statement.execute();
                connection.commit();
                connection.close();
            } catch (Exception ex) {
                return false;
            }
    
		return true;
	}
	
	public boolean delete(String id) {
		try {
			open();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM SinhVien WHERE id=?");
                
                statement.setInt(1, Integer.parseInt(id));
               
                statement.execute();
                connection.commit();
                connection.close();
            } catch (Exception ex) {
                return false;
            }
    
		return true;
	}
}
