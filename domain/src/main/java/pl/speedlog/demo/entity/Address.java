package pl.speedlog.demo.entity;

import lombok.Data;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
@Data
public class Address {

    private String street;
    private String postalCode;
    private String city;

}
