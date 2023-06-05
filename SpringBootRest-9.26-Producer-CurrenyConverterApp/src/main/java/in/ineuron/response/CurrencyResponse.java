package in.ineuron.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CurrencyResponse {
	private Integer currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Integer currencyValue;

}
