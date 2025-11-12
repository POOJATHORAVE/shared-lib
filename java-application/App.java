// File: App.java
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws IOException {
        int port = 9090;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new InfoHandler());

        System.out.println("System Info Server running on http://localhost:" + port + "/");
        server.start();
    }

    static class InfoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String hostname = InetAddress.getLocalHost().getHostName();
            String time = LocalDateTime.now().toString();
            String javaVersion = System.getProperty("java.version");

            String response = """
                System Info Server
                
                Hostname: %s
                Current Time: %s
                Java Version: %s
                """.formatted(hostname, time, javaVersion);

            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
