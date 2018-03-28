package pl.com.rozyccy.learncamel.file;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Marcin.Rozycki on 2018-03-28.
 */
public class CopyFilesRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException {

        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());
        assertEquals(2, file.listFiles().length);
    }
}
