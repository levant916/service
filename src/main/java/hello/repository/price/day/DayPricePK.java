package hello.repository.price.day;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class DayPricePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private Date date;


}
