package timbezhdev.ru.giscalculator;

import java.math.BigDecimal;

public class ReversCalculator {
    public static String[] calculate(double x1, double y1, double x2, double y2){
        String[] res = new String[2];
        double dx = x2-x1;
        double dy = y2-y1;
        double r = Math.toDegrees(Math.atan(dy / dx));
        double angle = r;
        if (dx > 0) {
            if (dy < 0) angle = 360.0 - r;
            else if (dy == 0) angle = 0.0;
        } else if (dx < 0) {
            if (dy == 0) angle = 180.0;
            else if (dy < 0) angle = 180.0 + r;
            else angle = 180-r;
        } else {
            if (dy > 0) angle = 90.0;
            else if (dy < 0) angle = 270.0;
            else angle = 0.0;
        }
        res[0] = formatAngle(angle);
        BigDecimal position = BigDecimal.valueOf(Math.round(Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2)) * 1000.0) / 1000.0);
        res[1] = position.toString();
        return res;
    }
    private static String formatAngle(double angle) {
        int degrees = (int) angle;
        double remainingMinutes = (angle - degrees) * 60;
        int minutes = (int) remainingMinutes;
        int remainingSeconds = (int) ((remainingMinutes - minutes) * 60);

        if(minutes <= 0 && remainingSeconds <= 0) return degrees + "°";
        else if(remainingSeconds <= 0) return degrees + "°" + minutes + "'";
        else return degrees + "°" + minutes + "'" + remainingSeconds + "\"";
    }
}
