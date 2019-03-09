package homeworks.hw8.entities;

import java.util.List;

public class MetalsAndColorsElements {
    public int oddSummary;
    public int evenSummary;
    public List<String> natureElements;
    public String color;
    public String metal;
    public List<String> vegetables;

    public MetalsAndColorsElements(int oddSummary, int evenSummary, List<String> natureElements, String color, String metal, List<String> vegetables) {
        this.oddSummary = oddSummary;
        this.evenSummary = evenSummary;
        this.natureElements = natureElements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }
}


