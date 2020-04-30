package Semi3;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DTO {
	Calendar cal = Calendar.getInstance();
	static String mainpage = "C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\puple.png"; // ���� ������ �ٲٴ°�,������ ������ x
	static String timepage = "C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\puple.png"; // �ð� ������ �ٲٴ°�,������ ������ x
	
	//main���������� check������ ������ ���޵� ������
	private int year;
	private int month;
	private String id;

	private String time1; // �ٲ� �ð� ����
	private String time2; // �ٲ� �ð� ����
	private String color = "115,139,197";// �ٲ� �÷� ����
	private String title; // ���� ����
	private String memo; // �޸� ����

	public DTO() {
		super();
	}

	@Override
	public String toString() {
		return title + "/" + time1 + "/" + time2 + "/" + color;
	}
	public String toStringAll() {
		return id+"/"+year +"/" + month +"/"+title + "/" + time1 + "/" + time2 + "/" + color + "/" + memo;
	}
	//get,set

	public String getMainpage() {
		return mainpage;
	}

	public void setMainpage(String mainpage) {
		this.mainpage = mainpage;
	}

	public String getTimepage() {
		return timepage;
	}

	public void setTimepage(String timepage) {
		this.timepage = timepage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
