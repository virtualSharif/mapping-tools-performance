package pl.speedlog.demo.mapper.dozer;

import org.dozer.DozerBeanMapper;
import pl.speedlog.demo.dto.WorkerInfo;
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
        myMappingFiles.add("dozer/workerToWorkerInfo.xml");
        mapper.setMappingFiles(myMappingFiles);
    }

    public WorkerInfo workerToWorkerInfo(Worker worker) {
        return mapper.map(worker, WorkerInfo.class);
    }
}
