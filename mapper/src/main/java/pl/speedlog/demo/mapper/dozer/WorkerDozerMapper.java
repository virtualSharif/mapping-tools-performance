package pl.speedlog.demo.mapper.dozer;

import org.dozer.DozerBeanMapper;
import pl.speedlog.demo.dto.WorkerInfo;
import pl.speedlog.demo.dto.WorkerInfoImmutable;
import pl.speedlog.demo.dto.WorkerInterface;
import pl.speedlog.demo.entity.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
public class WorkerDozerMapper {

    private final DozerBeanMapper mapper = new DozerBeanMapper();

    public WorkerDozerMapper() {
        List<String> myMappingFiles = new ArrayList<>();
        myMappingFiles.add("dozer/globalConfiguration.xml");
        myMappingFiles.add("dozer/workerToWorkerInfo.xml");
        myMappingFiles.add("dozer/workerToWorkerInfoImmutable.xml");
        mapper.setMappingFiles(myMappingFiles);
    }

    public WorkerInfo workerToWorkerInfo(Worker worker) {
        return mapper.map(worker, WorkerInfo.class);
    }

    public WorkerInfoImmutable workerToWorkerInfoImmutable(Worker worker) {
        return mapper.map(worker, WorkerInfoImmutable.class);
    }
}
