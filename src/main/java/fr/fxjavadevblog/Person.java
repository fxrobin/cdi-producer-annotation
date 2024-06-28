package fr.fxjavadevblog;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * This class represents a Person.
 *
 */

@Builder
@ToString
@EqualsAndHashCode
@Getter
public class Person {

    final String name;
    final int age;

}
