package catalogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import catalogo.connection.ManagerConnection;

public class BaseDAO<E> {

	public Long insert(E entity, Object...params){
		
		String query = DAOHelper.createInsertQuery(entity.getClass());
		
		System.out.println(query);
		
		ManagerConnection manager = new ManagerConnection();
		
		Connection conn = manager.getConnection();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			pstm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			int i = 0;
			for (Object obj : params) {
				pstm.setObject(++i, obj);
			}
			
			pstm.executeUpdate();
			
			rset = pstm.getGeneratedKeys();
			
			if (rset.next()) {
				return rset.getLong(1);
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
			
		}finally {
			manager.releaseAll(conn, pstm);
		}
		
		return 0l;
		
	}
	
	public void remove(E entity, Object...params){
		
		String query = DAOHelper.createRemoveQuery(entity.getClass());
		
		System.out.println(query);
		
		ManagerConnection manager = new ManagerConnection();
		
		Connection conn = manager.getConnection();
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			int i = 0;
			for (Object obj : params) {
				pstm.setObject(++i, obj);
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			manager.releaseAll(conn, pstm);
		}
		
	}
	
	public void update(E entity, Object...params){
		
		String query = DAOHelper.createUpdateQuery(entity.getClass());
		
		System.out.println(query);
		
		ManagerConnection manager = new ManagerConnection();
		
		Connection conn = manager.getConnection();
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			int i = 0;
			for (Object obj : params) {
				pstm.setObject(++i, obj);
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			manager.releaseAll(conn, pstm);
		}
		
	}
	
}
