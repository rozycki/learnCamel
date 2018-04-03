package pl.com.rozyccy.learncamel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Marcin.Rozycki on 2018-03-28.
 */
public class SampleDirectRouteTest extends CamelTestSupport {
    @Override
    public RouteBuilder createRouteBuilder() {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {

        template.sendBody("direct:sampleInput", "1234,Dilip, Udemy Instructor");
        Thread.sleep(5000);

        File file = new File("sampleOutput");
        assertTrue(file.isDirectory());

        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}
