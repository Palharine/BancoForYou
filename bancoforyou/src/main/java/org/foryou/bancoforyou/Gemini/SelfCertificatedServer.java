package org.foryou.bancoforyou.Gemini;

import java.net.http.HttpClient;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

public class SelfCertificatedServer {

    public static HttpClient getHttpClient() {
        try {

            // TrustManager que aceita qualquer certificado
            X509TrustManager trustAll = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };

            // Configurando SSL com o TrustManager permissivo
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new X509TrustManager[]{ trustAll }, new java.security.SecureRandom());

            return HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .version(HttpClient.Version.HTTP_2)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao configurar HttpClient SSL: " + e.getMessage(), e);
        }
    }
}
