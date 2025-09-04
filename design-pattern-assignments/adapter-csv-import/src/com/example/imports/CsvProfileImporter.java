package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader reader;
    private final ProfileService service;

    public CsvProfileImporter(NaiveCsvReader reader, ProfileService service) {
        this.reader = Objects.requireNonNull(reader);
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = reader.read(csvFile);
        int count = 0;
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if (row.length < 3) {
                System.out.println("Row " + (i+1) + " skipped: missing fields");
                continue;
            }
            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();
            if (id.isEmpty() || email.isEmpty()) {
                System.out.println("Row " + (i+1) + " skipped: missing id/email");
                continue;
            }
            if (!email.contains("@")) {
                System.out.println("Row " + (i+1) + " skipped: invalid email");
                continue;
            }
            try {
                service.createProfile(id, email, displayName);
                count++;
            } catch (Exception e) {
                System.out.println("Row " + (i+1) + " skipped: " + e.getMessage());
            }
        }
        return count;
    }
}
