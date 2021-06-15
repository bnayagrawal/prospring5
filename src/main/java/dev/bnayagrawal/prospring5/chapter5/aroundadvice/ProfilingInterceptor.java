package dev.bnayagrawal.prospring5.chapter5.aroundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(methodInvocation.getMethod().getName());
        Object returnValue = methodInvocation.proceed();
        sw.stop();
        dumpInfo(methodInvocation, sw.getTotalTimeMillis());
        return  returnValue;
    }

    private void dumpInfo(MethodInvocation methodInvocation, long totalTimeMillis) {
        Method method = methodInvocation.getMethod();
        Object target = methodInvocation.getThis();
        Object[] args = methodInvocation.getArguments();

        System.out.println("Executed method: " + method.getName());
        System.out.println("On object of type: " + target.getClass().getName());
        System.out.println("With arguments:");
        for (int x = 0; x < args.length; x++) {
            System.out.print("    > " + args[x]);
        }
        System.out.println("\n");
        System.out.println("Took: " + totalTimeMillis + "ms");
    }

}
