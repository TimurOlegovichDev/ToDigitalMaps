package timbezhdev.ru.giscalculator;

public class DirectCalculator {
    public static double[] calculate(double x, double y, String angleStr, double position){
        double[] res = new double[2];
        String[] parts = angleStr.split(" ");
        double degrees = 0;
        try{
            degrees = Double.parseDouble(parts[0]);
        } catch (IndexOutOfBoundsException e){}
        double minutes = 0;
        try{
            minutes = Double.parseDouble(parts[1]);
        } catch (IndexOutOfBoundsException e){}
        double seconds = 0;
        try{
            seconds = Double.parseDouble(parts[2]);
        } catch (IndexOutOfBoundsException e){}
        double angle = degrees + (minutes / 60) + (seconds / 3600);
        double dX = position*Math.cos(angle * Math.PI / 180);
        double dY = position*Math.sin(angle * Math.PI / 180);
        res[0] = Math.round((x + dX) * 1000) / 1000.0;
        res[1] = Math.round((y + dY) * 1000) / 1000.0;
        return res;
    }
}
