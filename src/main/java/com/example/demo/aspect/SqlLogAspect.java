package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SqlLogAspect {

	@Before("execution(* org.springframework.jdbc.core.JdbcOperations.*(..))")
	public void writeSqlLog(JoinPoint jp) {
		String sql = jp.getArgs()[0].toString();
		System.out.println(sql);
		
		Object[] argsArray = (Object[])jp.getArgs()[2];
		for(int i=0; i<argsArray.length; i++) {
			String argStr = "arg[" + String.valueOf(i) + "]=" + argsArray[i].toString();
			System.out.println(argStr);
		}		
	}
}
