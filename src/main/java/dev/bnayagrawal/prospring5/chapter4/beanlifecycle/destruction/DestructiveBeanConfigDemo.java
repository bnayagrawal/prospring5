package dev.bnayagrawal.prospring5.chapter4.beanlifecycle.destruction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class DestructiveBeanConfigDemo {

    @Configuration
    static class DestructiveBeanConfig {

        @Lazy
        @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destroy")
        DestroyingBeanWithJSR250 destroyingBean() {
            DestroyingBeanWithJSR250 destructiveBean = new DestroyingBeanWithJSR250();
            destructiveBean.setFilePath(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "test.txt");
            return  destructiveBean;
        }

    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DestructiveBeanConfig.class);
        ctx.getBean(DestroyingBeanWithJSR250.class);
        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Callled destroy()");
    }
}
