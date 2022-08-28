package problems;

public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        int minTemp = 25;
        int maxTemp = summer ? 45 : 35;
      return temperature >= minTemp && temperature <= maxTemp;
    }
}
