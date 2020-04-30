package Semi3;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hcalendar {
	Calendar cal = Calendar.getInstance();
	
	//mainâ �󺧿� ���糯¥ ����(��,��,�� ���)
	public String time() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy�� MM�� dd��");
		 String format_cal=format1.format(cal.getTime());
		
		return format_cal;
	}
	
	//DTO �޼ҵ忡 ������ ����(yyyy-MM-dd���� ����)
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd-HH-mm");
	String format_cal=""; 
	
	//���� �ð�
	public String thistime() {
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	//�⵵ +1
	public String year_up() {
		cal.add(Calendar.YEAR, +1);
		format_cal=format1.format(cal.getTime());
		return format_cal;
	}
	//�⵵ -1
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
