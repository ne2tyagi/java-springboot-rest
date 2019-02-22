package neetupractice.sbcrud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class PersonService {
	@Autowired
	private PersonMongoRepository personMongoRepo;
	
	@RequestMapping(value="setup")
	public String setupData() {
		Person p1 = new Person("John Resig", "US");
		Person p2 = new Person("James Josling", "US");
		this.personMongoRepo.save(p1);
		this.personMongoRepo.save(p2);
		return "success";
	}
	
	@RequestMapping(value="")
	public String sayHello() {
		return "Its working";
	}
	
	@RequestMapping(value="person", method= RequestMethod.GET)
	public Iterable<Person> getPerson() {
		Iterable<Person> persons = this.personMongoRepo.findAll();
//		String response = "";
//		for(Person p : persons) {
//			response += "\n"+p.toString();
//		}
		return persons;
	}
	@RequestMapping(value="person/{id}", method= RequestMethod.GET)
	public Person getPerson(@PathVariable long id) {
		Iterable<Person> persons = this.personMongoRepo.findAll();
		for(Person p : persons) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	@RequestMapping(value="person", method= RequestMethod.POST)
	public Person addPerson(@RequestParam(value="name") String name, 
			@RequestParam(value="city", defaultValue="unknown") String city) {
		Person p = new Person(name, city);
		return this.personMongoRepo.save(p);
	}
	@RequestMapping(value="person", method= RequestMethod.PUT)
	public Person addPerson(@RequestBody Person p) {
		return this.personMongoRepo.save(p);
	}
	@RequestMapping(value="person/{id}", method= RequestMethod.DELETE)
	public String addPerson(@PathVariable long id) {
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
