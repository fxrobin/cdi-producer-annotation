package fr.fxjavadevblog;

import jakarta.json.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.rscloader.MyApplication;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class MyApplicationTest {

    @Inject
    MyApplication myApplication;

    @Test
    @DisplayName("Given a MyApplication instance, When accessing the heroes JsonObject, Then it should not be null")
    void testHeroesJsonObject() {
        JsonObject heroes = myApplication.getHeroes();
        assertThat(heroes).isNotNull();
        System.out.println(heroes);
    }

}