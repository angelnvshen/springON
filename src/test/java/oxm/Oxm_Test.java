package oxm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import oxm.model.Settings;
import oxm.model.Student;
import oxm.service.OxmService;

import java.io.IOException;

/**
 * Created by bf50 on 2016/1/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mvc.xml")
public class Oxm_Test {

    @Autowired
    private OxmService oxmService;

    @Test
    public void testOxmMarshaller(){
        Settings settings = new Settings();
        Student student = new Student("YIN", 24);
        try {
            oxmService.saveSettings(student, "student.xml");
            oxmService.loadSettings(student, "student.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
