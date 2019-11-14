import sun.awt.image.ImageWatched;

import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  /**
   * Takes in a linked list of data and a month removes all erroneous data from data list and from this new list creates
   * two new lists of data, one of dates and one of maxHz and returns the corresponding data points for the specified month
   * @param data list of data from earthquake monitor to be parsed
   * @param month chosen month to get list of new data for
   * @return maxHzReports
   */

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

    LinkedList<Double> cleanData = new LinkedList<Double>();

    for (Double d : data){
      if (d > 0){
        cleanData.add(d);
      }
    }

    LinkedList<Double> maxData = new LinkedList<Double>();
    LinkedList<Double> dates = new LinkedList<Double>();
    double max = 0;
    int a = 0;
    for (int i = 0; i < cleanData.size(); i++) {
      if (isDate(cleanData.get(i)) == false) {
        if (cleanData.get(i) >= max){
          max = cleanData.get(i);
          a++;
          if (i == (cleanData.size()-1)){
            maxData.add(max);
          }
        }
      }
      else if (isDate(cleanData.get(i)) == true && a >0){
        maxData.add(max);
        max = 0;
      }


      if (isDate(cleanData.get(i))==true){
        dates.add(cleanData.get(i));
      }
    }

    LinkedList<MaxHzReport> maxHzReports = new LinkedList<>();
    for(int i = 0; i < maxData.size(); i++){

      double date = dates.get(i);
      double maxF = maxData.get(i);

      if (extractMonth(date) == month) {
        maxHzReports.add(new MaxHzReport(date, maxF));
      }
    }

    return maxHzReports;

  }
}