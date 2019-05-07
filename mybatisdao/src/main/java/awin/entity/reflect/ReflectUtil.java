package awin.entity.reflect;


import awin.orm.annotations.Column;
import awin.orm.annotations.NotMapping;
import awin.orm.annotations.PrimaryKey;
import awin.orm.annotations.Table;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by aWin on 2019-05-06.
 *
 * @Description:
 */
public class ReflectUtil {


    private static Map<String, EntityInfo> cache = new HashMap<String, EntityInfo>();//缓存  classname,fields
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private static ReflectUtil instance = new ReflectUtil();

    private ReflectUtil() {
    }

    public static ReflectUtil getInstance() {
        return instance;
    }


    private List<Field> getAllField(Class clss) {
        List<Field> allFields = new ArrayList<Field>();
        Field[] fields = clss.getDeclaredFields();
        if (fields != null)
            allFields.addAll(Arrays.asList(fields));
        if (clss.getSuperclass() != null) {
            List<Field> superFields = getAllField(clss.getSuperclass());
            if (superFields != null)
                allFields.addAll(superFields);
        }
        return allFields;
    }


    public EntityInfo getEntityInfo(Class clss) {
        rwl.readLock().lock();
        EntityInfo entityInfo;
        try {
            if (cache.get(clss.getName()) == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                rwl.readLock().lock();
                entityInfo = cacheEntityInfo(clss);
                rwl.writeLock().unlock();
            } else {
                entityInfo = cache.get(clss.getName());
            }

        } finally {
            rwl.readLock().unlock();
        }


        return entityInfo;
    }


    private EntityInfo cacheEntityInfo(Class clss) {


        EntityInfo entityInfo = new EntityInfo();

        Table table = (Table) clss.getAnnotation(Table.class);
        if (table == null || table.tableName() == null)
            entityInfo.setTableName(clss.getSimpleName());
        else
            entityInfo.setTableName(table.tableName());

        List<Field> fields = getAllField(clss);
        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            Column column = field.getAnnotation(Column.class);
            NotMapping notMapping = field.getAnnotation(NotMapping.class);
            //没有标记为不映射
            if (notMapping == null) {

                String columnName = field.getName();
                //标记了column
                if (column != null && column.columnName() != null) {
                    columnName = column.columnName();
                }

                //标记了主键
                if (primaryKey != null) {
                    entityInfo.setPrimaryKey(columnName);
                }
                //标记了column
                entityInfo.put(columnName, field.getName());

            }
        }
        cache.put(clss.getName(), entityInfo);
        return entityInfo;
    }


}
