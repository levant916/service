package hello.repository.price.day;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(indexes = { @Index(name = "idx_dayprice_01", columnList = "code,date") })
@AllArgsConstructor(staticName = "of")
public class DayPrice implements Serializable {

	@Id
	private String code;
	@NonNull
	private Date date;

	private int endPrice;
	private int increment;
	private int startPrice;
	private int maxPrice;
	private int minPrice;
	private int traceVolumn;

	public DayPrice() {
	}

//	public DayPrice(String code, Date date) {
//		this.code = code;
//		this.date = date;
//		endPrice = 1;
//		increment = 1;
//		startPrice = 1;
//		maxPrice = 1;
//		minPrice = 1;
//		traceVolumn = 1;
//	}

}
