package accidentpack;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * program6 - a treeMap of treeMaps. The inner treeMaps values contain 
 * keys of dates that have values of an arrayList 
 * that adds reports of the same date and state to it.
 * The outer treeMap sorts reports of the same state in the USA,
 * with values being keys of the inner map. 
 */
public class program6 {
/**
 * printTree - prints amount of reports during or after specified date, if in the specified state tree
 * @param state
 * @param date
 */
	 static void printTree(String state, String date) {
long start;
long stop;
start = System.nanoTime();
		 String State = state;
		 LocalDate Date = MapHandler.dateConvert(date + " 00:00:00");
		 int count=0;
		 for (LocalDate d : MapHandler.treeMap.get(State).keySet())
			 if (d.isEqual(Date)||d.isAfter(Date)) {
				 count+=MapHandler.treeMap.get(State).get(d).size();
			 }
		 stop = System.nanoTime();
		System.out.println(count + " reports are available for "+ State +" on and after the date " + Date);
			}
				
			
	
public static void main(String[]args) throws IOException, ParseException {
	MapHandler.treeMap= MapHandler.ReadCSVFile("accidents_small_sample.csv");
//printTree("CA","2022-08-25");
printTree(args[0], args[1]);
}
}
