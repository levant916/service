package hello.repository.price;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DayPriceRepository extends CrudRepository<DayPrice, DayPricePK> {

//	List<DayPrice> findByCode(String code);
}
