import com.example.customcollections.task1.JsonPlaceholderClient;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class ApiClientTests {
    @Test
        void basicNetworkingTest() {
        JsonPlaceholderClient client = new JsonPlaceholderClient();
        assertNotNull(client);
    }
}
