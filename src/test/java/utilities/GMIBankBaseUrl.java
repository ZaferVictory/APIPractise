package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GMIBankBaseUrl extends Authentication{

    protected RequestSpecification spec;


    @Before
    public void setUp(){
        spec=new RequestSpecBuilder().setBaseUri("http://www.gmibank.com/api/").build();
    }

}