package fr.fxjavadevblog;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.gotham.GothmanJustice;
import fr.fxjavadevblog.gotham.Person;
import io.quarkus.test.junit.QuarkusTest;
import lombok.RequiredArgsConstructor;

@QuarkusTest
@RequiredArgsConstructor
class GothamJusticeTest {

    final GothmanJustice gothamJustice;

    @Test
    @DisplayName("Given an Injectable Instance, When getting it from CDI, InjectableInstance is injected with a hero and a partner.")
    void testInjectableInstance() {
        assertThat(gothamJustice).isNotNull();
        assertThat(gothamJustice.getHero()).isNotNull().has(buildCondition("Batman"));
        assertThat(gothamJustice.getPartener()).isNotNull().has(buildCondition("Robin"));
    }

    Condition<Person> buildCondition(String name) {
        assertThat(name).isNotNull().isNotBlank();
        return new Condition<>(p -> name.equals(p.getName()), "should has name " + name);
    }

}
