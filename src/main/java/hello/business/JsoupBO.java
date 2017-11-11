package hello.business;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author jiho.yang
 * @since 2017-11-06
 */
@Repository
public class JsoupBO {
	private static final String baseUrl2 = "http://finance.naver.com/item/sise_time.nhn";

	public void getDataPerTime(String baseUrl) {

		try {
			URI uri = new URIBuilder(baseUrl2)
					.addParameter("code", "000660")
					.addParameter("thistime", "20171103150000")
					.addParameter("page", "8").build();
			Document doc = Jsoup.connect(uri.toString())
								.timeout(3000)
								.get();
			Elements resultList = doc.select("tr[onmouseover=mouseOver(this)]");
			for(Element result : resultList) {
				Elements priceRow = result.children();
				for(Element columnData : priceRow) {
					String data = columnData.children().text();
					System.out.print(data + " ");
				}
				System.out.println();
			}
//			Elements result = doc.select("span[class=tah p10 gray03]");
//			for(Element r : result) {		// 체결 시각
//				System.out.println(r.ownText());
//			}
//			result = doc.select("span[class=tah p11]");
//			for(Element r : result) {		// 체결가, 매도, 매수, 거래량, 변동량
//				System.out.println(r.ownText());
//			}
//			result = doc.select("span[class=tah p11 red02]");
//			for(Element r : result) {		// 전일비
//				System.out.println(r.ownText());
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
