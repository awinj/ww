package awin.util.date;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * 日期、时间工具类
 * @author wsw
 *
 */
public class DateUtil {


    public DateUtil() {

    }

    /**
     * 获得当前的年份
     * @return YY形式的当前年份
     */
    public  static String getCurrentYear() {
    	return ((Calendar.getInstance().get(Calendar.YEAR))+"").substring(2,4);
    }
    
    /**
     * 获得当前的年份
     * @return YYYY形式的当前年份
     */
    public  static String getYear() {
    	return Calendar.getInstance().get(Calendar.YEAR)+"";
    }

    /**
     * 获得当前的月份
     * @return mm形式的当前月份
     */
    public  static String getCurrentMonth() {
        int month = Calendar.getInstance().get(Calendar.MONTH)+1;
        return month>=10?month+"":"0"+month+"";
    }

    /**
     * 获得当前的日期
     * @return dd形式的当前日期
     */
    public  static String getCurrentDate() {
    	int data=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		return data>=10?data+"":"0"+data+"";
    }

    /**
     * 获得当前的小时
     * @return hh形式的当前小时,24小时制
     */
    public  static String getCurrentHours() {
    	int data=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		return data>=10?data+"":"0"+data+"";
    }

    /**
     * 获得当前的分钟
     * @return mm形式的当前分钟
     */
    public  static String getCurrentMinutes() {
    	int data=Calendar.getInstance().get(Calendar.MINUTE);
		return data>=10?data+"":"0"+data+"";
    }

    /**
     * 获得当前的秒钟
     * @return ss形式的当前秒钟
     */
    public  static String getCurrentSeconds() {
    	int data=Calendar.getInstance().get(Calendar.SECOND);
		return data>=10?data+"":"0"+data+"";
    }  
    /**
    *@ Description: 求某一天的是星期几
    *@ 
    *@ in 日期字符串YYYY-MM-DD
    *@ out 星期几
    */
	public static int getDayOfWeek(String dt){
		
		Calendar cal = Calendar.getInstance();
   		StringTokenizer st = new StringTokenizer(dt,"-");
   		int count = st.countTokens();
   		
   		if(count==3){
   			int year = Integer.parseInt(st.nextToken());
   			int month = Integer.parseInt(st.nextToken())-1;
   			int date = Integer.parseInt(st.nextToken());
   			cal.set(year,month,date);
   		return cal.get(Calendar.DAY_OF_WEEK)-1==0?7:cal.get(Calendar.DAY_OF_WEEK)-1;
   		}
   		else return 0;
   	}
    
	/**
	 * YYYY-MM-DD hi:mm:ss
	 * @return
	 */
	public static  String getCurrentTime() {
		
		return getYear()+"-"+getCurrentMonth()+"-"+getCurrentDate()+" "+getCurrentHours()+":"+getCurrentMinutes()+":"+getCurrentSeconds();
	}
	
	/**
	 * YYYYMMDDhimmss
	 * @return
	 */
	public static  String getCurrentTime2() {
		
		return getYear()+getCurrentMonth()+getCurrentDate()+getCurrentHours()+getCurrentMinutes()+getCurrentSeconds();
	}
}
