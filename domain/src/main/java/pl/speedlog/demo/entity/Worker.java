package pl.speedlog.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.speedlog.demo.enums.Company;

import java.util.List;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Worker extends Person {

    private Company company;
    private List<String> emailList;
    private Double salary;

}
