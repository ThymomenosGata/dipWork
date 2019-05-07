import com.google.gson.Gson;
import models.*;

import static spark.Spark.*;

public class MainClass {

    public static void main(String[] args) {
        Gson gson = new Gson();
        port(3356);

        Post mPost = new Post();
        Get mGet = new Get();
        Update update = new Update();
        Delete delete = new Delete();

        get("/getUsers", (request, response) -> {
            response.type("application/json");
            return mGet.getUsers();
        }, gson::toJson);

        get("/getStudents", (request, response) -> {
            response.type("application/json");
            return mGet.getStudents();
        }, gson::toJson);

        get("/getProfessors", (request, response) -> {
            response.type("application/json");
            return mGet.getProfessors();
        }, gson::toJson);

        get("/getNews", (request, response) -> {
            response.type("application/json");
            return mGet.getNews();
        }, gson::toJson);

        get("/getGroups", (request, response) -> {
            response.type("application/json");
            return mGet.getGroups();
        }, gson::toJson);

        get("/getGroupByName/:name", (request, response) -> {
            response.type("application/json");
            return mGet.getGroupByName(request.params(":name"));
        }, gson::toJson);

        get("/getNewsByName/:name", (request, response) -> {
            response.type("application/json");
            return mGet.getNewsByName(request.params(":name"));
        }, gson::toJson);

        get("/getSuccesAuth/:user", (request, response) -> {
            response.type("application/json");
            return mGet.getSuccesAuth(gson.fromJson(request.params(":user"), User.class));
        }, gson::toJson);

        get("/getUserByLogin/:login", (request, response) -> {
            response.type("application/json");
            return mGet.getUserByLogin(request.params(":login"));
        }, gson::toJson);

        get("/getProfessorByName/:name", (request, response) -> {
            response.type("application/json");
            return mGet.getProfessorByName(request.params(":name"));
        }, gson::toJson);

        get("/getStudentByName/:name", (request, response) -> {
            response.type("application/json");
            return mGet.getStudentByName(request.params(":name"));
        }, gson::toJson);

        post("/newGroup", (request, response) -> {
            response.type("application/json");
            return mPost.insertGroup(gson.fromJson(request.body(), Group.class));
        }, gson::toJson);

        post("/newNews", (request, response) -> {
            response.type("application/json");
            return mPost.insertNews(gson.fromJson(request.body(), News.class));
        }, gson::toJson);

        post("/newProfessor", (request, response) -> {
            response.type("application/json");
            return mPost.insertProfessor(gson.fromJson(request.body(), Professor.class));
        }, gson::toJson);

        post("/newStudent", (request, response) -> {
            response.type("application/json");
            return mPost.insertStudents(gson.fromJson(request.body(), Students.class));
        }, gson::toJson);

        post("/newUser", (request, response) -> {
            response.type("application/json");
            return mPost.insertUsers(gson.fromJson(request.body(), User.class));
        }, gson::toJson);

        delete("/deleteUser/:id", (request, response) -> {
            response.type("application/json");
            return delete.deleted("users", Integer.parseInt(request.params(":id")));
        }, gson::toJson);

        delete("/deleteGroup/:id", (request, response) -> {
            response.type("application/json");
            return delete.deleted("sgroup", Integer.parseInt(request.params(":id")));
        }, gson::toJson);

        delete("/deleteStudent/:id", (request, response) -> {
            response.type("application/json");
            return delete.deleted("students", Integer.parseInt(request.params(":id")));
        }, gson::toJson);

        delete("/deleteProfessor/:id", (request, response) -> {
            response.type("application/json");
            return delete.deleted("professor", Integer.parseInt(request.params(":id")));
        }, gson::toJson);

        delete("/deleteNews/:id", (request, response) -> {
            response.type("application/json");
            return delete.deleted("news", Integer.parseInt(request.params(":id")));
        }, gson::toJson);

        put("/updateUser", (request, response) -> {
            response.type("application/json");
            return update.updateUser(gson.fromJson(request.body(), User.class));
        }, gson::toJson);

        put("/updateGroup", (request, response) -> {
            response.type("application/json");
            return update.updateGroup(gson.fromJson(request.body(), Group.class));
        }, gson::toJson);

        put("/updateStudent", (request, response) -> {
            response.type("application/json");
            return update.updateStudents(gson.fromJson(request.body(), Students.class));
        }, gson::toJson);

        put("/updateProfessor", (request, response) -> {
            response.type("application/json");
            return update.updateProfessor(gson.fromJson(request.body(), Professor.class));
        }, gson::toJson);

        put("/updateNews", (request, response) -> {
            response.type("application/json");
            return update.updateNews(gson.fromJson(request.body(), News.class));
        }, gson::toJson);
    }
}