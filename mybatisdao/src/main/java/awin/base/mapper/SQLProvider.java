package awin.base.mapper;

import awin.base.pager.Pager;
import awin.entity.reflect.EntityInfo;
import awin.entity.reflect.ReflectUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.reflection.TypeParameterResolver;

import java.lang.reflect.*;
import java.util.Map;

/**
 * Created by aWin on 2019-03-29.
 *
 * @Description:
 */
public class SQLProvider {

    public String queryByPk(ProviderContext context) {
        Method method = context.getMapperMethod();
        Type returnType = TypeParameterResolver.resolveReturnType(method, context.getMapperType());
        EntityInfo entityInfo = ReflectUtil.getInstance().getEntityInfo((Class) returnType);
        String tableName = entityInfo.getTableName();
        SQL sql = new SQL();
        sql.SELECT(entityInfo.getSelectStr());
        sql.FROM(tableName);
        sql.WHERE(entityInfo.getPrimaryKey() + "=#{pk,jdbcType=CHAR}");
        return sql.toString();
    }

    public String queryByPager(@Param("condition") Map<String, Object> condition, Pager pager, ProviderContext context) {
        Method method = context.getMapperMethod();
        Type returnType = TypeParameterResolver.resolveReturnType(method, context.getMapperType());
        if (returnType instanceof ParameterizedType) {
            returnType = ((ParameterizedType) returnType).getActualTypeArguments()[0];
        }
        EntityInfo entityInfo = ReflectUtil.getInstance().getEntityInfo((Class) returnType);
        String tableName = entityInfo.getTableName();
        SQL sql = new SQL();
        sql.SELECT(entityInfo.getSelectStr());
        sql.FROM(tableName);
        for (String key : condition.keySet()) {
            if (condition.get(key) != null) {
                sql.WHERE(key + "=#{condition." + key + "}");
            }
        }
        return sql.toString();
    }


    public String insert(ProviderContext context) {
        Method method = context.getMapperMethod();
        Type returnType = TypeParameterResolver.resolveReturnType(method, context.getMapperType());
        EntityInfo entityInfo = ReflectUtil.getInstance().getEntityInfo((Class) returnType);
        String tableName = entityInfo.getTableName();
        SQL sql = new SQL();
        sql.INSERT_INTO(tableName);
        sql.INTO_COLUMNS(entityInfo.getIntoColumns());
        sql.INTO_VALUES(entityInfo.getIntoValues());
        return sql.toString();
    }

    public String insertArrs(ProviderContext context) {
        Method method = context.getMapperMethod();
        Type returnType = TypeParameterResolver.resolveReturnType(method, context.getMapperType());
        EntityInfo entityInfo = ReflectUtil.getInstance().getEntityInfo((Class) returnType);
        String tableName = entityInfo.getTableName();
        StringBuffer sql = new StringBuffer();
        sql.append("insert into ").append(tableName);
        sql.append(" (" + combine(entityInfo.getIntoColumns(), ",") + ")");
        sql.append(" values ");
        sql.append(" <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\"> ");
        sql.append(" (" + combine(entityInfo.getIntoValues(), ",") + ")");
        sql.append("</foreach> \n");
        return sql.toString();
    }


    public String update(ProviderContext context) {
        Method method = context.getMapperMethod();
        Type returnType = TypeParameterResolver.resolveReturnType(method, context.getMapperType());
        EntityInfo entityInfo = ReflectUtil.getInstance().getEntityInfo((Class) returnType);
        String tableName = entityInfo.getTableName();
        SQL sql = new SQL();
        sql.UPDATE(tableName);
        sql.SET(entityInfo.getSetKeyVal());
        sql.WHERE(entityInfo.getPrimaryKey() + "=#{" + entityInfo.getPrimaryKey() + ",jdbcType=CHAR}");
        return sql.toString();
    }


    public String delete(ProviderContext context) {
        Method method = context.getMapperMethod();
        Class mapperClass = context.getMapperType();
        Class declareClass = method.getDeclaringClass();
        Type paraType = awin.base.mapper.TypeParameterResolver.resolveType(declareClass.getTypeParameters()[0],
                mapperClass, declareClass);
        EntityInfo entityInfo = ReflectUtil.getInstance().getEntityInfo((Class) paraType);
        String tableName = entityInfo.getTableName();

        SQL sql = new SQL();
        sql.DELETE_FROM(tableName);
        sql.WHERE(entityInfo.getPrimaryKey() + "=#{" + entityInfo.getPrimaryKey() + ",jdbcType=CHAR}");
        return sql.toString();
    }

    public String deleteArrs(ProviderContext context) {
        Method method = context.getMapperMethod();
        Class mapperClass = context.getMapperType();
        Class declareClass = method.getDeclaringClass();
        Type paraType = awin.base.mapper.TypeParameterResolver.resolveType(declareClass.getTypeParameters()[0],
                mapperClass, declareClass);
        EntityInfo entityInfo = ReflectUtil.getInstance().getEntityInfo((Class) paraType);
        String tableName = entityInfo.getTableName();

        StringBuffer sql = new StringBuffer();
        sql.append("insert into ").append(tableName);
        sql.append(" (" + combine(entityInfo.getIntoColumns(), ",") + ")");
        sql.append(" values ");
        sql.append(" <foreach collection=\"list\" item=\"item\"  open=\"(\"  close=\")\" separator=\",\"> ");
        sql.append(" #{item} ");
        sql.append("</foreach> \n");
        return sql.toString();
    }


    private String combine(String[] strs, String separator) {
        if (strs == null)
            return null;
        separator = separator == null ? " " : separator;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i] + separator);
        }
        sb.deleteCharAt(sb.length() - separator.length());
        return sb.toString();
    }
}
