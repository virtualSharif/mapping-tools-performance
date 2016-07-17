package pl.speedlog.demo.mapper;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import pl.speedlog.demo.dto.WorkerInfo;
import pl.speedlog.demo.entity.Address;
import pl.speedlog.demo.entity.Worker;
import pl.speedlog.demo.enums.Company;
import pl.speedlog.demo.mapper.dozer.WorkerDozerMapper;
import pl.speedlog.demo.mapper.mapstruct.WorkerMapStructMapper;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mariusz Wyszomierski <mariusz@wyszomierski.pl>
 */
@Slf4j
public class Main {

    //private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(Main.class.getName());
    private static final int NUMBER_OF_MAPPINGS = 1000000;
    private static final NumberFormat formatter = new DecimalFormat("#0.00000");

    public static void main( String[] args ) {
        List<Worker> entitiesList = generateEntitiesList();
        mapWithMapStruct(entitiesList);
        mapWithDozer(entitiesList);
    }

    private static List<Worker> generateEntitiesList() {
        log.info("Preparing sample data...");
        List<Worker> entitiesList = new ArrayList<>(NUMBER_OF_MAPPINGS);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= NUMBER_OF_MAPPINGS; i++) {
            entitiesList.add(prepareWorker());
        }
        long endTime = System.currentTimeMillis();
        log.info("Done preparing sample data in " + formatter.format((endTime - startTime) / 1000d) + " seconds");
        return entitiesList;
    }

    private static List<WorkerInfo> mapWithDozer(List<Worker> entitiesList) {
        log.info("Start mapping with Dozer...");
        WorkerDozerMapper workerDozerMapper = new WorkerDozerMapper();
        List<WorkerInfo> dtoList = new ArrayList<>(NUMBER_OF_MAPPINGS);
        long startTime = System.currentTimeMillis();
        for (Worker worker : entitiesList) {
            dtoList.add(workerDozerMapper.workerToWorkerInfo(worker));
        }
        long endTime = System.currentTimeMillis();
        log.info("Mapping with Dozer done in " + formatter.format((endTime - startTime) / 1000d) + " seconds");
        return dtoList;
    }

    private static List<WorkerInfo> mapWithMapStruct(List<Worker> entitiesList) {
        log.info("Start mapping with MapStruct...");
        List<WorkerInfo> dtoList = new ArrayList<>(NUMBER_OF_MAPPINGS);
        long startTime = System.currentTimeMillis();
        for (Worker worker : entitiesList) {
            dtoList.add(WorkerMapStructMapper.INSTANCE.workerToWorkerInfo(worker));
        }
        long endTime = System.currentTimeMillis();
        log.info("Mapping with MapStruct done in " + formatter.format((endTime - startTime) / 1000d) + " seconds");
        return dtoList;
    }

    public static Worker prepareWorker() {
        Worker worker = new Worker();
        worker.setCompany(Company.GOOGLE);
        worker.setEmailList(Arrays.asList("admin@fb.com", "mariusz@fb.com"));
        worker.setSalary(1234.99);
        Address address = new Address();
        address.setCity("Warsaw");
        address.setPostalCode("05-654");
        address.setStreet("Some Street 1234");
        worker.setAddress(address);
        worker.setBirthDate(new DateTime("2000-01-01").toDate());
        worker.setId(new BigInteger("12345"));
        worker.setName("John");
        worker.setSurname("Snow");
        return worker;
    }
}