package neetupractice.sbcrud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonMongoRepository personMongoRepo;
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#setupData()
	 */
	@Override
	public String setupData() {
		Person p1 = new Person("John Resig", "US");
		Person p2 = new Person("James Josling", "US");
		this.personMongoRepo.save(p1);
		this.personMongoRepo.save(p2);
		return "success";
	}
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#sayHello()
	 */
	@Override
	@RequestMapping(value="")
	public String sayHello() {
		return "Its working";
	}
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#getPerson()
	 */
	@Override
	@RequestMapping(value="person", method= RequestMethod.GET)
	public Iterable<Person> getPerson() {
		Iterable<Person> persons = this.personMongoRepo.findAll();
		return persons;
	}
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#getPerson(long)
	 */
	@Override
	public Person getPerson(long id) {
		Iterable<Person> persons = this.personMongoRepo.findAll();
		for(Person p : persons) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#addPerson(java.lang.String, java.lang.String)
	 */
	@Override
	public Person addPerson(String name, String city) {
		Person p = new Person(name, city);
		return this.personMongoRepo.save(p);
	}
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#addPerson(neetupractice.sbcrud.Person)
	 */
	@Override
	public Person updatePerson(Person p) {
		return this.personMongoRepo.save(p);
	}
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#addPerson(long)
	 */
	@Override
	public String deletePerson(long id) {
		Iterable<Person> persons = this.personMongoRepo.findAll();
		for(Person p : persons) {
			if(p.getId() == id) {
				this.personMongoRepo.delete(p);
				return "Successfully deleted";
			}
		}
		return "error";
	}

}
