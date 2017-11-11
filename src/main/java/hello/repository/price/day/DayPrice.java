package hello.repository.price.day;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Table(indexes = { @Index(name = "IDX_DAYPRICE_01", columnList = "day_price_id,date") })
@Entity
@AllArgsConstructor(staticName = "of")
//@IdClass(DayPrice.PK.class)
public class DayPrice implements Serializable {

	@EmbeddedId
	private PK pk;

	private Integer endPrice;
	private Integer increment;
	private Integer startPrice;
	private Integer maxPrice;
	private Integer minPrice;
	private Integer traceVolumn;

//	@Embeddable
//	public static class PK implements Serializable {
//		private static final long serialVersionUID = 1L;
//
//		private String code;
//		private Date date;
//
//		public static PK of(String code, Date date) {
//			PK pk = new PK();
//			pk.code = code;
//			pk.date = date;
//			return pk;
//		}
//	}
}
