package catalogo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("faixa")
@Produces(MediaType.TEXT_PLAIN)
public class Faixa {

	@GET
	public String getHello(){
		return "Hello";
	}
	
}
