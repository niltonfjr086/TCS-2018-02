package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DateTest {

	@Test
	private void dateFormatTest() {

		String dtFromDB = "01/06/2018 21:35:43";

		// StringBuilder date = new StringBuilder(dtFromDB);
		// String[] dateArray = dtFromDB.split(" ");
		// dateArray[0] = new StringBuilder((String);
		// dateArray[0]).reverse().toString().split("/");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013, 1, 28, 13, 24, 56);

	}

}
