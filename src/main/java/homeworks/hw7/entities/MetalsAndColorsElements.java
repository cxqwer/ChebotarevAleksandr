package homeworks.hw7.entities;

import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw7.enums.Vegetables;

import static homeworks.hw4.enums.Colors.*;
import static homeworks.hw4.enums.Metals.SELEN;
import static homeworks.hw4.enums.NatureElements.*;
import static homeworks.hw7.enums.Vegetables.*;

public class MetalsAndColorsElements {
    public int oddSummary;
    public int evenSummary;
    public NatureElements[] natureElements;
    public Colors color;
    public Metals metal;
    public Vegetables[] vegetables;

    public static MetalsAndColorsElements TEST_ELEMENTS = new MetalsAndColorsElements(
            3, 8,
            new NatureElements[]{WATER, FIRE},
            RED, SELEN,
            new Vegetables[]{CUCUMBER, TOMATO});

    public MetalsAndColorsElements(int oddSummary, int evenSummary, NatureElements[] natureElements, Colors color, Metals metal, Vegetables[] vegetables) {
        this.oddSummary = oddSummary;
        this.evenSummary = evenSummary;
        this.natureElements = natureElements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }
}


