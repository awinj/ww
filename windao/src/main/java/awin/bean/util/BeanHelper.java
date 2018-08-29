package awin.bean.util;

import awin.bean.IORM;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**java bean 工具类，获取java bean的属性以及getter,setter，并缓存到内存中
 * Created by aWin on 2018-08-09.
 */
public class BeanHelper {

    private static final Object[] NULL_ARGUMENTS = new Object[0];

    private static Map<String, ReflectionInfo> cache = new HashMap<String, ReflectionInfo>();//缓存  classname,fields
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();


    private static BeanHelper bhelp = new BeanHelper();

    //将构造函数私有化，保证除反射只能通过getInstance()返回实例。
    private BeanHelper(){}


    /**
     * 单例
     * @return 返回全局唯一实例
     */
    public static BeanHelper getInstance() {
        return bhelp;
    }

    private Method getMethod(Object bean, String propertyName, boolean isSetMethod) {
        Method method;
        this.rwl.readLock().lock();
        ReflectionInfo reflectionInfo;
        try {
            reflectionInfo = cachedReflectionInfo(bean.getClass());
            if (isSetMethod)
                method = reflectionInfo.getWriteMethod(propertyName);
            else {
                method = reflectionInfo.getReadMethod(propertyName);
            }
            return method;
        } finally {
            this.rwl.readLock().unlock();
        }
    }

    public static List<String> getPropertys(Object bean) {
        return Arrays.asList(getInstance().getPropertiesAry(bean));
    }

    /**
     *
     * @param bean bean实例
     * @return 返回bean的所有可写属性
     */
    public String[] getPropertiesAry(Object bean) {
        ReflectionInfo reflectionInfo ;
        this.rwl.readLock().lock();
        try {
            reflectionInfo = cachedReflectionInfo(bean.getClass());
            Set<String> propertys = new HashSet<String>();
            for (String key : reflectionInfo.writeMap.keySet()) {
                if (reflectionInfo.writeMap.get(key) != null) {
                    propertys.add(key.toLowerCase());
                }
            }
            return  propertys.toArray(new String[0]);
        } finally {
            this.rwl.readLock().unlock();
        }
    }

    public static Object getProperty(Object bean, String propertyName) {
        try {
            Method method = getInstance().getMethod(bean, propertyName, false);
            if ((propertyName != null) && (method == null))
                return null;
            if (method == null) {
                return null;
            }
            return method.invoke(bean, NULL_ARGUMENTS);
        } catch (Exception e) {
            String errStr = "Failed to get property: " + propertyName;

            throw new RuntimeException(errStr, e);
        }
    }

    public static Method getMethod(Object bean, String propertyName) {
        return getInstance().getMethod(bean, propertyName, true);
    }

    public static void invokeMethod(Object bean, Method method, Object value) {
        try {
            if (method == null)
                return;
            Object[] arguments = {value};
            method.invoke(bean, arguments);
        } catch (Exception e) {
            String errStr = "Failed to set property: " + method.getName();
            throw new RuntimeException(errStr, e);
        }
    }

    public static void setProperty(Object bean, String propertyName, Object value) {
        try {
            Method method = getInstance().getMethod(bean, propertyName, true);
            if ((propertyName != null) && (method == null)) {
                return;
            }
            if (method == null) {
                return;
            }
            Object[] arguments = {value};
            method.invoke(bean, arguments);
        } catch (Exception e) {
            String errStr = "Failed to set property: " + propertyName + " on bean: " + bean.getClass().getName() + " with value:" + value;

            throw new RuntimeException(errStr, e);
        }
    }

    public Method[] getAllGetMethod(Class<?> beanCls, String[] fieldNames) {
        Method[] methods;
        ReflectionInfo reflectionInfo = null;
        List<Method> al = new ArrayList<Method>();
        this.rwl.readLock().lock();
        try {
            reflectionInfo = cachedReflectionInfo(beanCls);
        } finally {
            this.rwl.readLock().unlock();
        }
        for (String str : fieldNames) {
            al.add(reflectionInfo.getReadMethod(str));
        }
        methods =  al.toArray(new Method[al.size()]);
        return methods;
    }

    private List<PropDescriptor> getPropertyDescriptors(Class<?> clazz) {
        List<PropDescriptor> descList = new ArrayList<PropDescriptor>();
        List<PropDescriptor> superDescList ;
        List<String> propsList = new ArrayList<String>();
        Class propType ;
        for (Method method : clazz.getDeclaredMethods())
            if (method.getName().length() >= 4) {
                if ((method.getName().charAt(3) >= 'A') && (method.getName().charAt(3) <= 'Z')) {
                    if (method.getName().startsWith("set")) {
                        if (method.getParameterTypes().length != 1) {
                            continue;
                        }
                        if (method.getReturnType() != Void.TYPE) {
                            continue;
                        }
                        propType = method.getParameterTypes()[0];
                    } else {
                        if ((!method.getName().startsWith("get")) ||
                                (method.getParameterTypes().length != 0)) {
                            continue;
                        }
                        propType = method.getReturnType();
                    }

                    String propname = method.getName().substring(3, 4).toLowerCase();
                    if (method.getName().length() > 4) {
                        propname = propname + method.getName().substring(4);
                    }
                    if (!propname.equals("class")) {
                        if (!propsList.contains(propname)) {
                            propsList.add(propname);

                            descList.add(new PropDescriptor(clazz, propType, propname));
                        }
                    }
                }
            }
        Class superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            superDescList = getPropertyDescriptors(superClazz);
            descList.addAll(superDescList);
            if (!isBeanCached(superClazz)) {
                cacheReflectionInfo(superClazz, superDescList);
            }
        }
        return descList;
    }

    private ReflectionInfo cachedReflectionInfo(Class<?> beanCls) {
        return cacheReflectionInfo(beanCls, null);
    }

    private ReflectionInfo cacheReflectionInfo(Class<?> beanCls, List<PropDescriptor> pdescriptor) {
        String key = beanCls.getName();
        ReflectionInfo reflectionInfo = cache.get(key);
        if (reflectionInfo == null) {
            this.rwl.readLock().unlock();
            this.rwl.writeLock().lock();
            this.rwl.readLock().lock();
            try {
                reflectionInfo =  cache.get(key);
                if (reflectionInfo == null) {
                    reflectionInfo = new ReflectionInfo();
                    List<PropDescriptor> propDesc = new ArrayList<PropDescriptor>();
                    if (pdescriptor != null)
                        propDesc.addAll(pdescriptor);
                    else {
                        propDesc = getPropertyDescriptors(beanCls);
                    }
                    for (PropDescriptor pd : propDesc) {
                        Method readMethod = pd.getReadMethod(beanCls);
                        Method writeMethod = pd.getWriteMethod(beanCls);
                        if (readMethod != null) {
                            reflectionInfo.readMap.put(pd.getName().toLowerCase(), readMethod);
                        }

                        if (writeMethod != null) {
                            reflectionInfo.writeMap.put(pd.getName().toLowerCase(), writeMethod);
                        }
                    }
                    cache.put(key, reflectionInfo);
                }
            } finally {
                this.rwl.writeLock().unlock();
            }
        }
        return reflectionInfo;
    }

    private boolean isBeanCached(Class<?> bean) {
        String key = bean.getName();
        ReflectionInfo cMethod =  cache.get(key);
        if (cMethod == null) {
            this.rwl.readLock().lock();
            try {
                cMethod =  cache.get(key);
                if (cMethod == null)
                    return false;
            } finally {
                this.rwl.readLock().unlock();
            }
        }
        return true;
    }

    public static <T extends IORM> T createBean(Class<T> c)
    {
        try {
            return c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    private class ReflectionInfo {
       private Map<String, Method> readMap = new HashMap<String, Method>();

        private Map<String, Method> writeMap = new HashMap<String, Method>();


        Method getReadMethod(String prop) {
            return prop == null ? null : this.readMap.get(prop.toLowerCase());
        }

        Method getWriteMethod(String prop) {
            return prop == null ? null :  this.writeMap.get(prop.toLowerCase());
        }


    }

}
