package neetupractice.sbcrud;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonMongoRepository extends MongoRepository<Person, Integer> {
	Person findByName(String name);
}
