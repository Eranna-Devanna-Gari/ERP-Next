package com.zerozilla.erpnext.apiresponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {
	
	public static ResponseEntity<Object> generateResponse(HttpStatus status, String message, Object response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Status", status.value());
		map.put("message", message);
		map.put("data", response);
		
		return new ResponseEntity<Object>(map, status);
	}

}
