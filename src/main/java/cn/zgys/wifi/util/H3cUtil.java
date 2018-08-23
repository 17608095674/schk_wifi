package cn.zgys.wifi.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class H3cUtil {

    //删除用户
    public static void deleteUser(String userName){
        DefaultHttpClient client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(
                new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
        HttpDelete delete = new HttpDelete("http://172.31.8.15:8080/imcrs/uam/acmUser?userName="+userName+"&cancelType=1");
        delete.addHeader("accept", "application/xml");
        HttpResponse response = null;
        try {
            response = client.execute(delete);
            System.err.println(response.getStatusLine());
//			String s = EntityUtils.toString(response.getEntity());
//          String str = new String(EntityUtils.toString(response.getEntity()).getBytes("ISO-8859-1"),"UTF-8");
////        System.err.println(str);
//			System.err.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //增加用户
    public static void addUser(String userName,String password){
        DefaultHttpClient client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(
                new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
        HttpPost post = new HttpPost("http://172.31.8.15:8080/imcrs/uam/acmUser");
        post.addHeader("Content-Type","application/xml");
        String str1 = "\n" +
                "\n" +
                "<acmUser>\n" +
                " <platUserId>54575</platUserId>\n" +
                " <userName>"+userName+"</userName>\n" +
                " <userPassword>"+password+"</userPassword>\n" +
                "<ifSelfModifyPsd>false</ifSelfModifyPsd>\n" +
                " <appliedService>\n" +
                "  <serviceTemplateId>6</serviceTemplateId>\n" +
                "  <userIp></userIp>"+
                " </appliedService>\n" +
                "</acmUser>\n" +
                "\n" +
                "";
        StringEntity entity = new StringEntity(str1, "UTF-8");
        entity.setContentType("application/xml");
        entity.setContentEncoding("UTF-8");
        post.setEntity(entity);
        HttpResponse response = null;
        try {
            response = client.execute(post);
            System.err.println(response.getStatusLine());
//			String s = EntityUtils.toString(response.getEntity());
//          System.err.println(response.getEntity());
//          String str = new String(EntityUtils.toString(response.getEntity()).getBytes("ISO-8859-1"),"UTF-8");
//          System.err.println(str);
//			System.err.println(EntityUtils.toString(response.getEntity()));
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //在线人数
    public static String online() {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(
                new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
        HttpGet get = new HttpGet("http://172.31.8.15:8080/imcrs/uam/online?total=true");
        get.addHeader("accept", "application/xml");
        HttpResponse response = null;
        String s = null;
        try {
            response = client.execute(get);
            s = response.getFirstHeader("Total").toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] a = s.split(":");
        System.err.println(a[1].trim());
        return a[1].trim();
    }


    //安卓终端
    public static String androidTerminal() {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(
                new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
        HttpGet get = new HttpGet("http://172.31.8.15:8080/imcrs/uam/online?terminalOs=Android&total=true");
        get.addHeader("accept", "application/xml");
        HttpResponse response = null;
        String s = null;
        try {
            response = client.execute(get);
            s = response.getFirstHeader("Total").toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] a = s.split(":");
        System.err.println(a[1].trim());
        return a[1].trim();
    }

    //iOS终端
    public static String iOSTerminal() {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(
                new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
        HttpGet get = new HttpGet("http://172.31.8.15:8080/imcrs/uam/online?terminalOs=iOS&total=true");
        get.addHeader("accept", "application/xml");
        HttpResponse response = null;
        String s = null;
        try {
            response = client.execute(get);
            s = response.getFirstHeader("Total").toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] a = s.split(":");
        System.err.println(a[1].trim());
        return a[1].trim();
    }

    //Mac终端
    public static String macTerminal() {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(
                new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
        HttpGet get = new HttpGet("http://172.31.8.15:8080/imcrs/uam/online?terminalOs=Mac&total=true");
        get.addHeader("accept", "application/xml");
        HttpResponse response = null;
        String s = null;
        try {
            response = client.execute(get);
            s = response.getFirstHeader("Total").toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] a = s.split(":");
        System.err.println(a[1].trim());
        return a[1].trim();
    }

    //windows终端
    public static String windowsTerminal() {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(
                new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
        HttpGet get = new HttpGet("http://172.31.8.15:8080/imcrs/uam/online?terminalOs=Windows&total=true");
        get.addHeader("accept", "application/xml");
        HttpResponse response = null;
        String s = null;
        try {
            response = client.execute(get);
            s = response.getFirstHeader("Total").toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] a = s.split(":");
        System.err.println(a[1].trim());
        return a[1].trim();
    }

    //最近七天在线人数
    public static Map<Integer, String> lastTerminal() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 1; i <= 7; i++) {
            DefaultHttpClient client = new DefaultHttpClient();
            client.getCredentialsProvider().setCredentials(
                    new AuthScope("172.31.8.15", 8080, "iMC RESTful Web Services"),
                    new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
            HttpGet get = new HttpGet("http://172.31.8.15:8080/imcrs/uam/onlineStat?startDate=" + DateUtil.dayFormat(DateUtil.getBeginByDay(i)) + "&endDate=" + DateUtil.dayFormat(DateUtil.getEndByDay(i)) + "&total=true");
            //  HttpGet get = new HttpGet("http://172.31.8.15:8080/imcrs/uam/onlineStat?startDate=2018-07-06%2000%3A00&endDate=2018-07-06%2023%3A59&total=true");
            get.addHeader("accept", "application/xml");
            HttpResponse response = null;
            String s = null;

            try {
                response = client.execute(get);
                s = response.getFirstHeader("Total").toString();
            }  catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String[] a = s.split(":");
            System.err.println(a[1].trim());
            String str = a[1].trim();
            System.err.println(DateUtil.dayFormat(DateUtil.getBeginByDay(i)));
            System.err.println(DateUtil.dayFormat(DateUtil.getEndByDay(i)));
            map.put(i, a[1].trim());
        }
        return map;
    }

    public static void main(String[] args) {
//			System.err.println("在线人数：" + H3cUtil.online());
//			System.err.println("安卓在线人数：" + H3cUtil.androidTerminal());
//			System.err.println("IOS在线人数：" + H3cUtil.iOSTerminal());
//			System.err.println("MAC在线人数：" + H3cUtil.macTerminal());
//			System.err.println("Windows在线人数：" + H3cUtil.windowsTerminal());
//			System.err.println("last在线人数：" + H3cUtil.lastTerminal());
    }

}
