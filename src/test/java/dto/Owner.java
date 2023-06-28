package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("firstName")
    public String getFirstName() { return firstName; }
    @JsonProperty("firstName")
    public void setFirstName(String value) { this.firstName = value; }

    @JsonProperty("lastName")
    public String getLastName() { return lastName; }
    @JsonProperty("lastName")
    public void setLastName(String value) { this.lastName = value; }

    @JsonProperty("address")
    public String getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(String value) { this.address = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("telephone")
    public String getTelephone() { return telephone; }
    @JsonProperty("telephone")
    public void setTelephone(String value) { this.telephone = value; }

}
