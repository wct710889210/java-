package com.wct.spring.AOP.SefRealization.main;

import com.wct.spring.AOP.SefRealization.advice.MyAfterAdvice;
import com.wct.spring.AOP.SefRealization.weaver.Weaver;
import com.wct.spring.AOP.SefRealization.advice.MyBeforeAdvice;
import com.wct.spring.AOP.SefRealization.advisor.SimpleAdvisor;
import com.wct.spring.AOP.SefRealization.pointcut.MethodNamePointcut;
import com.wct.spring.AOP.SefRealization.pointcut.Pointcut;

public class Main {
    public static void main(String[] args) {
        MyBeforeAdvice advice = new MyBeforeAdvice("前置通知");
        MyAfterAdvice afterAdvice = new MyAfterAdvice("后置通知1");
        MyAfterAdvice afterAdvice2 = new MyAfterAdvice("后置通知2");

        Pointcut pointcut = new MethodNamePointcut("execute");

        SimpleAdvisor advisor = new SimpleAdvisor(advice,pointcut);
        SimpleAdvisor afterAdvisor = new SimpleAdvisor(afterAdvice,pointcut);
        SimpleAdvisor afterAdvisor2 = new SimpleAdvisor(afterAdvice2,pointcut);

        Weaver weaver = new Weaver(new Target());
        weaver.addAdvisor(advisor);
        weaver.addAdvisor(afterAdvisor);
        weaver.addAdvisor(afterAdvisor2);
        Target proxy = (Target)weaver.getProxy();

        proxy.execute();
        proxy.test();
    }
}
