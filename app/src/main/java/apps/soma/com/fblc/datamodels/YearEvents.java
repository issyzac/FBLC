package apps.soma.com.fblc.datamodels;

/**
 * Created by issy on 4/26/17.
 */

public class YearEvents {

    String yearEventTitle;
    String monthName;

    public YearEvents(){}

    public YearEvents(String title, String month){

        this.yearEventTitle = title;
        this.monthName      = month;

    }

    public String getEventTitle() {
        return yearEventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.yearEventTitle = eventTitle;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
}
