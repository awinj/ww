package awin.bean;

import awin.bean.util.BeanHelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by aWin on 2018-08-09.
 */
public abstract class ValueObject implements IORM {
    private static transient Map<Class, String[]> map = new HashMap();

    private static transient ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();



    public Object getAttrValue(String attributeName)
    {
        if ((attributeName == null) || (attributeName.length() == 0))
            return null;
//		if ((getPrimaryKey() != null) && (attributeName.equals(getPrimaryKey())))
//			attributeName = "primarykey";
        return BeanHelper.getProperty(this, attributeName);
    }
    public void setAttrValue(String attributeName,Object val)
    {
        if ((attributeName == null) || (attributeName.length() == 0))
            return;
//		if ((getPKFieldName() != null) && (attributeName.equals(getPKFieldName())))
//			attributeName = "primarykey";
        BeanHelper.setProperty(this, attributeName, val);
    }

    public String[] getAttrNames()
    {
        rwl.readLock().lock();
        try {
            return getAttributeAry();
        } finally {
            rwl.readLock().unlock();
        }
    }

    private String[] getAttributeAry() {
        String[] arys = (String[])map.get(getClass());
        if (arys == null) {
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                arys = (String[])map.get(getClass());
                if (arys == null)
                {
                    Set set = new HashSet();
                    String[] strAry = BeanHelper.getInstance().getPropertiesAry(this);

                    for (String str : strAry)
                        if ((getPrimaryKey() != null) && (str.equals("primarykey")))
                        {
                            set.add(getPrimaryKey());
                        } else if ((!str.equals("status")) && (!str.equals("dirty")))
                        {
                            set.add(str);
                        }
                    arys = (String[])set.toArray(new String[set.size()]);
                    map.put(getClass(), arys);
                }
            } finally {
                rwl.readLock().lock();
                rwl.writeLock().unlock();
            }
        }
        return arys;
    }

    public Object[] getAttrValues()
    {
        String[] attrs=getAttrNames();
        Object[] vals=new Object[attrs.length];
        for(int i=0;i<attrs.length;i++)
        {
            vals[i]=getAttrValue(attrs[i]);
        }
        return vals;
    }

    public Object clone()
    {
        ValueObject vo = null;
        try {
            vo = getClass().newInstance();
        }
        catch (Exception e) {
        }
        String[] fieldNames = getAttrNames();
        if (fieldNames != null) {
            for (int i = 0; i < fieldNames.length; i++) {
                try {
                    vo.setAttrValue(fieldNames[i], getAttrValue(fieldNames[i]));
                }
                catch (Exception ex)
                {
                }
            }
        }
        return vo;
    }

}
