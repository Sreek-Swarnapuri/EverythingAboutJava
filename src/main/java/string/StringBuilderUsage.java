package string;

public class StringBuilderUsage {

    public static void main(String[] args) {

        String location = "Hyderabad";
        int flightNumber = 11;

        //Can dynamically resize. However, we can provide the initial length
        StringBuilder sb = new StringBuilder(40);
        sb.append("I flew to space");
        sb.append(location);
        sb.append(" on Flight #");
        sb.append(flightNumber);

        String message = sb.toString();

        System.out.println(message);

        //we can also add the string in between string builder

        String time = "9:00";
        int pos = sb.indexOf(" on");
        sb.insert(pos," at ");
        sb.insert(pos+4, time);

        message = sb.toString();

        System.out.println(message);

    }
}
