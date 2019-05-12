package com.wct.spring.AOP.SefRealization.advisor;

import com.wct.spring.AOP.SefRealization.advice.Advice;
import com.wct.spring.AOP.SefRealization.pointcut.Pointcut;

public interface Advisor {
    Advice getAdvice();
    void setAdvice(Advice advice);
    Pointcut getPointcut();
    void setPointcut(Pointcut pointcut);
}
