package hello.business.model;

import java.sql.Date;

import lombok.Data;

/**
 *
 *
 * @author jiho.yang
 * @since 2017-11-06
 */
@Data
public class PricePerTime {
	private Date contractTime;
	private Integer price;
	private Integer increment;
	private Integer sellPrice;
	private Integer purchasePrice;
	private Integer tradeVolume;
	private Integer variance;
}