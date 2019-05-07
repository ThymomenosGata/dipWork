import models.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

    private Connection mConnection;
    private Statement stm;

    public Update() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        mConnection = dataBaseConnection.getConnection();
        try {
            stm = mConnection.createStatement();
            mConnection .setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Result updateProfessor(Professor professor) {
        String sql = "update professor set surname = \'" + professor.getSurname()
                + "\', name = \'" + professor.getName()
                + "\', middlename = \'" + professor.getMiddlename()
                + "\', position = \'" + professor.getPosition()
                + "\',experience = " + professor.getExperience()
                + ",userid = " + professor.getUserID()
                + ", date_last_modify = \'" + professor.getDate_last_modify()
                + "\' where id = " + professor.getId() + ";";
        return executeUpdate(sql);

    }

    public Result updateStudents(Students students) {
        String sql = "update students set surname = \'" + students.getSurname()
                + "\', name = \'" + students.getName()
                + "\', middlename = \'" + students.getMiddlename()
                + "\', groupid = " + students.getGroupID()
                + ", avg_score = " + students.getAvg_score()
                + ", date_last_modify = \'" + students.getDate_last_modify()
                + "\',userid = " + students.getUserID()
                + " where id = " + students.getId() + ";";
        return executeUpdate(sql);
    }

    public Result updateNews(News news) {
        String sql = "update news set title = \'" + news.getTitle()
                + "\', small_description = \'" + news.getSmall_sedcription()
                + "\', full_description = \'" + news.getFull_description()
                + "\', date_last_modify = \'" + news.getDate_last_modify()
                + "\', is_published = " + news.getIs_published()
                + ", authorid = " + news.getAuthor()
                + " where id = " + news.getId() + ";";
        return executeUpdate(sql);
    }

    public Result updateUser(User user) {
        String sql = "update users set login = \'" + user.getLogin()
                + "\', password = \'" + user.getPassword()
                + "\', is_blocked =" + user.getIs_blocked()
                + ",date_last_modify =\'" + user.getDate_last_modify()
                + "\' where id = " + user.getId() + ";";
        return executeUpdate(sql);
    }

    public Result updateGroup(Group group) {
        String sql = "update sgroup set name = \'" + group.getName()
                + "\', count = " + group.getCount()
                + ", faculty =\'" + group.getFaculty()
                + "\', date_last_modify = \'" + group.getDate_last_modify()
                + "\' where id = " + group.getId() + ";";
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
