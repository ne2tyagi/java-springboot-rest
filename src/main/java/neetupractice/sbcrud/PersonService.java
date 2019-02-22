package neetupractice.sbcrud;

public interface PersonService {

	String setupData();

	String sayHello();

	Iterable<Person> getPerson();

	Person getPerson(long id);

	Person addPerson(String name, String city);

	Person updatePerson(Person p);

	String deletePerson(long id);

}