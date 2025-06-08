package com.example.elasticdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Configuration
public class AppConfig {

    @Bean
    public RestClient client(){
        try{
            //TrustManagerを設定してすべての証明書を信頼
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };

            //SSLContextを作成
            SSLContext sslContext = SSLContextBuilder.create()
                    .loadTrustMaterial((chain,authType) -> true) //すべての証明書を信頼
                    .build();

            //認証情報を設定
            BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("elastic", "G=RIRH_IQvLKwR-4c*6p"));

            //RestClientのビルダー作成
            RestClientBuilder builder = RestClient.builder(new HttpHost("localhost",9200,"https"))
                    .setHttpClientConfigCallback(httpClientBuilder ->
                            httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                                    .setSSLContext(sslContext) //SSLContextを設定
                                    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE) //SSL検証を無効
                            );

            return builder.build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
