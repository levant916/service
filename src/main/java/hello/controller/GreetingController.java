package hello.controller;

import hello.business.JsoupBO;
import hello.business.model.Greeting;
import hello.repository.price.day.DayPrice;
import hello.repository.price.day.DayPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private DayPriceRepository dayPriceRepository;
	@Autowired
	private JsoupBO jsoupBO;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(),
			String.format(template, name));
	}

	@RequestMapping("/day/find")
	public DayPrice findDayPrice() {
		return dayPriceRepository.findByDayPriceId("0000");
	}

	@RequestMapping("/day/save")
	public DayPrice saveDayPrice() {
		dayPriceRepository.save(DayPrice.of(DayPrice.PK.of("0000", new Date()), 1, 1, 1, 1, 1, 1));
		return dayPriceRepository.findByDayPriceId("0000");
	}

	@RequestMapping("/test")
	public void test() {
		jsoupBO.getDataPerTime("asdf");
	}
}
