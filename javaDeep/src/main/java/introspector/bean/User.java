package introspector.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.Date;
import java.util.Objects;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-14 16:06
 */
public class User {

    private String username;

    private Integer age;

    private Date createTime;

    /**
     * 属性（生效）变化监听器管理器
     */
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * 属性（否决）变化监听器
     */
    private VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

    /**
     * 启动属性（否决）变化
     * @param propertyName
     * @param oldValue
     * @param newValue
     */
    private void fireVetoableChange(String propertyName, String oldValue, String newValue) throws PropertyVetoException {
        PropertyChangeEvent event = new PropertyChangeEvent(this, propertyName, oldValue, newValue);
        vetoableChangeSupport.fireVetoableChange(event);
    }

    /**
     * 添加属性（否决）变化监听器
     */
    public void addVetoableChangeListener(VetoableChangeListener listener){
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }

    /**
     * 删除属性（否决）变化监听器
     */
    public void removeVetoableChangeListener(VetoableChangeListener listener){
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }

    public void setUsername(String username) throws PropertyVetoException {
        String oldValue = this.username;
        fireVetoableChange("username",oldValue,username);
        this.username = username;
        firePropertyChange("username", oldValue, username);
    }

    /**
     * 启动属性（生效）变化
     * @param propertyName
     * @param oldValue
     * @param newValue
     */
    private void firePropertyChange(String propertyName, String oldValue, String newValue) {
        PropertyChangeEvent event = new PropertyChangeEvent(this, propertyName, oldValue, newValue);
        propertyChangeSupport.firePropertyChange(event);
    }

    /**
     * 添加属性（生效）变化监听器
     */
    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * 删除属性（生效）变化监听器
     */
    public void removePropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * 获取属性（生效）变化监听器
     */
    /*public PropertyChangeListener[] getPropertyChangeListeners() {
        return propertyChangeSupport.getPropertyChangeListeners();
    }*/

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", createTime=" + createTime.toLocaleString() +
                '}';
    }


}
