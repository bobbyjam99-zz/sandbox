package app;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcTest extends JerseyTest {

    @Test
    public void test() {
        int c = target("calc/add").queryParam("a", 2).queryParam("b", 3).request().get(int.class);
        assertThat(c, is(5));
    }

    @Override
    public Application configure() {
        return new ResourceConfig(Calc.class);
    }
}
