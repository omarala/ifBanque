package utilitaires;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	public Date() {
		java.util.Date dateToday = new java.util.Date();
		this.setDay(dateToday.getDay());
		this.setMonth(dateToday.getMonth());
		this.setYear(dateToday.getYear());
	}
	
	public Date(int day, int month, int year) {
		super();
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		assert(year>1900);
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		assert(month > 0 && month < 13);
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		assert(day > 0 && day < 32);
		this.year = year;
	}

	@Override
	public String toString() {
		return "" + day + "-" + month + "-" + year + "";
	}
	
	
	
	
	

}
