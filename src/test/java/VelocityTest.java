import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
public class VelocityTest {

    @Test
    public void test() throws IOException {
        Properties pro = new Properties();
        pro.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(pro);

        VelocityContext context = new VelocityContext();
        context.put("name", "zhangsan");

        Template template = Velocity.getTemplate("vms/qq.vm", "utf-8");

        FileWriter fw = new FileWriter("src/main/resources/html/qq.html");
        template.merge(context, fw);

        fw.close();

    }
}
