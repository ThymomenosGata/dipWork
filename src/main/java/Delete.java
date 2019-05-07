import models.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    private Connection mConnection;
    private Statement stm;

    public Delete() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        mConnection = dataBaseConnection.getConnection();
        try {
            stm = mConnection.createStatement();
            mConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Result deleted(String table, int id) {
        String sql = "delete from " + table + " where id = " + id + ";";
        return executeUpdate(sql);
    }

    private Result executeUpdate(String sql) {
        Result result = new Result();
        try {
            stm.executeUpdate(sql);
            mConnection.commit();
            result.setMessage("successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setMessage("error deleted");
        }
        return result;
    }

}
