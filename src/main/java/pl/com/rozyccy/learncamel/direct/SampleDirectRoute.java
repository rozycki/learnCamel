package pl.com.rozyccy.learncamel.direct;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Marcin.Rozycki on 2018-03-28.
 */
public class SampleDirectRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received message is ${body} and headers are ${headers}")
                .to("file:sampleOutput?fileName=output.txt");
    }
}
