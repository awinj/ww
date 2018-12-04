package awin.util.parse;

import awin.logger.Logger;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;



/**
 * 将实体转化为xml字符串
 * @author wsw
 *
 */
public class BeanToXml {

	public static String EMPTYDATA="EMPTYDATA";

	public static String SERVER_GENERAL_ERROR_MESSAGE="SERVER_GENERAL_ERROR_MESSAGE";

	public static String toXmlString(Object obj)
	{
		JAXBContext context;
		StringWriter writer = new StringWriter();
		if(obj==null)
		{
			return EMPTYDATA;
		}
		try {
			context = JAXBContext.newInstance(obj.getClass());
		javax.xml.bind.Marshaller fd= context.createMarshaller();
		fd.marshal(obj, writer);
		} catch (JAXBException e) {
			Logger.Error(e.getMessage(),e);
			return SERVER_GENERAL_ERROR_MESSAGE+e.getMessage()+e.getCause();
		}
		return writer.toString();
	}
	public static String toXmlStringWithHead(Object obj)
	{
		JAXBContext context;
		StringWriter writer = new StringWriter();
		if(obj==null)
		{
			return EMPTYDATA;
		}
		try {
			context = JAXBContext.newInstance(obj.getClass());
		javax.xml.bind.Marshaller fd= context.createMarshaller();
		fd.marshal(obj, writer);
		} catch (JAXBException e) {
			Logger.Error(e.getMessage(),e);
			return SERVER_GENERAL_ERROR_MESSAGE+e.getMessage()+e.getCause();
		}
		String ret= writer.toString();
		return ret.substring(ret.indexOf(">")+1);
	}
	
}
