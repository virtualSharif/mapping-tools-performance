package pl.speedlog.demo.entity;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
@Data
public class Person {

    private BigInteger id;
    private String name;
    private String surname;
    private Date birthDate;
    private Address address;

}
