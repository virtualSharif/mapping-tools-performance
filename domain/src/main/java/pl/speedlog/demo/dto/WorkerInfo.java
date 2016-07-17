package pl.speedlog.demo.dto;

import lombok.Data;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
@Data
public class WorkerInfo implements WorkerInterface {

    private String firstNameAndSurname;
    /* Format: YYYYMMDD */
    private String birthDate;
    private String address;
    private String companyName;
    private String firstEmail;
    private Double salary;

}
