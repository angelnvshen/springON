package httpInvoker;

import java.util.Map;

/**
 * Created by CHANEL on 2016/1/10.
 */
public interface HttpInvokerService {
    public String getString(String msg);
    public Map<String, Object> getMap(String map);

    public Car getCar();
}
