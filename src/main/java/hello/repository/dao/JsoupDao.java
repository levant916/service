package hello.repository.dao;

import java.io.IOException;

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
public class JsoupDao {

	public void getDataPerTime(String baseUrl) {
		try {
			Document doc = Jsoup.connect("http://finance.naver.com/item/sise_time.nhn?code=000660&thistime=20171103150000&page=8")
								.timeout(3000)
								.get();
			Elements result = doc.select("tr[onmouseover=mouseOver(this)]");
			for(Element r : result) {
				Elements r2 = r.children();
				for(Element r3 : r2) {
					System.out.println(r3.children().text());
				}
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
		}
	}

}
