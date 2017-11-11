package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.business.JsoupBO;

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

}
