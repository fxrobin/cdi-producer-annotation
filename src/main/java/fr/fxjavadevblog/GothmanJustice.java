package fr.fxjavadevblog;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;

/**
 * This class represents the GothmanJustice group.
 * Person instances are injected using the InjectPerson annotation.
 * 
 */

@ApplicationScoped
public class GothmanJustice {

    @Getter
    final Person hero;

    @Getter
    final Person partener;

    public GothmanJustice(@InjectPerson(name = "Batman", age=45) Person hero, 
                          @InjectPerson(name = "Robin", age=27)  Person partener) {
        this.hero = hero;
        this.partener = partener;
    }

    @Override
    public String toString() {
      return "I am GothmanJustice, the group with " + hero + " and " + partener + ".";
    }

}
