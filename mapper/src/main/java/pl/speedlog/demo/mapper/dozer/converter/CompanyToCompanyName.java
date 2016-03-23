package pl.speedlog.demo.mapper.dozer.converter;

import org.dozer.DozerConverter;
import pl.speedlog.demo.enums.Company;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
public class CompanyToCompanyName extends DozerConverter<Company, String> {

    public CompanyToCompanyName() {
        super(Company.class, String.class);
    }

    @Override
    public String convertTo(Company company, String s) {
        return company != null ? company.getCompanyName() : null;
    }

    @Override
    public Company convertFrom(String s, Company company) {
        throw new UnsupportedOperationException("Not supported conversion");
    }
}
