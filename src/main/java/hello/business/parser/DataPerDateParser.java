package hello.business.parser;

import hello.repository.price.DayPrice;
import hello.repository.price.DayPricePK;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataPerDateParser implements ElementsParser {

	@Override
	public List<DayPrice> parse(Elements elements) {
		List<DayPrice> dayPriceList = new ArrayList<>();
		for (Element result : elements) {
			Elements priceRow = result.children();
			try {
				Date date = NoramlizeUtil.toDate(priceRow.get(0).children().text());
				int incrementPrice = NoramlizeUtil.toIncrementPrice(
					priceRow.get(2).children().attr("alt"),
					priceRow.get(2).children().text());
				int startPrice = NoramlizeUtil.toPrice(priceRow.get(3).children().text());
				int endPrice = NoramlizeUtil.toPrice(priceRow.get(1).children().text());
				int highPrice = NoramlizeUtil.toPrice(priceRow.get(4).children().text());
				int lowPrice = NoramlizeUtil.toPrice(priceRow.get(5).children().text());
				int tradeVolume = NoramlizeUtil.toPrice(priceRow.get(6).children().text());
				dayPriceList.add(new DayPrice(new DayPricePK("code", date), incrementPrice,
					startPrice, endPrice, lowPrice, highPrice, tradeVolume));

			} catch (ParseException e) {
				System.out.println("parse error. priceRow:" + priceRow);
				e.printStackTrace();
			}
		}
		return dayPriceList;
	}
}