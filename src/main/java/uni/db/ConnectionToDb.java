package uni.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDb {
  public static Connection getDBConnection(){
      try {
          String dbUrl="jdbc:mysql://localhost:3307/universitysystem";
          String userName="root";
          String password="";
          Connection connection = (Connection) DriverManager.getConnection(dbUrl, userName, password);
          return connection;

      }
      catch (Exception  s) {
          s.printStackTrace();
          System.out.println("No");
          return null;
      }

  }
}
