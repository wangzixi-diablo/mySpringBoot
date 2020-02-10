package com.sap.prolikeService.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
	
    private static final Logger log = LoggerFactory.getLogger(CommerceController.class);
	
    private String getCurrentDate() {
    	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    	Date date = new Date(System.currentTimeMillis());
    	return formatter.format(date);
    }
    
	@GetMapping("/product")
    public String getProductDetail() {
		final Logger log2 = LoggerFactory.getLogger(CommerceController.class);
		String logInfo = "Hello world method called:" + getCurrentDate();
		System.out.println(logInfo);
		log2.info(logInfo);
		log.info(logInfo);
	    return "Hello World";
    }
}
