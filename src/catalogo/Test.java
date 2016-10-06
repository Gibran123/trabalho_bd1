package catalogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		
		String server = "localhost";
        String port = "1521";              

        String user = "hr";
        String passwd = "oracle";
		
        
        try {
        	
            String url = "jdbc:oracle:thin:@//" + server + ":" + port + "/orcl";

            // Abre-se a conexão com o Banco de Dados
            Connection con = DriverManager.getConnection(url, user, passwd);

            // Cria-se Statement com base na conexão con
            Statement stmt = con.createStatement();

            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}

}
