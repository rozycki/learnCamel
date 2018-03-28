package pl.com.rozyccy.learncamel.file;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Marcin.Rozycki on 2018-03-28.
 */
public class CopyFilesRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:data/output");
    }
}
