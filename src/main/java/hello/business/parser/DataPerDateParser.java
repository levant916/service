package hello.business.parser;

import hello.repository.price.DayPriceRepository;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataPerDateParser<DayPrice> implements ElementsParser {

    @Override
    public List<DayPrice> parse(Elements elements) {
        List<DayPrice> dayPriceList = new ArrayList<>();
        for(Element result : elements) {
            Elements priceRow = result.children();
            String dateString = priceRow.get(0).children().text();
            String finalPrice = priceRow.get(1).children().text();
            String deltaValue = priceRow.get(2).children().text();
            String delta = priceRow.get(2).children().attr("alt");
            String startPrice = priceRow.get(3).children().text();
            String hightPrice = priceRow.get(4).children().text();
            String lowPrice = priceRow.get(5).children().text();
            String tradeVolumn = priceRow.get(6).children().text();
        }
        return null;
    }
}