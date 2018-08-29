//package awin.bean.util;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//import awin.bean.SuperVO;
//import awin.dao.exception.BeanReflectException;
//
//public class BeanUtil {
//
//	private Object vo;
//	private String[] fieldNames;
//	private Object[] values;
//
//
//
//	private BeanUtil(Object vo) throws BeanReflectException
//	{
//		this.vo=vo;
//		init();
//	}
//
//	public static BeanUtil getInstance(Object vo) throws BeanReflectException
//	{
//		return new BeanUtil(vo);
//	}
//
//	private void init() throws BeanReflectException
//	{
//		try {
//			Class<?> c = vo.getClass();
//			Field[] field = c.getDeclaredFields();
//			if (field != null && field.length > 0) {
//				fieldNames = new String[field.length];
//				values = new Object[field.length];
//				for (int i = 0; i < field.length; i++) {
//					fieldNames[i] = field[i].getName();
//					field[i].setAccessible(true);
//					values[i] = field[i].get(vo);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new BeanReflectException(e.getMessage(),e);
//		}
//	}
//
//
//	public String[] getFields()
//	{
//		return fieldNames;
//	}
//
//	public Object[] getValues()
//	{
//		return values;
//	}
//
//	public Object getRetObj()
//	{
//		return vo;
//	}
//}
