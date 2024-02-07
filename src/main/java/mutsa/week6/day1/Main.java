package mutsa.week6.day1;



public class Main {
    public static void main(String[] args) {
        checkLeapYear(2020);
    }
    public static int checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) System.out.println("O");
        else System.out.println("X");
        return year;
    }
}
