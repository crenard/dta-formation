package fr.pizzeria.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class PizzaCodeFiller {

	@Before("execution(void fr.pizzeria.dao.*.save(..)) && args(pizza)")
	public void fillCode(JoinPoint jp, Pizza pizza) throws Throwable {
		if ("".equals(pizza.getCode())) {
			int size = pizza.getNom().length();
			pizza.setCode(pizza.getNom().substring(0, size < 3 ? size : 3).toUpperCase());
		}
	}

}
