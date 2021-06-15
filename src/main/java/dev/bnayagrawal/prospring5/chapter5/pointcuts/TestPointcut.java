package dev.bnayagrawal.prospring5.chapter5.pointcuts;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class TestPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("advise".equals(method.getName()));
    }
}
