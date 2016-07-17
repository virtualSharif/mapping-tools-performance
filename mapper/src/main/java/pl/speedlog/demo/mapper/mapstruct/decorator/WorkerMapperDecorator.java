package pl.speedlog.demo.mapper.mapstruct.decorator;

import pl.speedlog.demo.dto.WorkerInfo;
import pl.speedlog.demo.entity.Worker;
import pl.speedlog.demo.mapper.mapstruct.WorkerMapStructMapper;

/**
 * @author Mariusz Wyszomierski <mariusz@wyszomierski.pl>
 */
public abstract class WorkerMapperDecorator extends WorkerMapStructMapper {

    private final WorkerMapStructMapper workerMapper;

    public WorkerMapperDecorator(WorkerMapStructMapper workerMapper) {
        this.workerMapper = workerMapper;
    }

    @Override
    public WorkerInfo workerToWorkerInfo(Worker worker) {
        WorkerInfo workerInfo = workerMapper.workerToWorkerInfo(worker);
        workerInfo.setFirstNameAndSurname(worker.getName() + " " + worker.getSurname());
        return workerInfo;
    }
}
