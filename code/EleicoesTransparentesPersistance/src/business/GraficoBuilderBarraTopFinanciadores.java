package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufba.mata62.eleicoestransparentes.model.AgenteEleitoral;

public class GraficoBuilderBarraTopFinanciadores extends GraficoBuilder {

	@Override
	public void buildValores() {
		   Connection conn = null;
		   Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      String sql = "select pj.nome, sum(t.valor) as valor " +
		      		"from Transacao t inner join PessoaFisica pj on pj.id = t.debitado_id  " +
		      		"where t.tipo = 'R' and t.tipoDebitado = 'PessoaFisica' " +
		      		"group by t.debitado_id order by sum(t.valor) desc LIMIT 5;";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String nome  = rs.getString("pj.nome");
		         double financimento = rs.getDouble("valor");
		         PontosGrafico ponto = new PontosGrafico(nome, financimento);
		         this.graficoFinal.getPontosGrafico().add(ponto);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try		
	}

	@Override
	public void buildTipo() {
		this.graficoFinal.setTipo("bar");
		
	}

	@Override
	public void buildNome() {
		this.graficoFinal.setNome("Maiores financiadores");
		
	}

}
