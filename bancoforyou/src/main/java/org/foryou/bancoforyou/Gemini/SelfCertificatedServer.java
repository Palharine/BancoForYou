package org.foryou.bancoforyou.Gemini;

import java.net.http.HttpClient;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class SelfCertifcatedServer {
    public static HttpClient getHttpClient(){
        try{
            TrustManager[] trustAllCerts = new TrustManager() {
                
            
                @Override
                public X509Certificate[] getAcceptedIssuers() {return null;}
                @Override
                public void checkClientTrusted (X509Certificate[] certs, String authType) {}
                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            };
        

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null,trustAllCerts, new java.security.SecureRandom());

            return HtppClient.newBuilder().sslContext(sslContext).build();
        } catch (Exception e){
            throw new RuntimeException("Erro ao configurar HttpClient: " + e.getMessage());
        }
    }
}
       

