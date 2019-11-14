/*
Molly Sykes
Cory Helmuth
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void testE2(){
    assertEquals(NovReports, E2.dailyMaxForMonth(threeDates, 11));
  }

}

/*
  Earthquake1
  Loop trough data and find a date and saves it as a variable date and find the max frequency and save as a variable max
  Add max and date variables to the list maxHzReports as a MaxHzReport if the date matches the specified month

  Earthquake2
  Create new list cleanData from data by removing all negative numbers
  Create two new lists maxData and dates by looping through cleanData by determining the max and adding it to the list,
  and finding the date and adding it to the list of dates
  New lists are looped through and only the data points in the month indicated are added to maxHzReports.
 */