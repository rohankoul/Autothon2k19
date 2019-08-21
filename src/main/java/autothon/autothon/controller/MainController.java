package autothon.autothon.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.*;

import autothon.autothon.uiAutomation.Steps;

@RestController
public class MainController {

	private static final int MAX_T = 20;

	@RequestMapping("/")
    public String postiveResponse(){
        return "<h1>Welcome to Tests</h1>";
    }
	
	@RequestMapping("/api/trigger")
    public String trigger(){
       
		
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		
		Runnable s1 = new Steps("chrome","windows");
		//Runnable s2 = new Steps("chrome","android");
		
		pool.execute(s1);	
		//pool.execute(s2);	
		return "200";
		
    }
	
}

