package com.inkombizz.master.settings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultAction {

	@GetMapping("/")
	public String index() {
		return "Hello Word";
	}

	@GetMapping("/error")
	public String error() {
		return "Error Reqst";
	}
	
	@GetMapping("/{page}")
	public String page(@PathVariable String page ) {
		return "<h1>You in Page</h1> <h1>"+page+"</h1> ";
	}
	
	@GetMapping("/{page}/{fn}")
	public String page_function(@PathVariable String page, @PathVariable String fn ) {
		return "<h1>You in Page "+page+"</h1> <h1> Function "+fn+"</h1> ";
	}
}
