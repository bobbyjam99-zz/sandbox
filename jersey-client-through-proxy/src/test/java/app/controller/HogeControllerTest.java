package app.controller;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Before run this test, you must run app.Application.
 */
public class HogeControllerTest {

    @Test
    public void simpleSample(){
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/")
                .path("hello");

        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        assertThat(response, is("HelloWorld"));
    }

    @Test
    public void test2(){
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/")
                .path("hello")
                .queryParam("name", "Taro");

        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        assertThat(response, is("HelloTaro"));
    }

    @Test
    @Ignore
    public void jerseyClientThroughProxy() {
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
        assertTrue(true);
    }
}
