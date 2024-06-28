package fr.fxjavadevblog.gotham;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;


/**
 * This class is a CDI producer for the Person class.
 */
public class PersonAnnotationProcessor {

    /**
     * This method is a CDI producer for the Person class.
     * The annotation parameters are extracted (name and age) and used to build a Person instance.
     * 
     * @param ip the injection point
     * @return a Person instance
     */
    @Produces
    @InjectPerson
    public Person build(InjectionPoint ip) {
        InjectPerson annotation = ip.getAnnotated().getAnnotation(InjectPerson.class);
        String name = annotation.name();
        int age = annotation.age();
        return Person.builder().name(name).age(age).build();
    }

}
