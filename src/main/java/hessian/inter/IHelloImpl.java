package hessian.inter;

import com.caucho.hessian.server.HessianServlet;
import org.springframework.remoting.caucho.HessianExporter;

/**
 * Created by bf50 on 2016/1/8.
 */
public class IHelloImpl extends HessianServlet implements IHello {
    public String sayHello(String name) {
        return "Hello , " + name;
    }
}
