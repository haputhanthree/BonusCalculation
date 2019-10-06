package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BonusUpdateModel {

	public static int insertBonus(int epf, int experience , int salary) {

// for insert a new candidate
		ResultSet rs = null;
		int candidateId = 0;

		String sql = "insert into bonus (epf , experience , salary) " + "VALUES(?,?,?)";

		try (Connection conn = MySQLJDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

// set parameters for statement
			pstmt.setInt(1, epf);
			pstmt.setInt(2, experience);
			pstmt.setInt(3, salary);			

			int rowAffected = pstmt.executeUpdate();
			if (rowAffected == 1) {
// get candidate id
				rs = pstmt.getGeneratedKeys();
				if (rs.next())
					candidateId = rs.getInt(1);

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return candidateId;
	}
	
		
	public static int[] previousBonus(int epf)  {
		// for insert a new candidate
				ResultSet rs = null;
				int salary = 0;
				int experience = 0;
				
			
				
				String sql = "SELECT salary , experience FROM test.bonus where epf = ?";

				//String sql = "INSERT INTO empdata(LastName,FirstName) " + "VALUES(?,?)";

				try (Connection conn = MySQLJDBCUtil.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

		// set parameters for statement
					pstmt.setInt(1, epf);
					
					ResultSet rs1 = pstmt.executeQuery();
					
					//STEP 5: Extract data from result set
				      while(rs1.next()){
				         //Retrieve by column name
				         salary  = rs1.getInt("salary");
				         experience  = rs1.getInt("experience");
				         
				         //Display values
				         System.out.print("salary: " + salary);
				         
				      }		      
				      				      				
					
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				
					
		return new int[] {salary,experience};
		
		
	}
}
