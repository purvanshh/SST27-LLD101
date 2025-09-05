package com.example.render;
public class App {
    public static void main(String[] args) {
        Renderer r = new Renderer();
        System.out.println("Cost=" + r.render("Hello Flyweight! ".repeat(2000)));
        // Quick check: style instance reuse
        TextStyle s1 = TextStyleFactory.getTextStyle("Inter", 14, true);
        TextStyle s2 = TextStyleFactory.getTextStyle("Inter", 14, true);
        TextStyle s3 = TextStyleFactory.getTextStyle("Inter", 14, false);
        System.out.println("s1 == s2: " + (s1 == s2)); // should be true
        System.out.println("s2 == s3: " + (s2 == s3)); // should be false
    }
}
