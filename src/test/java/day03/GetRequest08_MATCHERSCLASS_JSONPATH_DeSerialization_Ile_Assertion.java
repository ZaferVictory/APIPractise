package day03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.GMIBankBaseUrl;

import java.util.HashMap;
import java.util.Map;

public class GetRequest08_MATCHERSCLASS_JSONPATH_DeSerialization_Ile_Assertion extends GMIBankBaseUrl {
    
    /*
    http://www.gmibank.com/api/tp-customers/43703
            “firstName”: “Alda”,
            “lastName”: “Monahan”,
            “middleInitial”: “Nichelle Hermann Kohler”,
            “email”: “com.github.javafaker.Name@7c011174@gmail.com”,
            “mobilePhoneNumber”: “909-162-8114”,
            “city”: “St Louis”,
            “ssn”: “108-53-6655"
            1) MATCHERS CLASS
          2) JSON PATH
          3) De-Serialization

     */

    @Test
    public void test08() {
        spec.pathParams("1","tp-customers","2","43703");
        
        //expected data olustur
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstName","Alda");
        expectedData.put("lastName","Monahan");
        expectedData.put("middleInitial","Nichelle Hermann Kohler");
        expectedData.put("email","com.github.javafaker.Name@7c011174@gmail.com");
        expectedData.put("mobilePhoneNumber","909-162-8114");
        expectedData.put("city","St Louis");
        expectedData.put("ssn","108-53-6655");

        System.out.println("expectedData = " + expectedData);

        //request response olustur
        Response response= RestAssured.given().spec(spec).
                headers("Authorization", "Bearer " +generateToken())
                .when().get("/{1}/{2}");
        response.prettyPrint();


      // 1) MATCHERS CLASS


      // 2) JSON PATH


        //3) De-Serialization
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("middleInitial"),actualData.get("Nichelle Hermann Kohle"));
        Assert.assertEquals(expectedData.get("email"),actualData.get("com.github.javafaker.Name@7c011174@gmail.com"));
        Assert.assertEquals(expectedData.get("mobilePhoneNumber"),actualData.get("909-162-8114"));
        Assert.assertEquals(expectedData.get("city"),actualData.get("St Louis"));
        Assert.assertEquals(expectedData.get("ssn"),actualData.get("108-53-6655"));







    }
}
