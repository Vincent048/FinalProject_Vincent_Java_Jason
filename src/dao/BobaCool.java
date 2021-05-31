package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Random;

import db.ConnectDB;

public class BobaCool {

	Connection connection;
	Random ram = new Random();
	
	public BobaCool() {
		try {
			initDB();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}


	public void initDB() throws SQLException {
		connection = ConnectDB.connect();
		if(connection == null) {
			throw new SQLException("connection");
		}
	}
	
	
	public Vector<Vector<String>> getData1() {
		Vector<Vector<String>> data1 = new Vector<>();
		try {
		Statement stat = connection.createStatement();
		String sql = "select * from bobacool";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			Vector<String> row1 = new Vector<>();
			row1.add(rs.getString(1));
			row1.add(rs.getString(2));
			row1.add(rs.getString(3));
			row1.add(rs.getString(4));
			data1.add(row1);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return data1;
	}
	
	public void insertData(String nama, String harga, String stok) {
		try {
			Statement stat = connection.createStatement();
			String sql = "insert into bobacool values( '" + getLatestKode() + "', '" + nama + "', '" + Integer.parseInt(harga) + "', '" + Integer.parseInt(stok) + "')";
			stat.executeUpdate(sql);
			System.out.println("Success Input Data");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getLatestKode() {
		String id = "";
		String newId = "";
		
		String kode = "";
		kode = kode + ram.nextInt(10);
		kode = kode + ram.nextInt(10);
		kode = kode + ram.nextInt(10);
		
		try {
			Statement stmt = connection.createStatement();
			String sql = "select kodemenu from bobacool order by kodemenu DESC";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				id = rs.getString(1);
			}
			int latestkode= Integer.parseInt(id.substring(2));
			newId = "BC-" + kode;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newId;
	}
	
	public void updateData(String kode, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update bobacool set namamenu='" + nama + "', hargamenu='" + harga + 
					"', stokmenu='" + stok + "' where kodemenu='" + kode + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteData(String kode) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "delete from bobacool where kodemenu='" + kode + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	
}
