package com.facebookpostdmi.factory;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;

import com.facebookpostdmi.model.Post;
import com.facebookpostdmi.util.FileManager;
import com.facebookpostdmi.util.JsonReader;

public class JsonFactoryPost implements Implementer {
	
	private String[] urls; 
	
	public JsonFactoryPost() {
		
	}
	
	public static JsonFactoryPost getMe(String[] urls) {
		JsonFactoryPost jfp = new JsonFactoryPost();
		jfp.urls = urls;
		return jfp;
	}
	
	public Post getPost() {
		Optional<Post> post = checkPost(); 
		if (post.isPresent()) return post.get();
		return null; 
	}
	
	@SuppressWarnings("unused")
	public Optional<Post> checkPost() {
		for (String url : urls) {
			JSONArray arr = null;
			try {
				arr = JsonReader.getItems(url, "items");
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int i=0; i<arr.length(); i++) {
				JSONObject item = (JSONObject) arr.get(i);
				String id = item.getString("id");
				if (!FileManager.isContains(id)) {
					FileManager.write(id);
					String author = new JSONObject(item.get("author").toString()).getString("name");
					String content = item.getString("content_html");
					if (content.contains("ha condiviso un") ||
							content.contains("a partagé une")) return Optional.empty();
					Post post = new Post().setAuthor(author).setContent(content).setId(id);
					
					return Optional.of(post);
				}
			}
				
		}
		return Optional.empty();
	}

}
