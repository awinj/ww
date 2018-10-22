package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.naming.Context;


import java.util.Properties;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class DK {


    public static void main(String[] args)
    {
        new DK().isExist("wangx");
    }

    // 配置文件路径
    private final String filePath = "modules\\baseapp\\ad_domian_config.properties";
    private Map<String, String> map;

    private Map<String, String> getMap() {
        if (map == null)
        {
            map=new HashMap();
            map.put("host","172.16.0.101");
            map.put("port","389");
            map.put("adminUserName","bakadmin");
            map.put("adminPassword","60vixt!j");
            map.put("domainRoot","athub.com");
            map.put("searchBase","DC=athub,DC=com");

        }
//            map = PropertiesTool.GetAllProperties(filePath);// 读取配置文件
        return map;
    }

    public int login(String username, String password) {
//        String mac = MacAddress.getEntryMac();
        String key = getMap().get("key");
        String domainRoot=getMap().get("domainRoot");
//        if (key != null && key.equals(mac)) {
            // 先判断是否存在用户
            if (!isExist(username))
            {
//                Logger.error("wswlog:"+username+"，Ad域中该用户名不存在");
                return LoginResult.NoUser;
            }

            String host = getMap().get("host");// 从配置文件中读取 ad域服务器ip
            String port = getMap().get("port");// 读取端口
            int result = connect(host, port, comineAdUser(username,domainRoot), password);
            return result;

    }

    public boolean isExist(String username) {
        Properties env = new Properties();
        String host = getMap().get("host");// 从配置文件中读取 ad域服务器ip
        String port = getMap().get("port");
        String adminUserName = getMap().get("adminUserName");// 从配置文件中读取
        String domainRoot=getMap().get("domainRoot");	// ad域名
        adminUserName = comineAdUser(adminUserName,domainRoot);
        String password = getMap().get("adminPassword");// 从配置文件中读取 ad域管理员的密码
        String searchBase = getMap().get("searchBase");// 查询域名
        String searchFilter = getMap().get("searchFilter");// 查询条件
        String ldapURL = "LDAP://" + host + ":" + port + "";// ip:port
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");// "none","simple"
        env.put(Context.SECURITY_PRINCIPAL, adminUserName);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.PROVIDER_URL, ldapURL);
        env.put("java.naming.ldap.version","3");
//        env.put("java.naming.security.protocol","ssl");
        try {
            LdapContext ctx = new InitialLdapContext(env, null);
            SearchControls searchCtls = new SearchControls();
            searchCtls.setReturningAttributes(new String[] { "samaccountname" });
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            if (searchFilter == null || searchFilter.length() <= 0)
                searchFilter = "(&(objectClass=user)(samaccountname="+username+"))";
            if (searchBase == null || searchBase.length() <= 0)
                searchBase = "DC=ww,DC=jj";
            NamingEnumeration<SearchResult> answer = ctx.search(searchBase,
                    searchFilter, searchCtls);
            while (answer.hasMoreElements()) {
                SearchResult sr = (SearchResult) answer.next();
                Attributes attrs = sr.getAttributes();
                if (attrs != null && attrs.getAll() != null) {
                    NamingEnumeration ne = attrs.getAll();
                    Attribute attr = (Attribute) ne.next();
                    if (attr != null && attr.getAll() != null) {
                        Object adName = attr.getAll().next();
                        System.out.println(adName);
                        if (username.equals(adName))
                            return true;
                    }
                }
            }
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String comineAdUser(String username,String domainRoot)
    {
        if(username==null)
            return "";
        if(domainRoot==null||domainRoot.length()<=0)
            return username;
        else
            return username.trim()+"@"+domainRoot.trim();
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
                              String password) {
        DirContext ctx = null;
        Hashtable<String,String> env = new Hashtable<String,String>();

        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");// "none","simple","strong"
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.PROVIDER_URL, "ldap://" + host + ":" + port);
        try {
            ctx = new InitialDirContext(env);
            return LoginResult.Success;
        } catch (AuthenticationException e) {
            return LoginResult.Failure;
        } catch (javax.naming.CommunicationException e) {
            return LoginResult.ConnectError;
        } catch (Exception e) {
            return LoginResult.UnKnowError;
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




    /**

     * @Description:使用SSl的方式登录

     * @author zhuyr

     * @date 2018-07-03

     */

    public void certinit() {



        Properties env = new Properties();

        String adminName = "cn=bakadmin,cn=Users,dc=athup,dc=com";

        String adminPassword = "60vixt!j";// password

        String ldapURL = "ldap://172.16.0.101:389";// ip:port

        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");

        env.put(Context.SECURITY_AUTHENTICATION, "simple");//LDAP访问安全级别："none","simple","strong"

        env.put(Context.SECURITY_PRINCIPAL, adminName);

        env.put(Context.SECURITY_CREDENTIALS, adminPassword);

        env.put(Context.PROVIDER_URL, ldapURL);



        String keystore = "C:\\ProgramInstall\\Java\\jdk1.8.0_51\\jre\\lib\\security\\cacerts";

        System.setProperty("javax.net.ssl.trustStore", keystore);

        env.put(Context.SECURITY_PROTOCOL, "ssl");



        try {

            InitialLdapContext dc = new InitialLdapContext(env, null);

            System.out.println("AD域ssl身份认证成功");

        } catch (Exception e) {

            System.out.println("AD域ssl身份认证失败");

            e.printStackTrace();

        }

    }


}
