import java.util.LinkedList;

class Earthquake1 {
  Earthquake1() {
  }

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum > 10000000;
  }

  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) {
    return ((int) dateNum % 10000) / 100;
  }

    /**
     * Takes in a linked list of data and a month and determines which data points are in the specified month
     * and returns the date and the max frequency for that date in a new list
     * @param data list of data from earthquake monitor to be parsed
     * @param month chosen month to get list of new data for
     * @return maxHzReports
     */

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

    LinkedList<MaxHzReport> maxHzReports = new LinkedList<>();
    double date = 0;
    double max = 0;
    int count = 0;

    for (Double d : data) {

      if (isDate(d) == true && count == 0) {
        date = d;
        count++;
      }
      else if (isDate(d) == false) {
        if (d > max) {
          max = d;
        }
      } else if (isDate(d) == true && count == 1) {
        count = 0;
      }

      if (extractMonth(date) == month && isDate(d)==false){
        maxHzReports.add(new MaxHzReport(date, max));
      }
      max = 0;
    }

    return maxHzReports;
  }
}

