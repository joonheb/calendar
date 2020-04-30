package Semi3;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hcalendar {
	Calendar cal = Calendar.getInstance();
	
	//main창 라벨에 현재날짜 지정(년,월,일 방식)
	public String time() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy년 MM월 dd일");
		 String format_cal=format1.format(cal.getTime());
		
		return format_cal;
	}
	
	//DTO 메소드에 데이터 저장(yyyy-MM-dd으로 저장)
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd-HH-mm");
	String format_cal=""; 
	
	//현재 시각
	public String thistime() {
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	//년도 +1
	public String year_up() {
		cal.add(Calendar.YEAR, +1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	//년도 -1
	public String year_down() {
		cal.add(Calendar.YEAR, -1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String month_up() {
		cal.add(Calendar.MARCH, +1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String month_down() {
		cal.add(Calendar.MARCH, -1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String day_up() {
		cal.add(Calendar.DATE, +1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String day_down() {
		cal.add(Calendar.DATE, -1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String hour_up() {
		cal.add(Calendar.HOUR_OF_DAY, +1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String hour_down() {
		cal.add(Calendar.HOUR_OF_DAY, -1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String minue_up() {
		cal.add(Calendar.MINUTE, +1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	
	public String minue_down() {
		cal.add(Calendar.MINUTE, -1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}

}
