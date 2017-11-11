package hello.business.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoramlizeUtil {
	private static final String DATE_FORMAT = "yyyy.MM.dd";
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

	public static int toPrice(String str) {
		return Integer.valueOf(str.replaceAll(",", ""));
	}

	public static Date toDate(String str) throws ParseException {
		return simpleDateFormat.parse(str);
	}

	public static int toIncrementPrice(String deltaStr, String deltaValue) {
		int delta = Integer.valueOf(deltaValue);
		if (deltaStr.equals("상승")) {
			return delta;
		} else {
			return -delta;
		}
	}

}
