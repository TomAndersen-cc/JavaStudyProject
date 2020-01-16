package SpringDemo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author TomAndersen
 * @Date 2020/1/16
 * @Version
 * @Description
 */
public class BeanFactory {
    private Map<String, Object> beanMap = new HashMap<>();

    public void init(String fileName) {
        try {
            // 读取指定的配置文件
            SAXReader reader = new SAXReader();
            // System.out.println(xmlpath);
            String realPathString = new File("").getCanonicalPath();
//            String realPathString = "C:/Users/DELL/Desktop/ProjectTest1/JavaStudyProject/src/SpringDemo";
            Document document = reader.read(realPathString + "/src/SpringDemo" + new File(fileName));
            Element root = document.getRootElement();
            Element foo;
            // 遍历bean
            for (Iterator i = root.elementIterator("bean"); i.hasNext(); ) {
                foo = (Element) i.next();
                // 获取bean的属性id和class
                Attribute id = foo.attribute("id");
                Attribute cls = foo.attribute("class");
                // 利用Java反射机制，通过class的名称获取Class对象
                Class bean = Class.forName(cls.getText());
                // 获取对应class的信息
                java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
                // 获取其属性描述
                java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
                // 设置值的方法
                Method mSet = null;
                // 创建一个对象
                Object obj = bean.newInstance();
                // 遍历该bean的property属性
                for (Iterator ite = foo.elementIterator("property"); ite.hasNext(); ) {
                    Element foo2 = (Element) ite.next();
                    // 获取该property的name属性
                    Attribute name = foo2.attribute("name");
                    String value = null;
                    // 获取该property的子元素value的值
                    for (Iterator ite1 = foo2.elementIterator("value"); ite1.hasNext(); ) {
                        Element node = (Element) ite1.next();
                        value = node.getText();
                        break;
                    }
                    for (int k = 0; k < pd.length; k++) {
                        if (pd[k].getName().equalsIgnoreCase(name.getText())) {
                            mSet = pd[k].getWriteMethod();
                            mSet.invoke(obj, value);
                        }
                    }
                }

                // 将对象放入beanMap中，其中key为id值，value为对象
                beanMap.put(id.getText(), obj);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // 通过bean的id获取bean的对象.
    public Object getBean(String beanName) {
        Object obj = beanMap.get(beanName);
        return obj;
    }
}
