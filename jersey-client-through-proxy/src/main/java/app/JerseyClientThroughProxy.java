package app;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class JerseyClientThroughProxy {

    public static void main(String... args) throws Exception {

        ClientConfig config = new ClientConfig();
        config.connectorProvider(new ApacheConnectorProvider());

        config.property(ClientProperties.PROXY_URI, "http://proxy.server:8080");
        config.property(ClientProperties.PROXY_USERNAME, "username");
        config.property(ClientProperties.PROXY_PASSWORD, "password");

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target("http://weather.livedoor.com/")
                .path("forecast/webservice/json/v1")
                .queryParam("city", "130010");

        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        System.out.println(response);
    }
}
