package hello.repository.price;

import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(indexes = { @Index(name = "idx_dayprice_01", columnList = "code,date") })
public class DayPrice implements Serializable {
	@EmbeddedId
	private DayPricePK pk;

	private int incrementPrice;
	private int startPrice;
	private int endPrice;
	private int lowPrice;
	private int highPrice;
	private int tradeVolume;

	public DayPrice() {
	}

	public DayPrice(DayPricePK dayPricePK, int incrementPrice, int startPrice, int endPrice,
		int lowPrice, int highPrice, int tradeVolume) {
		this.pk = dayPricePK;
		this.incrementPrice = incrementPrice;
		this.startPrice = startPrice;
		this.endPrice = endPrice;
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.tradeVolume = tradeVolume;
	}

}
