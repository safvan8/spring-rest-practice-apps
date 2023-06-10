package in.ineuron.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OTM_PHONE_NUMBER")
@RequiredArgsConstructor
@ToString
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;

	@NonNull
	private Long phoneNo;

	@NonNull
	private String provider;

	//many phone numers  have one Person (user)
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	private Person person;

	static {
		System.out.println("PhoneNumber.class file is loading.........");
	}

	PhoneNumber() {
		System.out.println("PhoneNumber zero arg constructor is executed.....\n\n");
	}
}