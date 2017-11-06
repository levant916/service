package hello.repository.model;

import java.sql.Date;

import lombok.Data;

/**
 *
 *
 * @author jiho.yang
 * @since 2017-11-06
 */
@Data
public class PricePerDate {
    private Date date;
    private Integer endPrice;
    private Integer increment;
    private Integer startPrice;
    private Integer maxPrice;
    private Integer minPrice;
    private Integer traceVolumn;
}