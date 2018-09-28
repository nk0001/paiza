package test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Hiduke {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());

		cal.set(2020,10,10,10,10,10);
		System.out.println(cal.getTime());
		cal.add(Calendar.DATE, 5);
		System.out.println(cal.getTime());

		Date date = cal.getTime();
		System.out.println(date);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
//		DateFormat f = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒S");
//		System.out.println(f.format(ldt));
	}

}
