import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Singleton {
    private static Singleton instance;
    private Connection conn;
    private Singleton() throws RuntimeException {
        ResourceBundle rb = ResourceBundle.getBundle("Credentials");
        String url = rb.getString("url");
        String user = rb.getString("user");
        String password = rb.getString("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
       return instance;
    }
    public Connection getConnection() {
        return conn;
    }

}
