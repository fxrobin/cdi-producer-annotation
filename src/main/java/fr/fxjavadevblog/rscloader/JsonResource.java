package fr.fxjavadevblog.rscloader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.util.Nonbinding;
import jakarta.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
public @interface JsonResource {

    /**
     * name of the JSON file to load placed in the resources folder or subfolders.
     * @return
     */
    @Nonbinding String value() default "";

}
