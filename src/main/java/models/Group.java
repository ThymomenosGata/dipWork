package models;

public class Group {
    int id;
    String name;
    int count;
    String faculty;
    String date_last_modify;

    public Group() {
    }

    public Group(String name, int count, String faculty, String date_last_modify) {
        this.name = name;
        this.count = count;
        this.faculty = faculty;
        this.date_last_modify = date_last_modify;
    }

    public Group(int id, String name, int count, String faculty, String date_last_modify) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.faculty = faculty;
        this.date_last_modify = date_last_modify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDate_last_modify() {
        return date_last_modify;
    }

    public void setDate_last_modify(String date_last_modify) {
        this.date_last_modify = date_last_modify;
    }

}
