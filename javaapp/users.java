import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class users {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/users";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check if status code is 200 (OK)
            if (response.statusCode() == 200) {
                System.out.println("Users data fetched successfully:");
                System.out.println(response.body());
            } else {
                System.out.println("Failed to fetch data. Status code: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
