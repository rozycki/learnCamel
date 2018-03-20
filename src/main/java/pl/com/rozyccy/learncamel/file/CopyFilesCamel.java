package pl.com.rozyccy.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by Marcin.Rozycki on 2018-03-16.
 */
public class CopyFilesCamel {

    public static void main(String[] args) {

        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("file:data/output");
                }
            });

            context.start();

            Thread.sleep(5000);

            context.stop();

        } catch (Exception e) {
            System.out.println("Exception is: " + e);
            e.printStackTrace();
        }
    }
}
