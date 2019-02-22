package neetupractice.sbcrud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#setupData()
	 */
	@RequestMapping(value="setup")
	public String setupData() {
		return this.personService.setupData();
	}
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#sayHello()
	 */
	@RequestMapping(value="")
	public String sayHello() {
		return this.personService.sayHello();
	}
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#getPerson()
	 */
	@RequestMapping(value="person", method= RequestMethod.GET)
	public Iterable<Person> getPerson() {
		return this.personService.getPerson();
	}
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#getPerson(long)
	 */
	@RequestMapping(value="person/{id}", method= RequestMethod.GET)
	public Person getPerson(@PathVariable long id) {
		return this.personService.getPerson(id);
	}
	
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#addPerson(java.lang.String, java.lang.String)
	 */
	@RequestMapping(value="person", method= RequestMethod.POST)
	public Person addPerson(@RequestParam(value="name") String name, 
			@RequestParam(value="city", defaultValue="unknown") String city) {
		return this.personService.addPerson(name, city);
	}
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#addPerson(neetupractice.sbcrud.Person)
	 */

	@RequestMapping(value="person", method= RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person p) {
		return this.personService.updatePerson(p);
	}
	/* (non-Javadoc)
	 * @see neetupractice.sbcrud.PersonService#addPerson(long)
	 */
	@RequestMapping(value="person/{id}", method= RequestMethod.DELETE)
	public String deletePerson(@PathVariable long id) {
		return this.personService.deletePerson(id);
	}
}
