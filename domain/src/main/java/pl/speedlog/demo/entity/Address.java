package pl.speedlog.demo.entity;

import lombok.Data;

/**
 * @author Mariusz Wyszomierski <mariusz@wyszomierski.pl>
 */
@Data
public class Address {

    private String street;
    private String postalCode;
    private String city;

}
