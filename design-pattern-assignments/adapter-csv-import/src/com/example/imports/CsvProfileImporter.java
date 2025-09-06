package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private NaiveCsvReader csvReader;
    private ProfileService profileService;
    
    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader);
        this.profileService = Objects.requireNonNull(profileService);
    }
    
    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int successCount = 0;
        int rowNumber = 0;
        
        for (String[] row : rows) {
            rowNumber++;
            
            //assuming first row is header
            if (rowNumber == 1) {
                continue;
            }
            
            try {
                // Check if row has enough columns

                if (row.length < 3) {
                    System.out.println("Skipping row " + rowNumber + ": not enough columns");
                    continue;
                }
                
                String id = row[0].trim();
                String email = row[1].trim();
                String displayName = row[2].trim();
                
                //validation
                if (id == null || id.isEmpty()) {
                    System.out.println("Skipping row " + rowNumber + ": missing id");
                    continue;
                }
                
                if (email == null || email.isEmpty()) {
                    System.out.println("Skipping row " + rowNumber + ": missing email");
                    continue;
                }
                
                //ProfileService handles email validation
                profileService.createProfile(id, email, displayName);
                successCount++;
                
            } catch (IllegalArgumentException e) {
                System.out.println("Skipping row " + rowNumber + ": " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Skipping row " + rowNumber + ": unexpected error - " + e.getMessage());
            }
        }
        
        return successCount;
    }
}