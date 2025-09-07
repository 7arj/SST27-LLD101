package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private JsonWriter jsonWriter;
    private Zipper zipper;
    private AuditLog auditLog;
    
    public ReportBundleFacade() {
        this.jsonWriter = new JsonWriter();
        this.zipper = new Zipper();
        this.auditLog = new AuditLog();
    }
    
    // Alternative constructor for dependency injection
    public ReportBundleFacade(JsonWriter jsonWriter, Zipper zipper, AuditLog auditLog) {
        this.jsonWriter = Objects.requireNonNull(jsonWriter, "jsonWriter cannot be null");
        this.zipper = Objects.requireNonNull(zipper, "zipper cannot be null");
        this.auditLog = Objects.requireNonNull(auditLog, "auditLog cannot be null");
    }
    
    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        // Input validation
        Objects.requireNonNull(data, "data cannot be null");
        Objects.requireNonNull(outDir, "outDir cannot be null");
        Objects.requireNonNull(baseName, "baseName cannot be null");
        
        if (baseName.trim().isEmpty()) {
            throw new IllegalArgumentException("baseName cannot be empty");
        }
        
        try {
            //Write JSON file
            Path jsonFile = jsonWriter.write(data, outDir, baseName);
            
            //create zip file path and zip the JSON
            Path zipPath = outDir.resolve(baseName + ".zip");
            Path resultZip = zipper.zip(jsonFile, zipPath);
            
            //Log success
            auditLog.log("exported " + resultZip);
            
            return resultZip;
            
        } catch (Exception e) {
            // Log failure too
            auditLog.log("failed to export " + baseName + ": " + e.getMessage());
            throw e; // Re-throw to let caller handle
        }
    }
}
