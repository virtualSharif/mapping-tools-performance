package pl.speedlog.demo.enums;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
public enum Company {

    GOOGLE("Google Inc'"),
    TMOBILE("T-mobile"),
    FACEBOOK("Facebook");

    private String companyName;

    Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
