package burlap.inter;

import burlap.model.Food;
import com.caucho.burlap.server.BurlapServlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bf50 on 2016/1/8.
 */
public class FoodServiceImpl extends BurlapServlet implements FoodService {
    public List<Food> getFoods() {
        List<Food> lst = new ArrayList<Food>();
        Food f1=new Food();
        f1.setName("À·≤À”„");
        f1.setPrice(25);
        Food f2=new Food();
        f2.setName("Ã«¥◊”„");
        f2.setPrice(23);
        lst.add(f1);
        lst.add(f2);
        return lst;
    }
}
