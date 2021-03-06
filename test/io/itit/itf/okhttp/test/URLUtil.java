package io.itit.itf.okhttp.test;

import java.util.Map;

import javax.net.ssl.SSLContext;

import io.itit.itf.okhttp.FastHttpClient;
import io.itit.itf.okhttp.Response;


/**
 * 
 * @author icecooly
 *
 */
public class URLUtil {
	//
	static{
		System.setProperty ("jsse.enableSNIExtension","false");
	}
	//
	public static String httpGet(String url) throws Exception {
		Response response = FastHttpClient.get().
				url(url).
				build().
				execute();
		return response.body().string();
	}
	//
	public static String httpsGet(String url) throws Exception {
		Response response = FastHttpClient.get().
				url(url).
				build().
				execute();
		return response.body().string();
	}
	//
	public static String httpsGet(String url,SSLContext sslContext) throws Exception {
		Response response = FastHttpClient.
				newBuilder().
				sslContext(sslContext).
				build().
				get().
				url(url).
				build().
				execute();
		return response.body().string();
	}
	//
	public static String httpPost(String url,Map<String,String> paramMap) throws Exception{ 
		Response response = FastHttpClient.post().
				url(url).
				addParams(paramMap).
				build().
				execute();
		return response.body().string();
	}
	//
	public static String httpPostWithBody(String url,String body) throws Exception{ 
		Response response = FastHttpClient.post().
				url(url).
				body(body).
				build().
				execute();
		return response.body().string();
	}
	//
	public static String httpsPost(String url) throws Exception{ 
		return httpsPost(url, null, null);
	}
	//
	public static String httpsPost(String url,Map<String,String> paramMap) throws Exception{ 
		return httpsPost(url, paramMap, null);
	}
	//
	public static String httpsPost(String url,Map<String,String> paramMap,SSLContext sslContext) throws Exception{ 
		Response response = FastHttpClient.
				newBuilder().
				sslContext(sslContext).
				build().
				post().
				url(url).
				addParams(paramMap).
				build().
				
				execute();
		return response.body().string();
	}
	//
	public static String httpsPostWithBody(String url,String body) throws Exception{ 
		return httpsPostWithBody(url, body, null);
	}
	//
	public static String httpsPostWithBody(String url,String body,SSLContext sslContext) throws Exception{ 
		Response response = FastHttpClient.
				newBuilder().
				sslContext(sslContext).
				build().
				post().
				url(url).
				body(body).
				build().
				
				execute();
		return response.body().string();
	}
}
