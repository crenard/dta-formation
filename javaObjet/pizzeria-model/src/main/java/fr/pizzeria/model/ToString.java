package fr.pizzeria.model;

import java.lang.annotation.*;

/**
 * Annotation pour choisir quel element de pizza afficher
 * 
 * @author ETY 10
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ToString {
	boolean uppercase() default false;
}
