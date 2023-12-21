package kr.rene.template.sampledomain1.common.logtrace.aop;

import java.util.Arrays;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import kr.rene.template.sampledomain1.common.logtrace.LogTracer;
import kr.rene.template.sampledomain1.common.logtrace.model.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class GlobalTraceHandler {

	private final LogTracer logTracer;
	private static final String EXCEPTION_LOGGED_KEY = "exceptionLogged";

	@Around("kr.rene.template.sampledomain1.common.logtrace.aop.GlobalTraceHandler.api()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		TraceStatus status = null;
		Object result = null;

		try {
			status = logTracer.begin(joinPoint.getSignature().toShortString());

			// parameter detail 정보 표현 로직
			//			Object[] args = joinPoint.getArgs();
			//			log.info("Incoming Request Body: {}", Arrays.toString(args)); // 들어오는 DTO 로깅
			//			result = joinPoint.proceed();
			//			log.info("Outgoing Response Body: {}", result); // 나가는 DTO 로깅

			result = joinPoint.proceed();
			logTracer.end(result, status);
			return result;
		} catch (Exception exception) {
			if (shouldLogException(joinPoint)) {
				logTracer.exception(null, status, exception);
				markExceptionAsLogged(joinPoint);
			}
			throw exception;
		}
	}

	private boolean shouldLogException(ProceedingJoinPoint joinPoint) {
		return Arrays.stream(joinPoint.getArgs()).noneMatch(arg -> arg instanceof Map &&
			((Map<?, ?>)arg).containsKey(EXCEPTION_LOGGED_KEY));
	}

	private void markExceptionAsLogged(ProceedingJoinPoint joinPoint) {
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof Map) {
				((Map<String, Object>)arg).put(EXCEPTION_LOGGED_KEY, true);
				break;
			}
		}
	}

	@Pointcut("execution(* kr.rene.template.sampledomain1.api..*(..))")
	public void api() {
	}

}