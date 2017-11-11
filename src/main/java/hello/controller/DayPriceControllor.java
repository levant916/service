package hello.controller;

import hello.repository.price.day.DayPrice;
import hello.repository.price.day.DayPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/day")
public class DayPriceControllor {

	@Autowired
	private DayPriceRepository dayPriceRepository;

	@RequestMapping("/find")
	public DayPrice findDayPrice(@RequestParam(value = "code", required = true) String code) {
		return dayPriceRepository.findOne(code);
	}

	@RequestMapping("/save")
	public String saveDayPrice(
		@RequestParam(value = "code", required = true) String code,
		@RequestParam(value = "date", required = true) String date,
		@RequestParam(value = "endPrice", defaultValue = "0") int endPrice,
		@RequestParam(value = "increment", defaultValue = "0") int increment,
		@RequestParam(value = "startPrice", defaultValue = "0") int startPrice,
		@RequestParam(value = "maxPrice", defaultValue = "0") int maxPrice,
		@RequestParam(value = "minPrice", defaultValue = "0") int minPrice,
		@RequestParam(value = "traceVolumn", defaultValue = "0") int traceVolumn) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat();

		dayPriceRepository.save(DayPrice.of(code, dateFormat.parse(date),
			endPrice, increment, startPrice, maxPrice, minPrice, traceVolumn));
		return "success";
	}
}
