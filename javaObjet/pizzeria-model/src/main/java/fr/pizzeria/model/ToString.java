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
	/**
	 * Predicat pour changer l'element en uppercase
	 * 
	 * @return
	 */
	boolean uppercase() default false;
}
