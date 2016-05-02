package app.controller;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Before run this test, you must run app.Application.
 */
public class GreetingControllerTest {

    @Test
    public void シンプルにアクセス() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/")
                .path("hello");

        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        assertThat(response, is("HelloWorld"));
    }

    @Test
    public void ステータスコードを確認() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/")
                .path("hello");

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is("HelloWorld"));
    }

    @Test
    public void リクエストにqueryParamを含める() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/")
                .path("hello")
                .queryParam("name", "Taro");

        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        assertThat(response, is("HelloTaro"));
    }

    @Test
    public void Timeoutを設定してTimeoutになったらProcessingExceptionが発生() {
        ClientConfig configuration = new ClientConfig();
        configuration.property(ClientProperties.CONNECT_TIMEOUT, 1000);
        configuration.property(ClientProperties.READ_TIMEOUT, 1000);
        Client client = ClientBuilder.newClient(configuration);

        try {
            WebTarget target = client.target("http://localhost:8080/")
                    .path("hello/timeout");
        } catch (ProcessingException e) {
            assertThat(e.getMessage(), is("java.net.SocketTimeoutException: Read timed out"));
        }
    }

    @Test
    @Ignore
    public void ProxyServer経由() {
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
