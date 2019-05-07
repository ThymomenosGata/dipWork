import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String DATABASE = "kurs";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "qwerTy2019";
    private static String URL = "jdbc:postgresql://165.22.129.138:5432/";
    private Connection connection;


    public DataBaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
