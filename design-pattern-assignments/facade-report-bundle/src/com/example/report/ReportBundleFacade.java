package com.example.report;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data must not be null");
        Objects.requireNonNull(outDir, "outDir must not be null");
        Objects.requireNonNull(baseName, "baseName must not be null");
        try {
            JsonWriter jsonWriter = new JsonWriter();
            Path jsonPath = jsonWriter.write(data, outDir, baseName);
            Zipper zipper = new Zipper();
            Path zipPath = zipper.zip(jsonPath, outDir.resolve(baseName + ".zip"));
            AuditLog auditLog = new AuditLog();
            auditLog.log("Exported report bundle: " + zipPath);
            return zipPath;
        } catch (Exception e) {
            if (e instanceof java.io.UncheckedIOException) throw (java.io.UncheckedIOException) e;
            if (e instanceof java.io.IOException) throw new UncheckedIOException((java.io.IOException) e);
            throw new RuntimeException(e);
        }
    }
}
