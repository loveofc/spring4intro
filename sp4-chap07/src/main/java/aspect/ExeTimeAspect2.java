package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect2 {
	
	//수식어패턴 리턴타입 클래스이름패턴메서드이름패턴(파라미터패턴)
	//public void set*(..) 리턴 void 메서드이름이 set으로시작하고, 파라미터가 0개 이상인 메서드 호출
	//* chap07..*.*(..) // 리턴타입모든것이며 챕터7하위 클래스 전부이면서 메서드전부 파라미터는 0개이상
	
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
		
	}

	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try{
			Object result = joinPoint.proceed();
			return result;
		}finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s,%s(%s) 실행 시간 : %d ns\n", joinPoint.getTarget().getClass().getSimpleName(),sig.getName(),Arrays.toString(joinPoint.getArgs()),(finish-start));
		}
	}
}