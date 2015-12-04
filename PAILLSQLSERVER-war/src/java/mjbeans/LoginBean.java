/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rudy
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
    
    private static Connection connection = null;
    //1.jdbc driver name
    private static String SQL_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // 2. Database URL, V_UDAY\FRAMEWORK is ServerName and JSF is DataBase name
  //  private static String URL = "jdbc:sqlserver://RUDY-PC;instanceName=FRAMEWORK;databaseName=AdventureWorks2012";
    private static String URL = "jdbc:sqlserver://RUDY-PC;databaseName=AdventureWorks2012";
    
    //3.Database credentials
    private static String USERNAME = "sa";//UserName
    private static String PASSWORD = "Hackfire14$";//Password

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {

    }

    public void validarUser() {
        EntityManagerFactory managerFactory = null;
        Map<String, String> persistenceMap = new HashMap<String, String>();
       
  persistenceMap.put("provider", "org.eclipse.persistence.jpa.PersistenceProvider");
        persistenceMap.put("javax.persistence.jdbc.url", "jdbc:sqlserver://RUDY-PC;databaseName=AdventureWorks2012");
        persistenceMap.put("javax.persistence.jdbc.user", "sa");
        persistenceMap.put("javax.persistence.jdbc.password", "Hackfire14$");
        persistenceMap.put("javax.persistence.jdbc.driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//LoginBean l = Class.forName("org.eclipse.persistence.jpa.PersistenceProvider");
        
        managerFactory = Persistence.createEntityManagerFactory("PAILLSQLSERVER-ejbPU", persistenceMap);
        EntityManager manager = (EntityManager) managerFactory.createEntityManager();
   // EntityManager entityManager = (EntityManager) emf.createEntityManager();
    }
    
        public void validarUser3() {
            validarUser2();
        }

    

    
    public static Connection validarUser2() {
    try {
        Class.forName(SQL_JDBC_DRIVER);// Register jdbc driver

        System.out.println("****Connect to Database****");

        //4. open a connection
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if(connection == null){
              System.out.println("****Error en la conexion****");
        }else {
          
               System.out.println("****Exito en la conexxion****");
        }

        System.out.println("DataBase connect to: "+ connection.getMetaData().getDriverName());
        System.out.println("URL: "+ connection.getMetaData().getURL());

        setConnectionClose();
        System.out.println("Database Connection Closed");
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Exception in getLocalConeection() "+e.getMessage());
    }
    return connection;
}
    
    public static void setConnectionClose() throws SQLException {
    if (connection != null) {
        connection.close();
    }
}

}
