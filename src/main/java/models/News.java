package models;

public class News {
    int id;
    String title;
    String small_sedcription;
    String full_description;
    String date_publish;
    String date_last_modify;
    int is_published;
    int author;

    public News() {
    }

    public News(int id, String title, String small_sedcription, String full_description, String date_publish, String date_last_modify, int is_published, int author) {
        this.id = id;
        this.title = title;
        this.small_sedcription = small_sedcription;
        this.full_description = full_description;
        this.date_publish = date_publish;
        this.date_last_modify = date_last_modify;
        this.is_published = is_published;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmall_sedcription() {
        return small_sedcription;
    }

    public void setSmall_sedcription(String small_sedcription) {
        this.small_sedcription = small_sedcription;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public String getDate_publish() {
        return date_publish;
    }

    public void setDate_publish(String date_publish) {
        this.date_publish = date_publish;
    }

    public String getDate_last_modify() {
        return date_last_modify;
    }

    public void setDate_last_modify(String date_last_modify) {
        this.date_last_modify = date_last_modify;
    }

    public int getIs_published() {
        return is_published;
    }

    public void setIs_published(int is_published) {
        this.is_published = is_published;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

}
