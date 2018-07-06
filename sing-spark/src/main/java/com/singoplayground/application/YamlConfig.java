package com.singoplayground.application;

import java.io.File;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.singplayground.model.User;

public class YamlConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
	        try {
	            User user = mapper.readValue(new File("src/main/resources/user.yaml"), User.class);
	            System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
	            
	            String json = mapper.writeValueAsString(user);
	    
	            System.out.println(json);
	            
	            System.out.println("user : " + user.getAge());
	            System.out.println("age : " + user);
	            
	            System.out.println("this is :" + user.getTeam().get(0).getTeamCode());
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	}

}
