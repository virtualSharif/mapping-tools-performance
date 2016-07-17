package pl.speedlog.demo.mapper.dozer;

import org.junit.Test;
import pl.speedlog.demo.dto.WorkerInfo;
import pl.speedlog.demo.dto.WorkerInfoImmutable;
import pl.speedlog.demo.entity.Worker;
import pl.speedlog.demo.mapper.AbstractWorkerMapperTest;
import pl.speedlog.demo.mapper.Main;

/**
 * @author Mariusz Wyszomierski <mariusz@wyszomierski.pl>
 */
public class WorkerDozerMapperTest extends AbstractWorkerMapperTest {

    private final WorkerDozerMapper workerDozerMapper = new WorkerDozerMapper();

    @Test
    public void shouldMapWorkerToWorkerInfo() {
        //given
        Worker worker = Main.prepareWorker();

        //when
        WorkerInfo workerInfo = workerDozerMapper.workerToWorkerInfo(worker);

        //then
        checkWorkerInfo(workerInfo);
    }

    @Test
    public void shouldMapWorkerToWorkerInfoImmutable() {
        //given
        Worker worker = Main.prepareWorker();

        //when
        WorkerInfoImmutable workerInfo = workerDozerMapper.workerToWorkerInfoImmutable(worker);

        //then
        checkWorkerInfo(workerInfo);
    }
}