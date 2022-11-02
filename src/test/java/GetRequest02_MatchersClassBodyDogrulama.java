import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02_MatchersClassBodyDogrulama {

    @Test
    public void test02() {
        String url="https://reqres.in/api/users";
        Response response=given().when().get(url);
        response.prettyPrint();

        //header test
        response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK");


        //Body Test
        /* idsi 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */
        // Matcher class'ı ile
        response.then().body("data[0].email", Matchers.equalTo("george.bluth@reqres.in"),// ıd olarak 1 ancak biz bunu index olarak 0 yazıyoruz
                "data[0].first_name",Matchers.equalTo("George"),
                        "data[0].last_name", Matchers.equalTo("Bluth"));

    }
}
