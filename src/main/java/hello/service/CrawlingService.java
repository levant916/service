package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.business.JsoupBO;

import java.util.Date;

/**
 *
 *
 * @author jiho.yang
 * @since 2017-11-06
 */
@Service
public class CrawlingService {
	@Autowired
	private JsoupBO jsoupBO;

	public void getDataPerDate(String code, Date targetDate) {

	}
}
