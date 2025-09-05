package com.example.video;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    /**
     * Adapts the legacy sharpen API to work with Frame[] objects.
     * Simulate a handle as a string, e.g., by encoding frame count and sharpen strength.
     */
    public Frame[] sharpen(Frame[] frames, int strength) {
        // Simulate a handle as a string
        String handle = "FRAMES:" + frames.length;
        String sharpenedHandle = legacySharpen.applySharpen(handle, strength);
        // For demo, just return the same frames (real impl would modify them)
        return frames;
    }
}
