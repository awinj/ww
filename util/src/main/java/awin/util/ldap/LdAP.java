package awin.util.ldap;

import awin.logger.Logger;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdAP {
	public static void main(String[] args) {
		
		
		Map<String,List<String>> ret;
		
		Properties env = new Properties();
		String adminName = "administrator@ww.jj";//username@domain
		String adminPassword = "123qwe!";//password
		String ldapURL = "LDAP://192.168.247.129:389";//ip:port
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");//"none","simple","strong"
		env.put(Context.SECURITY_PRINCIPAL, adminName);
		env.put(Context.SECURITY_CREDENTIALS, adminPassword);
		env.put(Context.PROVIDER_URL, ldapURL);
		try {
			LdapContext ctx = new InitialLdapContext(env, null);
			SearchControls searchCtls = new SearchControls();
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String searchFilter = "(&(objectCategory=person)(objectClass=user)(name=*))";
			String searchBase = "DC=ww,DC=jj";
			String returnedAtts[] = {"User-Password"};
//			searchCtls.setReturningAttributes(returnedAtts);
			NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter,searchCtls);
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();
				
				Attributes attrs= sr.getAttributes();
				if (attrs != null) {  
				     try {  
				      for (NamingEnumeration ne = attrs.getAll(); ne.hasMore();) {  
				    	  
				       Attribute attr = (Attribute) ne.next();// 得到下一个属性
				       System.out.println(" AttributeID=属性名："+ attr.getID().toString());  
				       // 读取属性值  
				       for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {  
				      String company =  e.next().toString();  
				        System.out.println("    AttributeValues=属性值：" + company);  
				       }  
				       System.out.println("    ---------------");  
				         
				      }  
				     } catch (NamingException e) {  
				      System.err.println("Throw Exception : " + e);  
				     }
				}
				System.out.println("<<<::[" + sr.getName()+"]::>>>>");
			}
			ctx.close();
		}catch (NamingException e) {
			Logger.Error(e.getMessage(),e);
			System.err.println("Problem searching directory: " + e);
		}
	}
}
