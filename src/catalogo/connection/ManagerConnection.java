package catalogo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class ManagerConnection {

	private static final ThreadLocal<Connection> context = new ThreadLocal<>();
	
	private static final String server = "localhost";
	private static final String port = "1521";              
	private static final String user = "hr";
	private static final String passwd = "oracle";
	
	public Connection getConnection(){
		
		Connection con = null;
		
		 try {
	        	
			 	Class.forName("oracle.jdbc.driver.OracleDriver");
			 
	            String url = "jdbc:oracle:thin:@//" + server + ":" + port + "/orcl";

	            con = DriverManager.getConnection(url, user, passwd);

	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
		
		return con;
		
	}
	
	public void beginTransaction() throws SQLException {
		
		Connection conn = getConnection();
		
		conn.setAutoCommit(false);
		
		context.set(conn);
	}
	
	
	public void endTransaction() throws SQLException {
		
		commit( getConnectionFromContext() );
		
		releaseTransaction();
		
	}
	
	private void releaseTransaction() throws SQLException {
		
		Connection conn = getConnectionFromContext();
		
		release(conn);
		
		context.remove();
		
	}
	
	private void rollbackTransaction() throws SQLException {
		
		Connection conn = getConnectionFromContext();
		
		rollback(conn);
		
		release(conn);
		
		context.remove();
		
	}
	
	private void rollback (Connection conn) throws SQLException {
		
		if (conn != null) conn.rollback();
		
	}

	private Connection getConnectionFromContext() throws SQLException {
		
		Connection conn = context.get();
		
		if (conn == null) throw new SQLException("Transação inválida!");
		
		if (conn.isClosed()) throw new SQLException("Transação inválida, Conexão fechada!");
		
		return conn;
		
	}

	public void commit(Connection conn) throws SQLException {
		
		conn.commit();
		
	}
	
	public void release(Connection conn) {
		
		if (conn == null) return;
		
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void release(ResultSet rset) {
		
		if (rset == null) return;
		
		try {
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void releaseAll(Connection conn, Statement stm){
		release(stm);
		release(conn);
	}
	
	public void releaseAll(Connection conn, Statement stm, ResultSet rset){
		releaseAll(conn, stm);
		release(rset);
	}

	private void release(Statement stm) {
		
		if (stm == null) return;
		
		try {
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
