package com.wct.spring.AOP.SefRealization.advisor;

import com.wct.spring.AOP.SefRealization.advice.Advice;
import com.wct.spring.AOP.SefRealization.pointcut.Pointcut;

public class SimpleAdvisor implements Advisor{
    public Advice advice;
    public Pointcut pointcut;

    public SimpleAdvisor(Advice advice, Pointcut pointcut) {
        this.advice = advice;
        this.pointcut = pointcut;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }
}
