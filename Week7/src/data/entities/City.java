package data.entities;

public class City {
     
    Integer ID;  //PK
    String Name;
    String CountryCode;
    String District;
    Integer Population;

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getCountryCode() {
        return CountryCode;
    }
    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    public String getDistrict() {
        return District;
    }
    public void setDistrict(String district) {
        District = district;
    }
    public Integer getPopulation() {
        return Population;
    }
    public void setPopulation(Integer population) {
        Population = population;
    }

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    @Override
    public String toString() {
        return "City [CountryCode=" + CountryCode + ", District=" + District + ", ID=" + ID + ", Name=" + Name
                + ", Population=" + Population + "]";
    }
    
    
}
