package dev.bnayagrawal.prospring5.chapter3.injectingclxn;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.Resource;

@Service("aInjectCollection")
public class ACollectionInjection {

    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter3/injectingclxn/app-content-annotation.xml");
        context.refresh();

        ACollectionInjection instance = (ACollectionInjection) context.getBean("aInjectCollection");
        System.out.println(instance);
        context.close();
    }

    @Override
    public String toString() {
        return "ACollectionInjection{" +
                "map=" + map +
                ", props=" + props +
                ", set=" + set +
                ", list=" + list +
                '}';
    }
}
