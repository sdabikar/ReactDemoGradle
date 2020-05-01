package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/welcome")
	public Map welcome() {
		Map demo = new HashMap<>();
		demo.put("Course", "Full STack Development");
		return demo;
	}

}
