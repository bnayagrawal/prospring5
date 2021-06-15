package dev.bnayagrawal.prospring5.chapter3.injectingclxn;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {

    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter3/injectingclxn/app-content-xml.xml");
        context.refresh();

        CollectionInjection instance = (CollectionInjection) context.getBean("injectCollection");
        System.out.println(instance);
        context.close();
    }

    @Override
    public String toString() {
        return "CollectionInjection{" +
                "map=" + map +
                ", props=" + props +
                ", set=" + set +
                ", list=" + list +
                '}';
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
