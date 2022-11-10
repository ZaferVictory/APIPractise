package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryPost {

    private String name;

    public CountryPost(String name) {
        this.name = name;
    }

    public CountryPost() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryPost{" +
                "name='" + name + '\'' +
                '}';
    }
}
