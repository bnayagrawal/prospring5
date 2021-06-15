package dev.bnayagrawal.prospring5.chapter3.lkpmthdinjctn;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class ALookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter3/lkpmthdinjctn/app-context-annotation.xml");
        context.refresh();

        DemoBean abstractBean = context.getBean("aAbstractLookupBean", DemoBean.class);
        DemoBean standardBean = context.getBean("standardLookupBean", DemoBean.class);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);

        context.close();
    }

    private static void displayInfo(String beanName, DemoBean bean) {
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();

        System.out.println("" + beanName + ": Singer Instances the Same? " + (singer1 == singer2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for(int x = 0; x < 100000; x++) {
            bean.getMySinger().sing();
        }

        stopWatch.stop();

        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
