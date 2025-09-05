package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;

    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter(new LegacySharpen());
    }

    /**
     * Processes a video file through the pipeline.
     */
    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        // 1. Decode
        Frame[] frames = decoder.decode(src);
        // 2. Optional grayscale
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }
        // 3. Optional scale
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }
        // 4. Optional sharpen
        if (sharpenStrength != null) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }
        // 5. Encode
        encoder.encode(frames, out);
        return out;
    }
}
