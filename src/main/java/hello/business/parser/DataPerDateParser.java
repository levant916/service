package hello.business.parser;

import hello.repository.price.DayPriceRepository;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DataPerDateParser implements ElementsParser {
    @Autowired
    private DayPriceRepository dayPriceRepository;

    @Override
    public void parse(Elements elements) {
        for(Element result : elements) {
            Elements priceRow = result.children();
            for(Element columnData : priceRow) {
                String data = columnData.children().text();
                String deltaAlt = columnData.children().attr("alt");
                System.out.print(data + " ");
                if(!StringUtils.isEmpty(deltaAlt)) {
                    System.out.print(deltaAlt + " ");
                }
            }
            System.out.println();
        }
    }
}
