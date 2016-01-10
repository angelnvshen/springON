package httpInvoker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHANEL on 2016/1/10.
 */
public class HttpInvokerServiceImpl implements HttpInvokerService {

    public String getString(String msg) {
        return "hello : " + msg;
    }

    public Map<String, Object> getMap(String map) {
        Map<String, Object> testMap = new HashMap<String, Object>();
        testMap.put("m1", 1);
        testMap.put("m2", "2");
        List<String> list = new ArrayList<String>();
        list.add("213");
        list.add("456");
        testMap.put("m3", list);
        testMap.put(map, map);
        System.out.println("Ô¶³Ìµ÷ÓÃ:" + map);
        return testMap;
    }

    public Car getCar() {
        Car c = new Car();
        c.setName("Farri");
        c.setCapacity(100);
        return c;
    }
}
