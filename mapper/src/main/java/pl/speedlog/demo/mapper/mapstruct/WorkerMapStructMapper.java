package pl.speedlog.demo.mapper.mapstruct;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.speedlog.demo.dto.WorkerInfo;
import pl.speedlog.demo.entity.Address;
import pl.speedlog.demo.entity.Worker;
import pl.speedlog.demo.enums.Company;
import pl.speedlog.demo.mapper.mapstruct.decorator.WorkerMapperDecorator;

import java.util.List;

/**
 * @author Mariusz Wyszomierski <mariusz@wyszomierski.pl>
 */
@Mapper
@DecoratedWith(WorkerMapperDecorator.class)
public abstract class WorkerMapStructMapper {

    public static final WorkerMapStructMapper INSTANCE = Mappers.getMapper(WorkerMapStructMapper.class);

    @Mapping(target = "birthDate", dateFormat = "dd.MM.yyyy")
    @Mapping(source = "company", target = "companyName")
    @Mapping(source = "emailList", target = "firstEmail")
    public abstract WorkerInfo workerToWorkerInfo(Worker worker);

    public String addressToString(Address address) {
        return address.getStreet() + ", " + address.getPostalCode() + " " + address.getCity();
    }

    protected String companyToCompanyName(Company company) {
        return company != null ? company.getCompanyName() : null;
    }

    protected String emailFirstEmail(List<String> emailList) {
        return emailList != null && !emailList.isEmpty() ? emailList.get(0) : null;
    }
}
