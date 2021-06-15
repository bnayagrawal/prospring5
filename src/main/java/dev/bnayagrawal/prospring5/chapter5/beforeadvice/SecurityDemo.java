package dev.bnayagrawal.prospring5.chapter5.beforeadvice;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();

        SecureBean bean = getSecureBean();

        manager.login("John", "pwd");
        bean.writeSecureMessage();
        manager.logout();

        try {
            manager.login("Invalid user", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            manager.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);

        return (SecureBean) proxyFactory.getProxy();
    }

}
