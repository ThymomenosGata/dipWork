import models.*;

import java.sql.*;

public class Post {

    private Connection mConnection;
    private PreparedStatement stm;

    public Post() {
        try {
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            mConnection = dataBaseConnection.getConnection();
            mConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Result insertGroup(Group group) {
        String sql = "insert into sgroup(id, name, count, faculty, date_last_modify) values(nextVal('grid'),?,?,?,?);";
        Result result = new Result();
        try {
            stm = mConnection.prepareStatement(sql);
            stm.setString(1, group.getName());
            stm.setInt(2, group.getCount());
            stm.setString(3, group.getFaculty());
            stm.setString(4, group.getDate_last_modify());
            stm.executeUpdate();
            mConnection.commit();
            result.setMessage("successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setMessage("server error: " + e.getMessage());
        }
        return result;
    }

    public Result insertNews(News news) {

        String sql = "insert into news(id, title, small_description, full_description, date_published, date_last_modify, is_published, authorid) values(nextVal('nwId'),?,?,?,?,?,?,?);";
        Result result = new Result();
        try {
            stm = mConnection.prepareStatement(sql);
            stm.setString(1, news.getTitle());
            stm.setString(2, news.getSmall_sedcription());
            stm.setString(3, news.getFull_description());
            stm.setString(4, news.getDate_publish());
            stm.setString(5, news.getDate_last_modify());
            stm.setInt(6, news.getIs_published());
            stm.setInt(7, news.getAuthor());
            stm.executeUpdate();
            mConnection.commit();
            result.setMessage("successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setMessage("server error: " + e.getMessage());
        }
        return result;
    }

    //TODO: check columns
    public Result insertProfessor(Professor professor) {
        String sql = "insert into professor(id, surname, name, middlename, position, experience, userid, date_last_modify) values(nextVal('prId'),?,?,?,?,?,?,?);";
        Result result = new Result();
        try {
            stm = mConnection.prepareStatement(sql);
            stm.setString(1, professor.getSurname());
            stm.setString(2, professor.getName());
            stm.setString(3, professor.getMiddlename());
            stm.setString(4, professor.getPosition());
            stm.setInt(5, professor.getExperience());
            stm.setInt(6, professor.getUserID());
            stm.setString(7, professor.getDate_last_modify());
            stm.executeUpdate();
            mConnection.commit();
            result.setMessage("successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setMessage("server error: " + e.getMessage());
        }
        return result;
    }

    public Result insertStudents(Students students) {
        String sql = "insert into students(id, surname, name, middlename, groupid, avg_score, date_last_modify, userid) values(nextVal('stId'),?,?,?,?,?,?,?);";
        Result result = new Result();
        try {
            stm = mConnection.prepareStatement(sql);
            stm.setString(1, students.getSurname());
            stm.setString(2, students.getName());
            stm.setString(3, students.getMiddlename());
            stm.setInt(4, students.getGroupID());
            stm.setInt(5, students.getAvg_score());
            stm.setString(6, students.getDate_last_modify());
            stm.setInt(7, students.getUserID());
            stm.executeUpdate();
            mConnection.commit();
            result.setMessage("successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setMessage("server error: " + e.getMessage());
        }
        return result;
    }

    public Result insertUsers(User user) {
        String sql = "select * from users where login = ?";
        Result result = new Result();
        try {
            stm = mConnection.prepareStatement(sql);
            stm.setString(1, user.getLogin());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                result.setMessage("login error");
                rs.close();
                return result;
            } else {
                sql = "insert into users(id, login, password, is_blocked, date_last_modify) values(nextVal('usId'),?,?,?,?);";
                stm = mConnection.prepareStatement(sql);
                stm.setString(1, user.getLogin());
                stm.setString(2, user.getPassword());
                stm.setInt(3, user.getIs_blocked());
                stm.setString(4, user.getDate_last_modify());
                stm.executeUpdate();
                result.setMessage("successful");
            }
            mConnection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            result.setMessage("server error: " + e.getMessage());
        }
        return result;
    }

}
