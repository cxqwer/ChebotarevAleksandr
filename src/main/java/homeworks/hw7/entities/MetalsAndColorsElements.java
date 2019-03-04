package homeworks.hw7.entities;

import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw7.enums.Vegetables;

import static homeworks.hw7.enums.Vegetables.VEGETABLES;

public class MetalsAndColorsElements {
    private int oddSummary;
    private int evenSummary;
    private NatureElements[] natureElements;
    private Colors color;
    private Metals metal;
    private Vegetables[] vegetables;

    public static MetalsAndColorsElements DEFAULT = new MetalsAndColorsElements(
            1, 1,
            null,
            null, null,
            new Vegetables[]{VEGETABLES});

    public MetalsAndColorsElements(int oddSummary, int evenSummary, NatureElements[] natureElements, Colors color, Metals metal, Vegetables[] vegetables) {
        this.oddSummary = oddSummary;
        this.evenSummary = evenSummary;
        this.natureElements = natureElements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public void setSummaries(int oddSummary, int evenSummary){
        this.oddSummary = oddSummary;
        this.evenSummary = evenSummary;
    }

    public void setNatureElements(NatureElements[] natureElements) {
        this.natureElements = natureElements;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setMetal(Metals metal) {
        this.metal = metal;
    }

    public void setVegetables(Vegetables[] vegetables) {
        this.vegetables = vegetables;
    }

    public int getOddSummary() {
        return oddSummary;
    }

    public int getEvenSummary() {
        return evenSummary;
    }

    public NatureElements[] getNatureElements() {
        return natureElements;
    }

    public Colors getColor() {
        return color;
    }

    public Metals getMetal() {
        return metal;
    }

    public Vegetables[] getVegetables() {
        return vegetables;
    }
}


