package pl.speedlog.demo.dto;

/**
 * @author Mariusz Wyszomierski <mariusz@wyszomierski.pl>
 */
public class WorkerInfoImmutable implements WorkerInterface {

    private String firstNameAndSurname;
    /* Format: YYYYMMDD */
    private String birthDate;
    private String address;
    private String companyName;
    private String firstEmail;
    private Double salary;

    /**
     * This constructor is required by Dozer for mapping.
     */
    public WorkerInfoImmutable() {
    }

    public WorkerInfoImmutable(String firstNameAndSurname, String birthDate, String address, String companyName, String firstEmail, Double salary) {
        this.firstNameAndSurname = firstNameAndSurname;
        this.birthDate = birthDate;
        this.address = address;
        this.companyName = companyName;
        this.firstEmail = firstEmail;
        this.salary = salary;
    }

    @Override
    public String getFirstNameAndSurname() {
        return firstNameAndSurname;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String getFirstEmail() {
        return firstEmail;
    }

    @Override
    public Double getSalary() {
        return salary;
    }
}
