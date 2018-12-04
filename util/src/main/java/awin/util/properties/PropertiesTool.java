package awin.util.properties;

import awin.logger.Logger;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * author:awin
 * 关于Properties类常用的操作
 */
public class PropertiesTool {
	// 根据Key读取Value
	public static String GetValueByKey(String filePath, String key) {
		Properties pps = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));

			pps.load(in);
			String value = pps.getProperty(key);
			return value;

		} catch (IOException e) {
			Logger.Error(e.getMessage(),e);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					Logger.Error(e.getMessage(),e);
				}
		}
		return null;

	}

	// 读取Properties的全部信息
	public static Map<String, String> GetAllProperties(String filePath) {
		Properties pps = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		InputStream in = null;

		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			pps.load(in);
			Enumeration en = pps.propertyNames(); // 得到配置文件的名字
			while (en.hasMoreElements()) {
				String strKey = (String) en.nextElement();
				String strValue = pps.getProperty(strKey);
				map.put(strKey, strValue);
			}
		} catch (Exception e) {
			Logger.Error(e.getMessage(),e);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					Logger.Error(e.getMessage(),e);
				}
		}
		return map;

	}

	// 写入Properties信息
	public static void WriteProperties(String filePath, String pKey,
			String pValue) throws Exception {
		File exportFile = new File(filePath);
		if (!exportFile.exists())
			exportFile.createNewFile();

		Properties pps = new Properties();

		InputStream in = new  BufferedInputStream(new FileInputStream(filePath));
		OutputStream out =null;
		try {
			// 从输入流中读取属性列表（键和元素对）
			pps.load(in);
			out= new FileOutputStream(filePath);
			pps.setProperty(pKey, pValue);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			pps.store(out, "Update " + pKey + " name");
		} catch (Exception e) {
			throw e;
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}

	}

	public static void main(String[] args) throws Exception {
		String value = GetValueByKey("Test.properties", "long1");
		 System.out.println(value);
		WriteProperties("Test.properties", "long2", "211");
		
	}
}
