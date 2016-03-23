package pl.speedlog.demo.mapper.mapstruct;

import org.junit.Test;
import pl.speedlog.demo.dto.WorkerInfo;
import pl.speedlog.demo.entity.Worker;
import pl.speedlog.demo.mapper.AbstractWorkerMapperTest;
import pl.speedlog.demo.mapper.Main;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
public class WorkerMapStructMapperTest extends AbstractWorkerMapperTest {

    @Test
    public void shouldMapWorkerToWorkerInfo() {
        //given
        Worker worker = Main.prepareWorker();

        //when
        WorkerInfo workerInfo = WorkerMapStructMapper.INSTANCE.workerToWorkerInfo(worker);

        //then
        checkWorkerInfo(workerInfo);
    }
}