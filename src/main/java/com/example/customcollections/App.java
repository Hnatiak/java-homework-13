package com.example.customcollections;
import com.example.customcollections.task1.JsonPlaceholderClient;

public class App {
    public static void main(String[] args) throws Exception {
            JsonPlaceholderClient client = new JsonPlaceholderClient();


            String sampleUser = """
            {
            "name": "TestUser",
            "username": "Tester007",
            "email": "test@example.com"
            }
            """;


            client.createUser(sampleUser);
            client.updateUser(1, sampleUser);
            client.deleteUser(1);
            client.getAllUsers();
            client.getUserById(2);
            client.getUserByUsername("Bret");


            client.getLastPostComments(1);
            client.getOpenTodos(1);
    }
}