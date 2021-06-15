package dev.bnayagrawal.prospring5.chapter5.beforeadvice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedOnUser();

        if(null == userInfo) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        } else if("John".equals(userInfo.getUserName())) {
            System.out.println("Logged in user is John - OKAY!");
        } else {
            System.out.println("Logged in user is " + userInfo.getUserName() + " NOT GOOD :(");
            throw new SecurityException(
                    "User " + userInfo.getUserName()
                            + " is not allowed access to method "
                            + method.getName()
            );
        }
    }
}
