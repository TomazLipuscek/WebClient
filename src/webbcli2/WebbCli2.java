/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbcli2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tomaž
 */
public class WebbCli2 {
    private static String email;
    private static String sporocilo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
                int n = args.length;
                for(int i=0; i<n; i++){
                if (args[i].equals("-s")){

                  email = args[i+1];

            }
                else if (args[i].equals("-m")){

                  sporocilo = args[i+1];

            }
            }

            //String result = operation(email,sporocilo);
            //System.out.println(result);
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();


			conn = DriverManager.getConnection("jdbc:mysql://localh"
                                + "ost:3306/sporocila1?zeroDateTime"
                                + "Behavior=convertToNull&useSSL=false", "root", "root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM sporocila1");
			while (rs.next()) {
                            if (rs.getString("email").equals(email)){
                                String idM = rs.getString("id");
                                String emailM = rs.getString("email");
                                String sporociloM = rs.getString("sporocilo");
                                System.out.println("ID: "+idM);
                                System.out.println("Posiljatelj: "+emailM);
                                System.out.println("Sporocilo: "+sporociloM);
                            }
                            if (rs.getString("sporocilo").equals(sporocilo)){
                                String idM = rs.getString("id");
                                String emailM = rs.getString("email");
                                String sporociloM = rs.getString("sporocilo");
                                System.out.println("ID: "+idM);
                                System.out.println("Posiljatelj: "+emailM);
                                System.out.println("Sporocilo: "+sporociloM);
                            }
			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}

    }

    //private static String operation(java.lang.String email, java.lang.String sporocilo) {
    //    lip.NewWebService3_Service service = new lip.NewWebService3_Service();
    //    lip.NewWebService3 port = service.getNewWebService3Port();
    //    return port.operation(email, sporocilo);
    //}
    
}
