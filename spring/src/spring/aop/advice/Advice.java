package spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {
	 
    public Object trace(ProceedingJoinPoint j) throws Throwable{
        Object result;
        //타겟 메서드의 signature 정보
        String signatureString = j.getSignature().toShortString();
        System.out.println(signatureString + "시작");
        
        //타겟의 메서드가 호출되기 전의 시간
        long start =System.currentTimeMillis();
        try {
            //타겟의 메서드 호출
            result = j.proceed();
            return result;
        } finally {
            // 타겟의 메서드가 호출된 후의 시간
            long finish = System.currentTimeMillis();
            System.out.println(signatureString + "종료");
            System.out.println(signatureString + "실행 시간 : " + (finish - start) + " ms");
        }
    }
}    
