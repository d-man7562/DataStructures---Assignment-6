package accidentpack;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Report - constructor for Report object
 * @author Behrooz Mansouri (professor). Thanks!
 * @version 3/4/2024
 */
public class Report implements Comparable<Report>{
	//DECEMBER 21 = winter start MARCH 21 = winter end
	private String ID;
	private int severity;
	private LocalDate startTime; //year,month,day
	private LocalDate endTime; //year,month,day
	private String street;
	private String city;
	private String county;
	private String state;
	private double temperature;	//fahrenheit
	private double humidity;	//as %
	private double visibility;	//miles
	private String weather;
	private boolean atCrossing;	//true = yes, at a crossing; false = no, not at crossing
	private boolean isDay;	//true = Day, false = Night
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public LocalDate getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}
	public LocalDate getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getVisibility() {
		return visibility;
	}
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public boolean isAtCrossing() {
		return atCrossing;
	}
	public void setAtCrossing(boolean atCrossing) {
		this.atCrossing = atCrossing;
	}
	public boolean isDay() {
		return isDay;
	}
	public void setDay(boolean isDay) {
		this.isDay = isDay;
	}

	/**
	 * compareTo - compares LocalDate startTimes. Used in BST insertion.
	 * @param r2 - Report object
	 * @return -1 if @param start time is before object start time
	 * @return 0 if @param start time is equal to object start time
	 * @return 1 if @param start time is greater than object start time
	 * 
	 */
	public int compareTo(Report r2) {
		if (this.getStartTime().isBefore(r2.getStartTime())) {
			return -1;
		} else if (this.getStartTime().isAfter(r2.getStartTime())) {
			return 1;
		} else if (this.getStartTime().isEqual(r2.getStartTime()))
			return 0;
		else 
		{return 0;}}


	public Report(String ID,int Severity, LocalDate StartTime, LocalDate EndTime, String Street,
			String City, String County, String State, double Temperature, double Humidity, double Visibility,
			String Weather, boolean AtCrossing, boolean IsDay) {
		this.ID = ID;
		this.severity = Severity;
		this.startTime = StartTime;
		this.endTime = EndTime;
		this.street = Street;
		this.city = City;
		this.county = County;
		this.state = State;
		this.temperature = Temperature;
		this.humidity = Humidity;
		this.visibility = Visibility;
		this.weather = Weather;
		this.atCrossing = AtCrossing;
		this.isDay = IsDay;
		
		
	}}

