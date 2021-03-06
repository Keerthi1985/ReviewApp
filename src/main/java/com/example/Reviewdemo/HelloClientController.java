package com.example.Reviewdemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;

@RestController
public class HelloClientController {
	
	@GetMapping("/getHello")
	public String getHello() {
		System.out.println("entering hello");
		 HttpClient client = new DefaultHttpClient();
	     HttpGet get = new HttpGet("http://rating:8082/Hello");
         //get.addHeader("dummy", "fredie");
		 System.out.println("changed http req to rating");
		try {
			client.execute(get);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "HTTPHello";
	}
	@GetMapping("/getJHello")
	public String getJerseyHello() {
		System.out.println("entering jhello");
		Client client1 = ClientBuilder.newClient();
		System.out.println("setting client");
		String name = client1.target("http://rating:8082/Hello")
		        .request(MediaType.TEXT_PLAIN)
		        .get(String.class);
		
		return "JerseyHello";
	}

}
