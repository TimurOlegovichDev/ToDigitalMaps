package timbezhdev.ru.giscalculator;

import com.google.gson.Gson;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.util.*;

@Scope("singleton")
public class Graph {
    private String color;
    private String name;
    private Map<Integer, Integer> points = new HashMap<>();

    Graph(String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Map getData(){
        return new HashMap(points);
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
    public String[] toJson(){
        String[] array = new String[2];
        array[0] = new Gson().toJson(getData().keySet());
        array[1] = new Gson().toJson(getData().values());
        return array;
    }
}
