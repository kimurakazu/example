package ensyu_model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDao {
	// 定数宣言
			static final String URL =  "jdbc:mysql://localhost/memo?useSSL=false";
			static final String USER = "java";
			static final String PASS = "pass";

	//findAll
	public ArrayList<Memo> findAll(){
		ArrayList<Memo> mlist = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){
			String sql = "SELECT * FROM memo";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int mid = rs.getInt("mid");
				String title = rs.getString("title");
				String body = rs.getString("body");
				Date utime = rs.getDate("utime");
				mlist.add(new Memo(mid,title,body,utime));
			}
			stmt.close();
		}catch(SQLException e){
			System.out.println("findAllエラー" + e.getMessage());
		}
		return mlist;
	}

	//findByNumber
		public Memo findByMid(int mid) {
			Memo m = null;
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){
				String sql = "select * from memo where mid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, mid);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()){
					String title = rs.getString("title");
					String body = rs.getString("body");
					Date utime = rs.getDate("utime");
					m = new Memo(mid,title,body,utime);
				}
				stmt.close();
				} catch (SQLException e) {
				System.out.println("findByMidエラー" + e.getMessage());
			}
			return m;
		}
}
