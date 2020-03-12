package com.ioc.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {
  // ioc 是保存对象的映射，能根据字符串id确定的对象
  private Map<String, Object> ioc = new HashMap<String, Object>();

  public ClassPathXmlApplicationContext(String path) {
    try {
      // 读取xml文件
      SAXReader reader = new SAXReader();
      Document document = reader.read(path);
      Element root = document.getRootElement();
      Iterator<Element> iterator = root.elementIterator();

      // 迭代获得的bean元素
      while (iterator.hasNext()) {
        Element element = iterator.next();

        // 元素id 和 类名
        String id = element.attributeValue("id");
        String className = element.attributeValue("class");
        //通过反射机制创建对象
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        Iterator<Element> beanIter = element.elementIterator();

        // 迭代bean内单一对象的元素
        while (beanIter.hasNext()) {
          Element property = beanIter.next();

          // 属性名和属性值
          String name = property.attributeValue("name");
          String valueStr = property.attributeValue("value");
          String ref = property.attributeValue("ref");

          // 获取并格式化方法名称以及调用的参数
          String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
          Field field = clazz.getDeclaredField(name);
          Method method = clazz.getMethod(methodName, field.getType());
          if (ref == null) {
            Object value = null;
            if (field.getType().getName().equals("long")) {
              value = Long.parseLong(valueStr);
            }
            if (field.getType().getName().equals("java.lang.String")) {
              value = valueStr;
            }
            if (field.getType().getName().equals("int")) {
              value = Integer.parseInt(valueStr);
            }
            method.invoke(object, value);
          }
          ioc.put(id, object);
        }

      }
//            Object obj1 = ioc.get("address");
//            Object obj2 = ioc.get("student");
//
//            System.out.println(obj1);
//            System.out.println(obj2);

    } catch (DocumentException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
  }

  public Object getBean(String id) {
    return ioc.get(id);
  }
}
