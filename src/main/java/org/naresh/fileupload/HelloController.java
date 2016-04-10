package org.naresh.fileupload;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HelloController {

	@Value("${pcr.upload.api.maxFileSize:15MB}")
	private String maxFileSize;
	@Value("${pcr.upload.api.maxRequestSize:15MB}")
	private String maxRequestSize;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file)
    {
    	System.out.println("Inside file val "+file.getName());
    	return "Greetings from Spring Boot!";
    }
    
    
    @Bean
    MultipartConfigElement multipartConfigElement() 
    {
    	MultipartConfigFactory factory = new MultipartConfigFactory();
    	factory.setMaxFileSize(maxFileSize);
    	factory.setMaxRequestSize(maxRequestSize);
    	return factory.createMultipartConfig();
    }

}