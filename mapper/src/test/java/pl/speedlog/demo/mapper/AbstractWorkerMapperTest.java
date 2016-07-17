package pl.speedlog.demo.mapper;

import pl.speedlog.demo.dto.WorkerInterface;
import pl.speedlog.demo.enums.Company;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mariusz Wyszomierski <mariusz@wyszomierski.pl>
 */
public class AbstractWorkerMapperTest {

    protected void checkWorkerInfo(WorkerInterface workerInfo) {
        assertThat(workerInfo.getAddress()).isEqualTo("Some Street 1234, 05-654 Warsaw");
        assertThat(workerInfo.getBirthDate()).isEqualTo("01.01.2000");
        assertThat(workerInfo.getCompanyName()).isEqualTo(Company.GOOGLE.getCompanyName());
        assertThat(workerInfo.getFirstEmail()).isEqualTo("admin@fb.com");
        assertThat(workerInfo.getFirstNameAndSurname()).isEqualTo("John Snow");
        assertThat(workerInfo.getSalary()).isEqualTo(1234.99);
    }
}
