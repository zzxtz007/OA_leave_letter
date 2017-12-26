package top.haha233.oa.service.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import top.haha233.oa.enums.StatusEnum;
import top.haha233.oa.util.Response;

import java.util.EnumSet;

/**
 * @author Ice_Dog
 */
@Aspect
@Component
public class CheckService {
	private static final Logger log = Logger.getLogger(CheckService.class);
	@Around(value = "execution(* top.haha233.oa.service.impl.*.*(..))")
	public Response checkLogin(ProceedingJoinPoint pjp) {
		System.out.println("进入aop切面");
		Response r;
		try {
			r = (Response) pjp.proceed();
			log.info("执行完成状态为："+r.get("status"));
			for (StatusEnum statusEnum : EnumSet
					.range(StatusEnum.stateOf(3), StatusEnum.stateOf(6))) {
				if (statusEnum.equals(r.get("status"))){
					log.info("执行完成并简化的状态为："+r.get("status"));
					return new Response(StatusEnum.stateOf(2));
				}
			}
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			r = new Response(StatusEnum.stateOf(2));
			log.info("执行完成 出现异常的 状态为："+r.get("status"));
			return r;
		}
		System.out.println(r);
		return r;
	}
}
