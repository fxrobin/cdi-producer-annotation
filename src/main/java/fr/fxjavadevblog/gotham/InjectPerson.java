package fr.fxjavadevblog.gotham;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.util.Nonbinding;
import jakarta.inject.Qualifier;


/**
 * This annotation is used to inject a Person instance with a name and an age.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
public @interface InjectPerson {

   @Nonbinding String name() default "<NO_NAME>";
   @Nonbinding int age() default 0;

}
