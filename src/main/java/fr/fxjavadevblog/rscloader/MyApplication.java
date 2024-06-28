package fr.fxjavadevblog.rscloader;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.JsonObject;
import lombok.Getter;

@ApplicationScoped
public class MyApplication {

    @JsonResource("heroes.json")
    @Getter
    JsonObject heroes;

}
