package introspector.test;

import com.google.common.collect.ImmutableMap;
import introspector.DatPropertyEditor;
import introspector.bean.User;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-14 16:09
 */
public class IntrospectorTest {

    @Test
    public void test1() throws IntrospectionException {
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class, Object.class);
        EventSetDescriptor[] eventSetDescriptors = userBeanInfo.getEventSetDescriptors();
        Stream.of(eventSetDescriptors).forEach(System.out::println);
    }

    @Test
    public void test2() throws IntrospectionException {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        String path = "user.";
        Properties properties = yaml.getObject();
        System.out.println(properties);
        User user = new User();
        //获取 User Bean 信息，排除 Object
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class, Object.class);
        //属性描述
        PropertyDescriptor[] propertyDescriptors = userBeanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            //获取属性名称
            String property = propertyDescriptor.getName();
            setPropertyValue(user, propertyDescriptor, properties.get(path + property));
        });
        System.out.println(user);
    }

    @Test
    public void test3() throws PropertyVetoException {
        User user = new User();
        user.setAge(1);
        user.addVetoableChangeListener(evt -> {
            System.out.println(evt.getNewValue() + ",," + evt.getOldValue());
            if (Objects.isNull(evt.getNewValue())) {
                throw new PropertyVetoException("username 不能为null", evt);
            }
        });
        user.addPropertyChangeListener(System.out::println);
        user.setUsername("lisi");
        user.setUsername(null);
    }

    @Test
    public void test4() throws PropertyVetoException {
        User user = new User();
        user.setAge(1);
        user.addPropertyChangeListener(System.out::println);
        user.setUsername("zhangsan");
        user.setUsername("lisi");
        user.setUsername("wangwu");
    }

    @Test
    public void test5() {
        User user = new User();
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("username", "zhangsan");
        pvs.add("age", 1);
        bw.setPropertyValues(pvs);
        System.out.println(user);
    }


    @Test
    public void test6() throws IntrospectionException, FileNotFoundException {
       Map<String,Object> properties = ImmutableMap.of("age",1,"username","zhangsan","createTime","2020-01-01");
        User user = new User();
        //获取 User Bean 信息，排除 Object
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class, Object.class);
        //属性描述
        PropertyDescriptor[] propertyDescriptors = userBeanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            //获取属性名称
            String property = propertyDescriptor.getName();
            //值
            Object value = properties.get(property);
            if (Objects.equals("createTime", property)) {
                //设置属性编辑器
                propertyDescriptor.setPropertyEditorClass(DatPropertyEditor.class);
                //创建属性编辑器
                PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(user);
                //添加监听器
                propertyEditor.addPropertyChangeListener(evt -> {
                    //获取转换后的value
                    Object value1 = propertyEditor.getValue();
                    setPropertyValue(user, propertyDescriptor, value1);
                });
                propertyEditor.setAsText(String.valueOf(value));
                return;
            }
            setPropertyValue(user, propertyDescriptor, value);
        });
        System.out.println(user);
    }

    /**
     * 设置属性值
     * @param user
     * @param propertyDescriptor
     * @param value1
     */
    private void setPropertyValue(User user, PropertyDescriptor propertyDescriptor, Object value1) {
        try {
            propertyDescriptor.getWriteMethod().invoke(user, value1);
        } catch (IllegalAccessException | InvocationTargetException ignored) {
        }
    }




}
