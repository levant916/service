package hello.business.parser;
import org.jsoup.select.Elements;

import java.util.List;

public interface ElementsParser {
    List<?> parse(Elements element);
}