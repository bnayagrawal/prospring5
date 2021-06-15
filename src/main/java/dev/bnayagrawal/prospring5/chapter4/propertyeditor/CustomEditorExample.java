package dev.bnayagrawal.prospring5.chapter4.propertyeditor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomEditorExample {
    private FullName fullName;

    public FullName getName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter4/propertyeditor/app-context-02-xml.xml");
        ctx.refresh();

        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
        ctx.close();
    }
}
