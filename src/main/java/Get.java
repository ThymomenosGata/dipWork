import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Get {

    private Connection mConnection;
    private PreparedStatement stm;

    public Get() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        mConnection = dataBaseConnection.getConnection();
        try {
            mConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> getGroups() throws SQLException {
        List<Group> groups = new ArrayList<>();
        String sql = "select * from sgroup";
        stm = mConnection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            groups.add(new Group(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("count"),
                    rs.getString("faculty"),
                    rs.getString("date_last_modify")));
        }
        rs.close();
        return groups;
    }

    public List<News> getNews() throws SQLException {
        List<News> news = new ArrayList<>();
        String sql = "select * from news";
        stm = mConnection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            news.add(new News(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("small_description"),
                    rs.getString("full_description"),
                    rs.getString("date_published"),
                    rs.getString("date_last_modify"),
                    rs.getInt("is_published"),
                    rs.getInt("authorid")));
        }
        rs.close();
        return news;
    }

    public List<Professor> getProfessors() throws SQLException {
        List<Professor> professors = new ArrayList<>();
        String sql = "select * from professor";
        stm = mConnection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            professors.add(new Professor(
                    rs.getInt("id"),
                    rs.getString("surname"),
                    rs.getString("name"),
                    rs.getString("middlename"),
                    rs.getString("position"),
                    rs.getInt("experience"),
                    rs.getInt("userid"),
                    rs.getString("date_last_modify")));
        }
        rs.close();
        return professors;
    }

    public List<Students> getStudents() throws SQLException {
        List<Students> students = new ArrayList<>();
        String sql = "select * from students";
        stm = mConnection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            students.add(new Students(
                    rs.getInt("id"),
                    rs.getString("surname"),
                    rs.getString("name"),
                    rs.getString("middlename"),
                    rs.getInt("groupid"),
                    rs.getInt("avg_score"),
                    rs.getString("date_last_modify"),
                    rs.getInt("userid")));
        }
        rs.close();
        return students;
    }

    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        stm = mConnection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            users.add(new User(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getInt("is_blocked"),
                    rs.getString("date_last_modify")));
        }
        rs.close();
        return users;
    }

    public Group getGroupByName(String name) throws SQLException {
        String sql = "select * from sgroup where name = ?";
        Group group = new Group();
        stm = mConnection.prepareStatement(sql);
        stm.setString(1, name);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            group.setId(rs.getInt("id"));
            group.setName(rs.getString("name"));
            group.setFaculty(rs.getString("faculty"));
            group.setCount(rs.getInt("count"));
            group.setDate_last_modify(rs.getString("date_last_modify"));
        }
        rs.close();

        return group;
    }

    public News getNewsByName(String title) throws SQLException {
        String sql = "select * from news where title = ?";
        News news = new News();
        stm = mConnection.prepareStatement(sql);
        stm.setString(1, title);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            news.setId(rs.getInt("id"));
            news.setAuthor(rs.getInt("authorid"));
            news.setDate_publish(rs.getString("date_published"));
            news.setFull_description(rs.getString("full_description"));
            news.setSmall_sedcription(rs.getString("small_description"));
            news.setIs_published(rs.getInt("is_published"));
            news.setTitle(rs.getString("title"));
            news.setDate_last_modify(rs.getString("date_last_modify"));
        }
        rs.close();
        return news;
    }

    public Result getSuccesAuth(User user) throws SQLException {
        Result result = new Result();
        String sql = "select * from users where login = ?";
        stm = mConnection.prepareStatement(sql);
        stm.setString(1, user.getLogin());
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            if (rs.getString("password").equals(user.getPassword())) {
                result.setMessage("successful");
            } else {
                result.setMessage("false password");
            }

        } else {
            result.setMessage("false login");
        }
        rs.close();
        return result;
    }

    public User getUserByLogin(String login) throws SQLException {
        String sql = "select * from users where login = ?";
        User user = new User();
        stm = mConnection.prepareStatement(sql);
        stm.setString(1, login);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setIs_blocked(rs.getInt("is_blocked"));
            user.setDate_last_modify(rs.getString("date_last_modify"));
        }
        rs.close();
        return user;
    }

    public Professor getProfessorByName(String name) throws SQLException {
        Professor professor = new Professor();
        String sql = "select * from professor where name = ?";
        stm = mConnection.prepareStatement(sql);
        stm.setString(1, name);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            professor.setId(rs.getInt("id"));
            professor.setDate_last_modify(rs.getString("date_last_modify"));
            professor.setExperience(rs.getInt("experience"));
            professor.setMiddlename(rs.getString("middlename"));
            professor.setName(rs.getString("name"));
            professor.setSurname(rs.getString("surname"));
            professor.setPosition(rs.getString("position"));
            professor.setUserID(rs.getInt("userid"));
        }
        rs.close();
        return professor;
    }

    public Students getStudentByName(String name) throws SQLException {
        Students student = new Students();
        String sql = "select * from students where name = ?";
        stm = mConnection.prepareStatement(sql);
        stm.setString(1, name);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            student.setId(rs.getInt("id"));
            student.setDate_last_modify(rs.getString("date_last_modify"));
            student.setAvg_score(rs.getInt("avg_score"));
            student.setMiddlename(rs.getString("middlename"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setGroupID(rs.getInt("groupid"));
            student.setUserID(rs.getInt("userid"));
        }
        rs.close();
        return student;
    }

}
