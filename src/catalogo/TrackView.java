package catalogo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import catalogo.dao.TrackDAO;

@Path("/faixas")
public class TrackView {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getFaixas(@QueryParam("cd") String cd){
		
		if (cd == null) cd = " ";
		
		cd = cd.toLowerCase();
		
		TrackDAO dao = new TrackDAO();
		
		Gson jsonParse = new Gson();
		
		return jsonParse.toJson(dao.geTracksByCD(cd));
	}
	
}
