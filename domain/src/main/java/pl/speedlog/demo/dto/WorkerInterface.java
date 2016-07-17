package pl.speedlog.demo.dto;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
public interface WorkerInterface {
    String getFirstNameAndSurname();

    String getBirthDate();

    String getAddress();

    String getCompanyName();

    String getFirstEmail();

    Double getSalary();
}
