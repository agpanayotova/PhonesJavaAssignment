package extending;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {


	public static Connection conn = null;
	
	public static Connection getConnection() {


		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost//home/whoisagp/Desktop/PhonesJavaAssignment/H2DB/phonesDB.h2.db\n", "sa", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return conn;
		}
		
	}
}
