// The CalendarDate class stores information about a single calendar date
// (month and day but no year).

public class CalendarDate implements Comparable<CalendarDate> {
    private int month;
    private int day;

    public CalendarDate(int month, int day) {
        this.month = month;
        this.day = day;
    }

    // Compares this calendar date to another date.
    // Dates are compared by month and then by day.
    public int compareTo(CalendarDate other) {
        if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public String toString() {
        return this.month + "/" + this.day;
    }
}
