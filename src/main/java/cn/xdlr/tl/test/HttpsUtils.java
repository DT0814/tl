package cn.xdlr.tl.test;

import cn.xdlr.tl.pojo.result.LoginConfirmResult;
import cn.xdlr.tl.pojo.result.LoginRequestResult;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.utils.JsonUtils;
import cn.xdlr.tl.utils.SHA256Utils;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class HttpsUtils {
    private String url = "https://222.25.188.1:50118";
    //  private String url = "http://localhost:8080";

    /**
     * @param cid    客户端id
     * @param Acode  客户端授权码
     * @param uid    用户id
     * @param Ustate 状态 入口 出口 售货机
     * @param Uimage base64编码永固
     * @param Utime  触发时间2018-11-11 12:12:12
     * @return
     */
    public SimpleResult PutUserState(Integer cid, String Acode, String uid,
                                     String Ustate, String Uimage, String Utime) {
        String PutUserState = new HttpsUtils().doPost("cid=" + cid + "&Acode=" + Acode +
                "&Uid=" + uid + "&Ustate=" + Ustate + "&Uimage=" + Uimage
                + "&Utime=" + Utime, "/user/PutUserState"
        );
        System.out.println(PutUserState);
        return JsonUtils.jsonToPojo(PutUserState, SimpleResult.class);
    }

    @org.junit.Test
    public void VenderUseToken() {
        VenderUseToken(2, "0zG07Q029JtoPlAhznWEkMRSkngeVdFS88xPyposp0OjQZDPQymHKh5CEi9CoKmQHs1jzUodlkzX3Dq2zwpFipd7j104eyPj6sIfq3O9GaHJnlCnnNsad7kyLQnODrAX", "B37C03AE1261C4428156AF9EFCAAF211", "aadsadsadasd1232132132", 10);
    }


    /**
     * 使用积分消费
     *
     * @param cid     客户端id
     * @param Acode   客户端认证码
     * @param uid     用户id
     * @param Onumber 订单编号
     * @param value   消费积分数量
     * @return
     */
    public SimpleResult VenderUseToken(Integer cid, String Acode, String uid,
                                       String Onumber, Integer value) {
        String PutUserState = new HttpsUtils().doPost("cid=" + cid + "&Acode=" + Acode +
                "&Uid=" + uid + "&Onumber=" + Onumber + "&Value=" + value, "/user/VenderUseToken");
        System.out.println(PutUserState);
        return JsonUtils.jsonToPojo(PutUserState, SimpleResult.class);
    }

    @org.junit.Test
    public void loginTest() {
        login(2, "123456");
    }

    /**
     * 请求认证
     *
     * @param cid  客户端id
     * @param pass 客户端密码
     * @return
     */
    public String login(Integer cid, String pass) {
        String request = new HttpsUtils().doPost("cid=" + cid, "/cli/request");
        LoginRequestResult loginRequestResult = JsonUtils.jsonToPojo(request, LoginRequestResult.class);
        String confirm = SHA256Utils.sha256(pass, loginRequestResult.getRandom());
        String result = new HttpsUtils().doPost("cid=1&confirm=" + confirm, "/cli/confirm");
        LoginConfirmResult loginConfirmResult = JsonUtils.jsonToPojo(result, LoginConfirmResult.class);
        System.out.println(loginConfirmResult.getAuthCode());
        return loginConfirmResult.getAuthCode();
    }


    public String doGet(String param, String url) {
        HttpURLConnection conn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        this.url += url + "?" + param;
        try {
            conn = getConn(this.url);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.flush();
            return getDate(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        return "";
    }

    public String doPost(String param, String url) {
        HttpURLConnection conn = null;
        PrintWriter out = null;
        this.url += url;
        try {
            conn = getConn(this.url);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            return getDate(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private HttpURLConnection getConn(String url) throws Exception {
        HttpURLConnection conn = null;
        trustAllHttpsCertificates();
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        conn = (HttpURLConnection) new URL(url).openConnection();
        return conn;
    }

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }


    public String getDate(InputStream inputStream) {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        return "";
    }

    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }
}