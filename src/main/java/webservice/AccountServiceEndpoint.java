package webservice;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bf50 on 2016/1/11.
 */
@WebService(serviceName = "AccountService")
public class AccountServiceEndpoint{

    @WebMethod
    public void insertAccount(Account account){
        System.out.println("insert one result : " + account);
    }

    @WebMethod
    public List<Account> getAccounts(){
        List<Account> result = new ArrayList<Account>();
        Account account1 = new Account("¹¤×Ê", 1900, "CNY");
        Account account2 = new Account("¸£Àû", 190, "USD");
        result.add(account1);
        result.add(account2);
        return result;
    }
}
