package hello.repository.price;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class DayPricePK implements Serializable {
	private String code;
	private Date date;

	public DayPricePK() {
	}

	public DayPricePK(String code, Date date) {
		this.code = code;
		this.date = date;
	}
}
