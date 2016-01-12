package consumeRestfulWebservice.test;

import consumeRestfulWebservice.model.Quote;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bf50 on 2016/1/12.
 */
public class TestRestful {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        System.out.println(quote);
    }
}
