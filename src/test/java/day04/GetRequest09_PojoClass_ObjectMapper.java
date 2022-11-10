package day04;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.Customer;
import pojos.user;
import utilities.GMIBankBaseUrl;

import static junit.framework.Assert.assertEquals;

public class GetRequest09_PojoClass_ObjectMapper extends GMIBankBaseUrl {


    /*
http://www.gmibank.com/api/tp-customers/110452
 */

    @Test
    public void test09() {

        //set the url
        spec.pathParams("1","tp-customers","2","110452");
        // set the expected data
        //Account [] account;
        user user = new user(110016,"leopoldo.reinger", "Jasmine", "Stehr",
                "marni.zboncak@yahoo.com", true, "en", null, null);

        Country country = new Country(3, "USA", null);

        Customer expectedData = new Customer(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com"
                , "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs","761-59-2911"
                , "Waltermouth", "2021-11-28T21:00:00Z", false, country, "California", user);


        //send the url and set

        Response response= RestAssured.given().spec(spec).
                headers("Authorization", "Bearer " +generateToken())
                .when().get("/{1}/{2}");
        //response.prettyPrint();

        //do assertion
        Customer actualdata=response.as(Customer.class);
        System.out.println("actualdata = " + actualdata);

        assertEquals(expectedData.getId(),actualdata.getId());
        assertEquals(expectedData.getFirstName(),actualdata.getFirstName());
        assertEquals(expectedData.getLastName(),actualdata.getLastName());
        assertEquals(expectedData.getMiddleInitial(),actualdata.getMiddleInitial());
        assertEquals(expectedData.getEmail(),actualdata.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualdata.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(),actualdata.getPhoneNumber());
        assertEquals(expectedData.getZipCode(),actualdata.getZipCode());
        assertEquals(expectedData.getAddress(),actualdata.getAddress());
        assertEquals(expectedData.getCity(),actualdata.getCity());
        assertEquals(expectedData.getSsn(),actualdata.getSsn());
        assertEquals(expectedData.getCreateDate(),actualdata.getCreateDate());
        assertEquals(expectedData.getZelleEnrolled(),actualdata.getZelleEnrolled());

        assertEquals(expectedData.getCountry().getId(),actualdata.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(),actualdata.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(),actualdata.getCountry().getStates());

        assertEquals(expectedData.getUser().getId(),actualdata.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(),actualdata.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(),actualdata.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(),actualdata.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(),actualdata.getUser().getEmail());
        assertEquals(expectedData.getUser().getActivated(),actualdata.getUser().getActivated());
        assertEquals(expectedData.getUser().getLangKey(),actualdata.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(),actualdata.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(),actualdata.getUser().getResetDate());


/*
        //objectMapper
        Customer actualData2= ObjectMapperUtils.convertJsonToJava(response.asString(),Customer.class);

        assertEquals(expectedData.getId(),actualData2.getId());
        assertEquals(expectedData.getFirstName(),actualData2.getFirstName());
        assertEquals(expectedData.getLastName(),actualData2.getLastName());
        assertEquals(expectedData.getMiddleInitial(),actualData2.getMiddleInitial());
        assertEquals(expectedData.getEmail(),actualData2.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData2.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(),actualData2.getPhoneNumber());
        assertEquals(expectedData.getZipCode(),actualData2.getZipCode());
        assertEquals(expectedData.getAddress(),actualData2.getAddress());
        assertEquals(expectedData.getCity(),actualData2.getCity());
        assertEquals(expectedData.getSsn(),actualData2.getSsn());
        assertEquals(expectedData.getCreateDate(),actualData2.getCreateDate());
        assertEquals(expectedData.getZelleEnrolled(),actualData2.getZelleEnrolled());

        assertEquals(expectedData.getCountry().getId(),actualData2.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(),actualData2.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(),actualData2.getCountry().getStates());

        assertEquals(expectedData.getUser().getId(),actualData2.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(),actualData2.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(),actualData2.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(),actualData2.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(),actualData2.getUser().getEmail());
        assertEquals(expectedData.getUser().getActivated(),actualData2.getUser().getActivated());
        assertEquals(expectedData.getUser().getLangKey(),actualData2.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(),actualData2.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(),actualData2.getUser().getResetDate());

*/
    }
}
