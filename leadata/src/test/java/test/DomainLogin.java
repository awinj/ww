package test;

import java.util.Hashtable;
import java.util.Scanner;
import javax.naming.AuthenticationException;
import javax.naming.Context;


import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class DomainLogin {

	
	public static void main(String[] args)
	{
//		Scanner stu=new Scanner(System.in); 
//		System.out.println("请输入host：");
//		String host=stu.next(); 
//		
//		System.out.println("请输入port：");
//		String port=stu.next();
//		System.out.println("输入username");
//		String username=stu.next();
//		System.out.println("输入password");
//		String password= stu.next();
//		System.out.println("输入策略");
//		String cl= stu.next();
		
		
		int i =connect("172.16.0.101","389","bakadmin@athup.com","60vixt!j","simple");
		System.out.print(i);
//		connect(host, port, username, password,cl);

	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 * @return 连接ad域是否成功
	 */
	public static int connect(String host, String port, String username,
			String password,String cl) {
		DirContext ctx = null;
		Hashtable<String,String> env = new Hashtable<String,String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, cl);// "none","simple"
		env.put(Context.SECURITY_PRINCIPAL, username);
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.PROVIDER_URL, "ldap://" + host + ":" + port);
		try {
			ctx = new InitialDirContext(env);
			return 1;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return 0;
		} catch (javax.naming.CommunicationException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		} finally {
			if (null != ctx) {
				try {
					ctx.close();
					ctx = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
