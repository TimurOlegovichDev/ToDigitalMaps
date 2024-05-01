package timbezhdev.ru.giscalculator;

import java.util.*;

public class Graph {
    private String color;
    private Map<Integer, Integer> points = new HashMap<>();
    Graph(String color){
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean add(int height, int position){
        if(points.size() > 200) return false;
        points.put(height, position);
        return true;
    }
    public boolean removeLast(){
        if(points.size() == 0) return false;
        points.remove(points.size()-1);
        return true;
    }
}
