package in.ineuron;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ineuron.dao.IPersonRepository;
import in.ineuron.dao.IPhoneNumberRespository;
import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private IPhoneNumberRespository phoneNumberRespository;

	@Autowired
	private IPersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/**
		  Save Operation of Parent to child
		*/
		// create Parent object
		Person person = new Person("sachin", "MI");

		// create a Child Object
		PhoneNumber p1 = new PhoneNumber(87947294L, "Idea");
		PhoneNumber p2 = new PhoneNumber(3243247294L, "BSNL");

		// Link parent to child
		p1.setPerson(person);
		p2.setPerson(person);

		Set<PhoneNumber> phoneNumSet = Set.of(p1, p2);

		// link child to parent
		person.setContactDetails(phoneNumSet);

		// saving parent
		personRepository.save(person);

		
	
		
		/**
		 * Save Operation of Child to Parent
		 
		PhoneNumber phNum1 = new  PhoneNumber(678234L, "Vodafone");
		PhoneNumber phNum2 = new  PhoneNumber(4390232L, "Airtel");
		
		Person person = new Person("hyder","RCB");
		
		phNum1.setPerson(person);
		phNum2.setPerson(person);
		
		Set<PhoneNumber> contactNumbers = Set.of(phNum1,phNum2);
		
		person.setContactDetails(contactNumbers);
		phoneNumberRespository.save(phNum1);
		phoneNumberRespository.save(phNum2);
		*/
	}
}
