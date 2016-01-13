package oxm.service;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Service;
import oxm.model.Settings;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by bf50 on 2016/1/13.
 */
@Service
public class OxmService {
//    @Resource(name = "castorMarshaller")
    @Resource(name = "jaxb2Marshaller")
    private Marshaller marshaller;

//    @Resource(name = "castorMarshaller")
    @Resource(name = "jaxb2Marshaller")
    private Unmarshaller unmarshaller;

    public <T> void saveSettings ( T bean, String file_name) throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file_name);
            this.marshaller.marshal(bean, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    public <T> void loadSettings( T bean, String file_name) throws IOException {
        FileInputStream is = null;
        try {
            File file = new File(file_name);
            if(!file.exists())
                file.createNewFile();

            is = new FileInputStream(file);
            bean = (T) this.unmarshaller.unmarshal(new StreamSource(is));
            System.out.println(bean);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }


}
