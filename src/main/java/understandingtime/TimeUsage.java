package understandingtime;

import java.time.LocalDate;

public class TimeUsage {

    public static void main(String[] args) {

        //Creating a LocalDate with today's date
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        //adding 5 days to the local date
        long addDays = 5;
        LocalDate newDate = localDate.plusDays(addDays);

        String output = String.format("%s plus %d days is %s",localDate,addDays,newDate);

        System.out.println(output);



    }

}
