package problems;

public class SecondsMinutes {
    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || (seconds < 0 || seconds > 59)) {
            return "Invalid value";
        }
        int hours = minutes / 60;
        minutes = minutes % 60;
        return hours + "h " + minutes + "m " + seconds + "s";
    }

    public static String getDurationString(int seconds) {
        int minutes = seconds / 60;
        seconds %= 60;
        String x = getDurationString(minutes, seconds);
        return x;
    }
}
