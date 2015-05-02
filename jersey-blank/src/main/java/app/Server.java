package app;

import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Server {

    public static void main(String... args) {
        URI uri = URI.create("http://localhost:8080/rest/");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(Calc.class);

        HttpServer httpServer = JdkHttpServerFactory.createHttpServer(uri, resourceConfig);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> httpServer.stop(0)));
    }
}
