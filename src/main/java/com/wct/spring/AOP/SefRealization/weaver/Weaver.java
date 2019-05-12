package com.wct.spring.AOP.SefRealization.weaver;

import com.wct.spring.AOP.SefRealization.advice.AfterAdvice;
import com.wct.spring.AOP.SefRealization.advice.BeforeAdvice;
import com.wct.spring.AOP.SefRealization.advisor.Advisor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Weaver {
    private List<Advisor> advisors;
    private Object target;

    public Weaver(Object target) {
        this.target = target;
        this.advisors = new ArrayList<>();
    }

    public void addAdvisor(Advisor advisor){
        advisors.add(advisor);
    }

    public Object getProxy(){
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                for (Advisor advisor:advisors){
                    if(advisor.getPointcut().methodMath(method.getName())){
                        if(advisor.getAdvice() instanceof BeforeAdvice){
                            BeforeAdvice beforeAdvice = (BeforeAdvice) advisor.getAdvice();
                            beforeAdvice.before(method,objects);
                        }
                    }
                }
                Object result = methodProxy.invokeSuper(o,objects);
                for (Advisor advisor:advisors){
                    if(advisor.getPointcut().methodMath(method.getName())){
                        if(advisor.getAdvice() instanceof AfterAdvice){
                            AfterAdvice afterAdvice = (AfterAdvice) advisor.getAdvice();
                            afterAdvice.after(method,objects);
                        }
                    }
                }
                return result;
            }
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }
}
