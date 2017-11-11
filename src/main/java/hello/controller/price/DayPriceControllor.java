package hello.controller.price;

import hello.repository.price.DayPrice;
import hello.repository.price.DayPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/price/day")
public class DayPriceControllor {

	@Autowired
	private DayPriceRepository dayPriceRepository;

	@RequestMapping("/find")
	public List<DayPrice> findByCode(@RequestParam(value = "code", required = true) String code) {
		return dayPriceRepository.findByCode(code);
	}

	@RequestMapping("/save")
	public String save(
		@RequestParam(value = "code", required = true) String code,
		@RequestParam(value = "date", required = true) String date,
		@RequestParam(value = "endPrice", defaultValue = "0") int endPrice,
		@RequestParam(value = "increment", defaultValue = "0") int increment,
		@RequestParam(value = "startPrice", defaultValue = "0") int startPrice,
		@RequestParam(value = "maxPrice", defaultValue = "0") int maxPrice,
		@RequestParam(value = "minPrice", defaultValue = "0") int minPrice,
		@RequestParam(value = "traceVolumn", defaultValue = "0") int traceVolumn) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		dayPriceRepository.save(new DayPrice(code, dateFormat.parse(date),
			endPrice, increment, startPrice, maxPrice, minPrice, traceVolumn));
		return "success";
	}
}
