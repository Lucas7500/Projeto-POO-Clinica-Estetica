import java.awt.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.JOptionPane;

import com.clinicaestetica.Models.Cliente;
import com.clinicaestetica.Models.Clinica;
import com.clinicaestetica.Models.Pacote;
import com.clinicaestetica.Models.Profissional;
import com.clinicaestetica.Models.Sessao;
import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.TipoPacote;



public class Main {

	private static final Component frame = null;

	public static void main(String[] args) {
		
		String jdbcUrl = System.getenv("JDBC_URL");
		String username = System.getenv("MY_USER_NAME");
		String password = System.getenv("MY_USER_PASSWORD");
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(jdbcUrl, username, password);
			
			if (connection != null) {
				System.out.println("connected");
			} else {
				System.out.println("failed");
			}
			
			Statement stmt = connection.createStatement();
			
			ResultSet a = stmt.executeQuery("select * from teste");
			
			while(a.next()) {
				long teste = 123;
				long teste2 = (long)a.getInt(3);
				var cl = new Cliente(   a.getString(2),teste2 ,teste , 'M');
				
				System.out.println(cl.toString());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		

	}

}
