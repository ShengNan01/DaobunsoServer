package util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
		String startDate = "2019-2-10";
		 String[] dateArray = startDate.split("-");
		 int year = Integer.parseInt(dateArray[0]);
         int month = Integer.parseInt(dateArray[1]);
         int date = Integer.parseInt(dateArray[2]);

         
         Calendar cl = Calendar.getInstance();
         cl.set(year,month-1,date);
         cl.add(Calendar.MONTH,1);
         java.util.Date date1 =cl.getTime();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String endDate = sdf.format(date1);

	}

}
