package neetupractice.sbcrud;

import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="person")
public class Person {
	@Id
	private long id;
	private String name;
	private String city;
	
	public Person(String name, String city) {
		this.id = (new Date()).getTime();
		this.name = name;
		this.city = city;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "PersonModel [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
