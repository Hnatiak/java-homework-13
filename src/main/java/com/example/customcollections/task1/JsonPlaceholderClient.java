package com.example.customcollections.task1;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonPlaceholderClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final HttpClient client = HttpClient.newHttpClient();

    private HttpRequest buildRequest(String endpoint, String method, String body) {
        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(URI.create(BASE_URL + endpoint));

        switch (method) {
                case "POST":
                case "PUT":
                builder.method(method, HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json");
                break;
                case "DELETE":
                builder.DELETE();
                break;
                default:
                builder.GET();
            }

        return builder.build();
    }


    private void sendRequest(HttpRequest request) throws Exception {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }


    public void createUser(String jsonBody) throws Exception {
        sendRequest(buildRequest("/users", "POST", jsonBody));
    }


    public void updateUser(int id, String jsonBody) throws Exception {
        sendRequest(buildRequest("/users/" + id, "PUT", jsonBody));
    }


    public void deleteUser(int id) throws Exception {
        sendRequest(buildRequest("/users/" + id, "DELETE", null));
    }


    public void getAllUsers() throws Exception {
        sendRequest(buildRequest("/users", "GET", null));
    }


    public void getUserById(int id) throws Exception {
        sendRequest(buildRequest("/users/" + id, "GET", null));
    }


    public void getUserByUsername(String username) throws Exception {
        sendRequest(buildRequest("/users?username=" + username, "GET", null));
    }


    public void getLastPostComments(int userId) throws Exception {
        sendRequest(buildRequest("/posts?userId=" + userId + "&_limit=1&_sort=id&_order=desc", "GET", null));
    }


    public void getOpenTodos(int userId) throws Exception {
        sendRequest(buildRequest("/todos?userId=" + userId + "&completed=false", "GET", null));
    }
}
