package top.haha233.oa.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import top.haha233.oa.util.Response;

/**
 * @author Ice_Dog
 */
@Aspect
@Component
public class CheckService {

	@Around(value = "execution(* top.haha233.oa.service.impl.*.*(..))")
	public Response checkLogin(ProceedingJoinPoint pjp) {
		System.out.println("进入");
		Response r;
		try {
			r = (Response) pjp.proceed();
			int res = (int) r.get("status");
			if (res >= 3) {
				return new Response(3);
			}
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return new Response(3);
		}
		return r;
	}
}
