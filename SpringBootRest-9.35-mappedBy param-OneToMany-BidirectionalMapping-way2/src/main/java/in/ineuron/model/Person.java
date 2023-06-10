package in.ineuron.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "OTM_PERSON")
@ToString
@RequiredArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;

	@NonNull
	private String pname;

	@NonNull
	private String paddress;
	
	// One Person have Many phone numbers
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL,mappedBy = "person")
	private Set<PhoneNumber> contactDetails;

	static {
		System.out.println("Person.class file is loading.............");
	}

	public Person() {
		System.out.println("Person class zero arg constructor is executed..........\n\n");
	}
}