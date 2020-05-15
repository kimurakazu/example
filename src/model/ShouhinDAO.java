package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShouhinDAO {
	// 定数宣言
	static final String URL =  "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	//select
	public ArrayList<Shouhin> findAll() {
			ArrayList<Shouhin> list = new ArrayList<>();
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

				String sql = "select * from shouhin";
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while(rs.next()){
					int sid = rs.getInt("sid");
					String sname = rs.getString("sname");
					int tanka = rs.getInt("tanka");

					Shouhin s = new Shouhin(sid,sname,tanka);
					list.add(s);

				}

				stmt.close();

			} catch (SQLException e) {
				System.out.println("findAllエラー" + e.getMessage());
			}
			return list;
		}

	//Insert
	public void insert(Shouhin s) {
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

				String sql = "INSERT INTO shouhin (sname,tanka) VALUES(?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,s.getName());
				stmt.setInt(2, s.getTanka());

				stmt.execute();

				stmt.close();

			} catch (SQLException e) {
				System.out.println("insert" + e.getMessage());
			}
		}

	//update
	public void update(Shouhin s) {
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

				String sql = "update shouhin set sname=?,tanka = ? where sid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, s.getName());
				stmt.setInt(2, s.getTanka());
				stmt.setInt(3,s.getSid());

				stmt.executeUpdate();

				stmt.close();

			} catch (SQLException e) {
				System.out.println("updateエラー" + e.getMessage());
			}
		}

	//find
	public Shouhin findBySid(int sid) {
			Shouhin s = null;
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

				String sql = "select * from shouhin where sid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, sid);

				ResultSet rs = stmt.executeQuery();

				if(rs.next()){
					String sname = rs.getString("sname");
					int tanka = rs.getInt("tanka");
					s = new Shouhin(sid,sname,tanka);
				}

				stmt.close();

			} catch (SQLException e) {
				System.out.println("findBySidエラー" + e.getMessage());
			}
			return s;
		}

	//delete
	public void delete(int sid) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "delete from shouhin where sid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("deleteエラー" + e.getMessage());
		}
	}
}
