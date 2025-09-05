package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        Path src = Path.of("in.mp4");
        Path out = Path.of("out.mp4");
        VideoPipelineFacade facade = new VideoPipelineFacade();
        facade.process(src, out, true, 0.5, 3);
        System.out.println("Wrote " + out);
    }
}
