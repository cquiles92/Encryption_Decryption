import java.util.Scanner;

class Time {

    private static final int SECONDS_PER_MINUTE = 60;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int HOURS_PER_DAY = 24;

    int hour;
    int minute;
    int second;

    public static Time noon() {
        // write your code here
        return of(HOURS_PER_DAY / 2, 0, 0);
    }

    public static Time midnight() {
        // write your code here
        return of(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        // write your code here
        int hours = (int) seconds / SECONDS_PER_HOUR % HOURS_PER_DAY;
        int minutes = (int) (seconds % SECONDS_PER_HOUR) / MINUTES_PER_HOUR;
        int secondsInt = (int) seconds % SECONDS_PER_MINUTE;
        return of(hours, minutes, secondsInt);
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        boolean hourTest = hour > -1 && hour < HOURS_PER_DAY;
        boolean minuteTest = minute > -1 && minute < MINUTES_PER_HOUR;
        boolean secondTest = second > -1 && second < SECONDS_PER_MINUTE;
        if (hourTest && minuteTest && secondTest) {
            Time result = new Time();
            result.hour = hour;
            result.minute = minute;
            result.second = second;
            return result;
        } else {
            return null;
        }
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.printf("%s %s %s", time.hour, time.minute, time.second);
        }
    }
}