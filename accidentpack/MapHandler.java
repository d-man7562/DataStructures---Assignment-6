package accidentpack;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * MapHandler - handles treeMap acquisition and sorting
 * @author Domenic Mancuso
 * @version 3/22/2024
 */

public class MapHandler {
	

	static Map<String,Map<LocalDate, ArrayList<LocalDate>>> treeMap = new TreeMap<>();
	/**
	 * MapAddMethod - takes in report object, adds to treeMap based on state, adds to inner treeMap
	 * depending on date, adds report date to arrayList inside of inner treeMap object
	 * @param report
	 * @return
	 */
		public static Map<String,Map<LocalDate, ArrayList<LocalDate>>> MapAddMethod(Report report) {
	
			String state = report.getState();
			LocalDate date = report.getStartTime();
		//does not contain desired state
			
			if (!treeMap.containsKey(state)) {
				//creates new key of state, with a treeMap of dates
				treeMap.put(state, new TreeMap<LocalDate, ArrayList<LocalDate>>());
			}
			//contains state, no date
			if (!treeMap.get(state).containsKey(date)) {
			treeMap.get(state).put(date, new ArrayList<>());
			//add date to new arrayList
			treeMap.get(state).get(date).add(date);
			}else {
			//contans date and arrayList
				//add date to existing arrayList
				if (treeMap.get(state).containsKey(date))
			treeMap.get(state).get(date).add(date);
			}
			
			return treeMap;
			}
		
		
	
	/**
	 * createReport - creates report object using Scanner to read file line by line
	 * @param line
	 * @return r Report
	 */
	private static Report createReport(String line) {//a method for creating a report
		String[] items= line.split(",");
		String ID = items[0];
		int Severity = Integer.parseInt(items[1]);	
		LocalDate StartTime = dateConvert(items[2]);
		LocalDate EndTime = dateConvert(items[3]);		
		String Street = items[4];
		String City = items[5];
		String County = items[6];
		String State = items[7];
		double Temperature = Double.parseDouble(items[8]);
		double Humidity = Double.parseDouble(items[9]);
		double Visibility = Double.parseDouble(items[10]);
		String Weather = items[11];
		boolean AtCrossing = items[12].substring(0,1).equals("F")?true: false;
		boolean IsDay = items[13].substring(0,1).equals("N")?false:true;
		Report r = new Report(ID, Severity,StartTime, EndTime, Street, City, County, State, Temperature, Humidity, Visibility, Weather, AtCrossing, IsDay);
		return r;	}
	public static long Seconds(long start, long stop) {
		long time  = ((stop-start)/1000000000);
		
		return time;
	}
	/**
	 * ReadCSVFile - reads CSV file creating report objects using createReport
	 * Adds reports to data structure
	 * @param filePath
	 * @return treeMap - treeMap of reports sorted by state, each state containing a treeMap of dates,
	 * each date contains an arrayList with the amount of reports with matching state and date.
	 * @throws IOException
	 * @throws ParseException
	 */
	public static Map<String,Map<LocalDate,ArrayList<LocalDate>>> ReadCSVFile(String filePath) throws IOException, ParseException
	{		
long start;
long stop;
start = System.nanoTime();
Scanner scanner = new Scanner(new File(filePath));
String line = null;
scanner.nextLine();
//int count =0;
//create reports
while(scanner.hasNextLine()) {
line = scanner.nextLine();
Report r = createReport(line);
	treeMap = MapAddMethod(r);
//count++;
//if (count%10000 ==0)
//System.out.println(count+" reports added");
}
stop = System.nanoTime();
System.out.println(Seconds(start, stop) + " seconds to build the tree map");
return treeMap;
}
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * DateConvert - converts inputDate to readable LocalDate format
	 * @author Behrooz Mansouri (professor). Thanks!
	 */
		 public static LocalDate dateConvert(String dateTimeString){
	        // for some of the instances the after seconds there are 0s; this line will remove them
	  dateTimeString = dateTimeString.split("\\.")[0];

	        // Parse the string using the formatter
	  LocalDate localDate;
      try {
	  localDate = LocalDate.parse(dateTimeString, formatter);
      } catch (Exception e) {
	            // Handle parsing exception, e.g., invalid format, invalid date
	    System.err.println("Error parsing date-time string: " + e.getMessage());
	    localDate = null;
	          }
	        return localDate;
	    }
}
