package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JacksonInject;
import hello.repository.dao.JsoupDao;

/**
 *
 *
 * @author jiho.yang
 * @since 2017-11-06
 */
@Service
public class CrawlingService {
	@Autowired
	private JsoupDao jsoupDao;


}
