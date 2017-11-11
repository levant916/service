package hello.repository.price.day;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DayPriceRepository extends CrudRepository<DayPrice, String> {

	DayPrice findByDayPriceId(String lastName);

}
