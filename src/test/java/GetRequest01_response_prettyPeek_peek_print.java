import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01_response_prettyPeek_peek_print {

    @Test
    public void test01() {
        String url="https://restful-booker.herokuapp.com/booking";

       Response response= given().when().get(url);
       //response.prettyPrint();>> response dekı body' ı yazdırır
     // response.prettyPeek();//response de kı her seyı yazdırır.

        //response.peek();//body'ı  string olrak verir
        //response.print();//tum datayı strıng olarak yazdırır
        //given().when().get(url) end poınt  egondermek ıcın request olusturmus olduk
        //Response response API tarafından bana donen cevap
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // Junıt assertleri ile API testi yapabılırız
        Assert.assertEquals("status kod hatalı",200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        //2 assetthat ıle dogrulama bu hard assert'tur.
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");




    }
}
