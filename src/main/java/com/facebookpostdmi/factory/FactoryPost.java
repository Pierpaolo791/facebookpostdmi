package com.facebookpostdmi.factory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;

import com.facebookpostdmi.model.Post;
import com.facebookpostdmi.util.YmlResolver;

public class FactoryPost extends TimerTask {
	Implementer impl;
	
	public FactoryPost(String[] urls) {
		impl = JsonFactoryPost.getMe(urls);
	}
	
	@Override
	public void run() {
		Post post = impl.getPost();
		if (post == null) return; 
		URL url = null;
		try {
			url = new URL("https://api.telegram.org/bot700982608:AAEptKtJPkags21mDfv4PQEmjO1hzp_CeTg/sendMessage?parse_mode=html&chat_id="+YmlResolver.getValue("post_channel")+"&text="+post.formatContent());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(
	                new InputStreamReader(
	                con.getInputStream()));
			in.close();
			con.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
		
	} 
}
