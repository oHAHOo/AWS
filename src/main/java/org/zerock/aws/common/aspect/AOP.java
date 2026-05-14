package org.zerock.aws.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class AOP {
	private final HttpServletRequest request;

	@Before("execution(* org.zerock.aws.service.MemberService.*(..))")
	public void dtoAccess(JoinPoint joinPoint) throws Throwable {

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String methodName = joinPoint.getSignature().getName();

		log.info("[API - LOG] {} {} | method={}",
			method, url, methodName);
	}
}
