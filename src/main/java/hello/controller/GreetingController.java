package hello.controller;

import hello.business.JsoupBO;
import hello.business.model.Greeting;
import hello.repository.price.DayPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private JsoupBO jsoupBO;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(),
			String.format(template, name));
	}

	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<DayPrice> test() {
		return jsoupBO.getDataPerDate("006380", 1);
	}
}
