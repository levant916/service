package hello.repository.price;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(indexes = { @Index(name = "idx_dayprice_01", columnList = "code,date") })
//@AllArgsConstructor(staticName = "of")
@RequiredArgsConstructor
public class DayPrice implements Serializable {
	@Id
	@GeneratedValue
	private long dayPriceId;
	@NonNull private String code;
	@NonNull private Date date;
	@NonNull private int incrementPrice;
	@NonNull private int startPrice;
	@NonNull private int endPrice;
	@NonNull private int lowPrice;
	@NonNull private int highPrice;
	@NonNull private int tradeVolume;

	public String toString() {
		return String.join(" ", code, date.toString(), String.valueOf(incrementPrice));
	}
}
