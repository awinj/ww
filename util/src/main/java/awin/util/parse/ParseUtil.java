package awin.util.parse;

/**
 * 基本数据类型转化工具
 * @author wsw
 *
 */
public class ParseUtil {

	/**
     *
	 * @param obj 要转化为字符串的对象
	 * @param defaultval  obj为空时，返回的字符串
	 * @return
	 */
	public static String parseString(Object obj,String defaultval)
	{
		if(obj==null)
		{
			return defaultval;
		}
		else
		{
			return obj.toString();
		}
	}
	/**
	 * 
	 * @param obj 要转化为字符串的对象
	 * @return 如果为null,则返回"";
	 */
	public static String parseString(Object obj)
	{
		return parseString(obj,"");
	}
	
	
	/**
	 * 
	 * @param obj 要转化为int的对象
	 * @param defaultval obj为空时或不能转化为int时，返回的值
	 * @return
	 */
	public static int parseInt(Object obj,int defaultval)
	{
		int ret=defaultval;
		if(obj!=null)
		{
			try
			{
				ret= Integer.parseInt(obj.toString());
			}
			catch(Exception e) {ret=defaultval;}
		}
		return ret;
	}
	/**
	 * 
	 * @param obj 要转化为int的对象
	 * @return obj为空时或不能转化为int时，返回0
	 */
	public static int parseInt(Object obj)
	{
		return parseInt(obj,0);
	}
	
	/**
	 * 
	 * @param obj 要转化为double的对象
	 * @param defaultval obj为空时或不能转化为double时，返回的值
	 * @return
	 */
	public static double parseDouble(Object obj,double defaultval)
	{
		double ret=defaultval;
		if(obj!=null)
		{
			try
			{
				ret= Double.parseDouble(obj.toString());
			}
			catch(Exception e) {ret=defaultval;}
		}
		return ret;
	}
	/**
	 * 
	 * @param obj 要转化为double的对象
	 * @return obj为空时或不能转化为double时，返回0
	 */
	public static double parseDouble(Object obj)
	{ 
		return parseDouble(obj,0);
	}
}
