package fr.pizzeria.aspect;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.IPerformanceRepository;
import fr.pizzeria.model.Performance;

@Aspect
@Component
public class PizzeriaDaoPerformance {

	@Autowired
	private IPerformanceRepository repo;

	@Around("execution(* fr.pizzeria.dao.IDao.*(..))")
	public Object fillCode(ProceedingJoinPoint jp) throws Throwable {
		Performance perf = new Performance();
		perf.setService(jp.getSignature().getName());
		LocalTime start = LocalTime.now();
		Object returnVal = jp.proceed();
		perf.setExecTime(ChronoUnit.MILLIS.between(start, LocalTime.now()));
		repo.save(perf);
		return returnVal;
	}

}
