package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest07_Token_Alma_Authorization_Ile_JsonPath_Ve_Matcher_Ile_Dogrulama extends GMIBankBaseUrl {
/*
    http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
            “firstName”: “Melva”,
            “lastName”: “Bernhard”,
            “email”: “chas.kuhlman@yahoo.com”
            “zipCode”: “40207"
            “country” “name”: “San Jose”
            “login”: “delilah.metz”

 */

    @Test
    public void name() {

        // set the url
        spec.pathParams("1","tp-customers","2","110472");

        // set the expected data


        //send the request and get the response
            Response response=given().spec(spec).headers("Authorization","Bearer "+generateToken()).
                    when().
                    get("/{1}/{2}");
                    response.prettyPrint();

        //do assertion
        //Matcher ıle assertion
        response.then().assertThat().body("firstName", equalTo("Melva"),
                "lastName",equalTo("Bernhard"),
                "email",equalTo("chas.kuhlman@yahoo.com"),
                "zipCode",equalTo("40207"),
                "country.name",equalTo("San Jose"),
                "user.login",equalTo("delilah.metz"));

        //Json Path ile dogrulama
        JsonPath json=response.jsonPath();
        Assert.assertEquals("Melva",json.getString("firstName"));
        Assert.assertEquals("Bernhard",json.getString("lastName"));
        Assert.assertEquals("chas.kuhlman@yahoo.com",json.getString("email"));
        Assert.assertEquals("40207",json.getString("zipCode"));
        Assert.assertEquals("San Jose",json.getString("country.name"));
        Assert.assertEquals("delilah.metz",json.getString("user.login"));



    }
}
