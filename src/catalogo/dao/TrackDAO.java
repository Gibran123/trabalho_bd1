package catalogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import catalogo.connection.ManagerConnection;
import catalogo.models.Songwriter;
import catalogo.models.Track;

public class TrackDAO extends BaseDAO<Track> {

	public List<Track> geTracksByCD(String cd){
		
		String cd2 = Character.toUpperCase(cd.charAt(0)) + cd.substring(1);
		
		String query = "select tr.descricao as Música, s.nome as Compositor from "
					+ "CD cd, Songwriter s, Songwriter_Track st, Track tr where "
					+ "s.cod = st.cod_sw and tr.cod = st.cod_track and tr.cod_cd = cd.cod "
					+ "and (cd.descricao LIKE '%"+cd+"%' or cd.descricao LIKE '%"+cd2+"%')";
		
		List<Track> tracks = new ArrayList<>();
		
		ManagerConnection manager = new ManagerConnection();
		
		Connection conn = manager.getConnection();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			pstm = conn.prepareStatement(query);
			
			rset = pstm.executeQuery();
			
			while(rset.next()){
				
				Track t = new Track();
				t.setSongwriters(new ArrayList<>());
				
				Songwriter sw = new Songwriter();
				
				t.setDescription(rset.getString(1));
				
				sw.setName(rset.getString(2));
				
				t.getSongwriters().add(sw);
				
				tracks.add(t);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			manager.releaseAll(conn, pstm, rset);
			
		}
		
		return tracks;
		
	}
	
}
