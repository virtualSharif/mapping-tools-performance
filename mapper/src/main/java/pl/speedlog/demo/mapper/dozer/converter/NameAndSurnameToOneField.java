package pl.speedlog.demo.mapper.dozer.converter;

import org.dozer.DozerConverter;
import pl.speedlog.demo.entity.Person;

/**
 * @author Mariusz Wyszomierski <mariusz.wyszomierski@coi.gov.pl>
 */
public class NameAndSurnameToOneField extends DozerConverter<Person, String> {

    public NameAndSurnameToOneField() {
        super(Person.class, String.class);
    }

    @Override
    public String convertTo(Person person, String s) {
        return person != null ? person.getName() + " " + person.getSurname() : null;
    }

    @Override
    public Person convertFrom(String s, Person person) {
        throw new UnsupportedOperationException("Not supported conversion");
    }
}
