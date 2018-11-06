package cn.xdlr.tl.test;

import cn.xdlr.tl.utils.SHA256Utils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;


/*
 * GET请求类
 */
public class Demo {
    private String url = "https://222.25.188.1:50118";

    public Demo() {

    }
    @Test
    public void sha() {
        String sha256StrJava = SHA256Utils.sha256("123456", "xNQ2YD69lJW5HaC4ydZmAFxknn98hea67iwc9JQnRTrXwINvH6trXhBAMqsyQu4svLo9YziDWB6kt4bUPJrIneN8WzfFyc3xG3MgzVvCkZZ8V8D2DeUH1aJ4iTV9VH4J");
        System.out.println(sha256StrJava);
    }
    @org.junit.Test
    public void login() {
         new Demo().request("cid=1");
        //xNQ2YD69lJW5HaC4ydZmAFxknn98hea67iwc9JQnRTrXwINvH6trXhBAMqsyQu4svLo9YziDWB6kt4bUPJrIneN8WzfFyc3xG3MgzVvCkZZ8V8D2DeUH1aJ4iTV9VH4J
         // new Demo().confirm("cid=1&confirm=b4c191df4041da87e645693887c159a692d11ee917e4bbba15b478ae45d7a1d1");
    }

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    public void confirm(String param) {

        HttpURLConnection conn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        this.url += "/cli/confirm";
        try {
            trustAllHttpsCertificates();
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println(getDate(in));
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
    }

    public String getDate(BufferedReader in) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public void request(String param) {
        BufferedReader in = null;
        HttpURLConnection conn = null;
        PrintWriter out = null;
        this.url += "/cli/request";
        try {
            trustAllHttpsCertificates();
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println(getDate(in));
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