package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	// 定数宣言
	static final String URL =  "jdbc:mysql://localhost/club?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	//findAll
	public ArrayList<Member> findAll(){
		ArrayList<Member> mlist = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){
			String sql = "SELECT * FROM member";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int mid = rs.getInt("mid");
				String name = rs.getString("name");
				String adr = rs.getString("adr");

				mlist.add(new Member(mid,name,adr));
			}

			stmt.close();

		}catch(SQLException e){
			System.out.println("findAllエラー" + e.getMessage());
		}


		return mlist;
	}

	//findByMid
	public Member findByMid(int mid) {
		Member m = null;

		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "select * from member where mid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, mid);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				String name = rs.getString("name");
				String adr = rs.getString("adr");
				m = new Member(mid,name,adr);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findByMidエラー" + e.getMessage());
		}

		return m;


	}

	//Insert
	public void Insert(Member m) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "INSERT INTO member (mid,name,adr) VALUES(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,m.getMid());
			stmt.setString(2, m.getName());
			stmt.setString(3, m.getAdr());

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("insertエラー" + e.getMessage());
		}
	}

	//update
	public void update(Member m) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "update member set name = ?,adr=? where mid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(3,m.getMid());
			stmt.setString(1, m.getName());
			stmt.setString(2, m.getAdr());

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("updateエラー" + e.getMessage());
		}
	}

	public void delete(int mid)
	{
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "delete from member where mid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, mid);

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("deleteエラー" + e.getMessage());
		}

	}


}
