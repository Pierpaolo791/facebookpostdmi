package com.facebookpostdmi.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Post {
    
    private String id; 
    private String author; 
    private String content; 
    
    public Post() {

    }

    public Post setId(String id) {
        this.id = id;
        return this;
    }

    public Post setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }
    
    public String getContentHtml() {
        return content;
    }

	public String formatContent() {
		
		String str = "[Facebook Post - " + author +"]\n"+ id +"\n\nClicca sul link per visualizzarlo.";
		try {
			return  URLEncoder.encode(str,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
