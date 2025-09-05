package com.example.render;

public class Renderer {
    public int render(String text) {
        int cost = 0;
        TextStyle styleB = TextStyleFactory.getTextStyle("Inter", 14, true);
        TextStyle styleN = TextStyleFactory.getTextStyle("Inter", 14, false);
        for (char c : text.toCharArray()) {
            TextStyle style = (c % 7 == 0) ? styleB : styleN;
            Glyph g = new Glyph(c, style);
            cost += g.drawCost();
        }
        return cost;
    }
}
