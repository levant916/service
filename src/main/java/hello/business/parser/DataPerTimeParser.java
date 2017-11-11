package hello.business.parser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DataPerTimeParser<Object> implements ElementsParser {
    @Override
    public List<Object> parse(Elements elements) {
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
        return null;
    }
}