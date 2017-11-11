package hello.business;

import hello.business.parser.DataPerDateParser;
import hello.business.parser.DataPerTimeParser;
import hello.repository.price.DayPrice;
import hello.repository.price.DayPriceRepository;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author jiho.yang
 * @since 2017-11-06
 */
@Service
public class JsoupBO {
	private static final String URL_STOCK_PER_TIME = "http://finance.naver.com/item/sise_time.nhn";
	private static final String URL_STOCK_PER_DATE = "http://finance.naver.com/item/sise_day.nhn";
	@Autowired
	private DataPerDateParser dataPerDateParser;
	@Autowired
	private DataPerTimeParser dataPerTimeParser;

	@Autowired
	private DayPriceRepository dayPriceRepository;

	public void getDataPerTime(String stockCode, Integer page) {
		try {
			URI uri = new URIBuilder(URL_STOCK_PER_TIME)
				.addParameter("code", stockCode)
				.addParameter("thistime", "20171110161045")
				.addParameter("page", page.toString()).build();
			System.out.println("URL : " + uri.toString());
			Document doc = Jsoup.connect(uri.toString())
				.timeout(3000)
				.get();
			Elements resultList = doc.select("tr[onmouseover=mouseOver(this)]");
			dataPerTimeParser.parse(resultList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public List<DayPrice> getDataPerDate(String stockCode, Integer page) {
		try {
			URI uri = new URIBuilder(URL_STOCK_PER_DATE)
				.addParameter("code", stockCode)
				.addParameter("page", page.toString()).build();
			Document doc = Jsoup.connect(uri.toString())
				.timeout(3000)
				.get();
			Elements resultList = doc.select("tr[onmouseover=mouseOver(this)]");
			List<DayPrice> dayPriceList = dataPerDateParser.parse(resultList);
			dayPriceRepository.save(dayPriceList);

			dayPriceRepository.save(dayPriceList.get(0));
			dayPriceRepository.save(dayPriceList.get(1));
			return dayPriceList;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}