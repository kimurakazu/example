package ensyu_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ResDAO {
	// 定数宣言
		static final String URL =  "jdbc:mysql://localhost/keijiban?useSSL=false";
		static final String USER = "java";
		static final String PASS = "pass";

		//findAll
		public ArrayList<Res> findAll(){
			ArrayList<Res> rlist = new ArrayList<>();

			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){
				String sql = "SELECT * FROM res order by number desc";
				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					int number = rs.getInt("number");
					String name = rs.getString("name");
					String main = rs.getString("main");
					Timestamp time = rs.getTimestamp("time");

					rlist.add(new Res(number,name,main,time));
				}

				stmt.close();

			}catch(SQLException e){
				System.out.println("findAllエラー" + e.getMessage());
			}


			return rlist;
		}

		//findByNumber
		public Res findByNumber(int number) {
			Res r = null;
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

				String sql = "select * from res where number = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, number);

				ResultSet rs = stmt.executeQuery();

				if(rs.next()){
					String name = rs.getString("name");
					String main = rs.getString("main");
					Timestamp time = rs.getTimestamp("time");
					r = new Res(number,name,main,time);
				}

				stmt.close();

			} catch (SQLException e) {
				System.out.println("findByNumberエラー" + e.getMessage());
			}
			return r;
		}


		//Insert
		public void insert(Res r) {
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

				String sql = "INSERT INTO res (name,main,time) VALUES(?,?,now())";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,r.getName());
				stmt.setString(2, r.getMain());

				stmt.execute();

				stmt.close();

			} catch (SQLException e) {
				System.out.println("Insertエラー" + e.getMessage());
			}
		}


		//del
		public void delete(int number) {
			try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

				String sql = "delete from res where number = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, number);

				stmt.executeUpdate();

				stmt.close();

			} catch (SQLException e) {
				System.out.println("deleteエラー" + e.getMessage());
			}
		}

}
