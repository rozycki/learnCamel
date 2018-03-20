package pl.com.rozyccy.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by Marcin.Rozycki on 2018-03-20.
 */
public class CopyFilesCamelMultiRoute {

    public static void main(String[] args) {

        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .log("Received Message is ${body} and Headers are ${headers}")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output")
                    .to("file:data/anotheroutput");

                    from("file:data/input1?noop=true")
                            .to("file:data/output1");
                }
            });

            context.start();

            Thread.sleep(5000);

            context.stop();

        } catch (Exception e) {
            System.out.println("Exception is: " + e);
        }
    }
}
