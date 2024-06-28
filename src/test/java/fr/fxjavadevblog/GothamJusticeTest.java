package fr.fxjavadevblog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.quarkus.test.junit.QuarkusTest;
import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;

@QuarkusTest
@RequiredArgsConstructor
class GothamJusticeTest {

    final GothmanJustice injectableInstance;

    @Test
    @DisplayName("Given an Injectable Instance, When getting it from CDI, InjectableInstance is injected with a hero and a partner.")
    void testInjectableInstance() {
        assertThat(injectableInstance).isNotNull();
        assertThat(injectableInstance.getHero()).isNotNull().has(buildCondition("Batman"));
        assertThat(injectableInstance.getPartener()).isNotNull().has(buildCondition("Robin"));
    }

    Condition<Person> buildCondition(String name) {
        assertThat(name).isNotNull().isNotBlank();
        return new Condition<>(p -> name.equals(p.getName()), "should has name " + name);
    }

}
