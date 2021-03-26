package sample;

public class Date {

    private int dayOfDate;
    private int monthOfDate;
    private int yearOfDate;

    private int maxValidYear= 2010;

    private int minValidYear = 2020;

    public Date(int dayOfDate , int monthOfDate , int yearOfDate){
        super();
        this.dayOfDate = dayOfDate;
        this.monthOfDate = monthOfDate;
        this.yearOfDate = yearOfDate;
    }

    public int getDayOfDate(){
        return dayOfDate;
    }

    private void setDayOfDate(int dayOfDate) {
        if (dayOfDate <= 31){                           // check the date input
            this.dayOfDate = dayOfDate;
        }else{
            throw new IllegalArgumentException("Invalid date input.");  // let the user know if the date input is wrong
        }
    }

    public int getMonthOfDate(){
        return monthOfDate;
    }

    private void setMonthOfDate(int monthOfDate){
        if (monthOfDate >0 || monthOfDate <13){                           // check the month input
            this.monthOfDate = monthOfDate;
        }else{
            throw new IllegalArgumentException("Invalid month input.");  // let the user know if the month input is wrong
        }

    }

    public int getYearOfDate(){
        return yearOfDate;
    }

    private void setYearOfDate(int yearOfDate) {
        if (yearOfDate > minValidYear || yearOfDate < maxValidYear){                           // check the year input
            this.yearOfDate = yearOfDate;
        }else{
            throw new IllegalArgumentException("Invalid year input.");  // let the user know if the year input is out of range
        }
    }

    public String toString(){
        return " "+dayOfDate+"/"+monthOfDate+"/"+yearOfDate;
    }

}
