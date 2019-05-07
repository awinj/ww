package awin.base.pager;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by aWin on 2019-05-06.
 *
 * @Description:
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PagerInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取StatementHandler，默认是RoutingStatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获取statementHandler包装类
        MetaObject metaObjectHandler = SystemMetaObject.forObject(statementHandler);

        //分离代理对象链
        while (metaObjectHandler.hasGetter("h")) {
            Object obj = metaObjectHandler.getValue("h");
            metaObjectHandler = SystemMetaObject.forObject(obj);
        }

        while (metaObjectHandler.hasGetter("target")) {
            Object obj = metaObjectHandler.getValue("target");
            metaObjectHandler = SystemMetaObject.forObject(obj);
        }

        //获取连接对象
        //Connection connection = (Connection) invocation.getArgs()[0];


        //object.getValue("delegate");  获取StatementHandler的实现类

        //获取查询接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) metaObjectHandler.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();

        //statementHandler.getBoundSql().getParameterObject();

        //拦截以.ByPage结尾的请求，分页功能的统一实现
        if (mapId.matches(".+queryByPager")) {
            //获取进行数据库操作时管理参数的handler
            ParameterHandler parameterHandler = (ParameterHandler) metaObjectHandler.getValue("delegate.parameterHandler");
            //获取请求时的参数
            Map<String, Object> paraObject = (Map<String, Object>) parameterHandler.getParameterObject();
            //也可以这样获取
            //paraObject = (Map<String, Object>) statementHandler.getBoundSql().getParameterObject();

            Pager pager = null;
            //参数名称和在service中设置到map中的名称一致
            for (Object arg : paraObject.values()) {
                if (arg instanceof Pager) {
                    pager = (Pager) arg;
                }
            }
            pager=pager==null?new Pager():pager;
            String sql = (String) metaObjectHandler.getValue("delegate.boundSql.sql");
            //也可以通过statementHandler直接获取
            //sql = statementHandler.getBoundSql().getSql();

            //构建分页功能的sql语句
            StringBuilder pagerSql = new StringBuilder("SELECT * FROM (SELECT PAGER.*, ROWNUM RN FROM ( ");
            pagerSql.append(sql);

            int max = pager.getPageIndex() * pager.getPageSize();
            int min = pager.getPageIndex() * pager.getPageSize() - pager.getPageSize();

            pagerSql.append(" ) PAGER WHERE ROWNUM <= " + max + ") WHERE RN >= " + min);

            //将构建完成的分页sql语句赋值个体'delegate.boundSql.sql'，偷天换日
            metaObjectHandler.setValue("delegate.boundSql.sql", pagerSql.toString());
        }
        //调用原对象的方法，进入责任链的下一级
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
