package in.ineuron.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Dependent Object
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	private String cname;
	private String ctype;
	private String cddress;
	private Integer size;

}
