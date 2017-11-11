package hello.repository.price;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(indexes = { @Index(name = "idx_hourprice_01", columnList = "code,date") })
@AllArgsConstructor(staticName = "of")
public class HourPrice {
	@Id
	private String code;
	@NonNull
	private Date date;

	private Date contractTime;
	private Integer price;
	private Integer increment;
	private Integer sellPrice;
	private Integer purchasePrice;
	private Integer tradeVolume;
	private Integer variance;

	public HourPrice() {

	}
}
