package conector;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionsql {


private static String URL = "jdbc:mysql://localhost:3306/viajakidb";
private static String USUARIO = "root";
private static String SENHA = "root";

public static Connection createconnectionsql() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
    
    return connection;
}



public static void main(String[] args) throws Exception {
    Connection con = createconnectionsql();
    
    if (con != null) {
        System.out.println(con + "\n\n ****  Conex�o obtida com sucesso!  ****");
        con.close();
    }
}
}