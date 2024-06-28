package fr.fxjavadevblog.rscloader;

import java.io.IOException;
import java.io.InputStream;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.Json;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonResourceAnnotationProvider {


    @Produces
    @JsonResource()
    public JsonObject build(InjectionPoint ip) {
        JsonResource annotation = ip.getAnnotated().getAnnotation(JsonResource.class);
        String fileName = annotation.value();

        if (fileName.isEmpty()) {
            throw new IllegalArgumentException("The value of the JsonResource annotation must not be empty.");
        }

        try(InputStream is = getResourceAsStream(fileName)) {
            JsonReader reader = Json.createReader(is);
            return reader.readObject();
        } catch (IOException e) {
            log.error("Impossible to read resource " + fileName, e);
            throw new IllegalArgumentException("Error loading JSON file: " + fileName, e);
        }

    }

    private static InputStream getResourceAsStream(String fileName) {    
            return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);  
    }

}
