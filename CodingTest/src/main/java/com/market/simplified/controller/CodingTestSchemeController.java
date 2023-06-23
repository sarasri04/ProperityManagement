package com.market.simplified.controller;

import com.market.simplified.entity.RequestPayload;
import com.market.simplified.entity.Scheme;
import com.market.simplified.entity.model.Attendance;
import com.market.simplified.entity.model.Root;
import com.market.simplified.entity.model.request;
import com.market.simplified.exception.ResourceNotFoundException;
import com.market.simplified.service.CodingTestSchemeServiceImpl;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
// scheme 3 try completed
import java.util.List;

@RestController
@RequestMapping("/mf")
public class CodingTestSchemeController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CodingTestSchemeServiceImpl codingTestSchemeServiceImpl;
    
	
    
    private static Logger logger = LoggerFactory.getLogger(CodingTestSchemeController.class);
    
    
    @GetMapping("/getScheme/{schemeName}")
    public String findByName(@PathVariable String schemeName) throws ResourceNotFoundException{

        return "Test services "+schemeName;

    }

    @PostMapping("/postSchemes")
    public String addAllScheme() {

        String url = "https://api.mfapi.in/mf";
        ResponseEntity<List<Scheme>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Scheme>>() {
        });
        List<Scheme> schemes = response.getBody();
        return codingTestSchemeServiceImpl.addAllScheme(schemes);

    }

    @GetMapping("/getSchemeByName/{schemeName}")
    public List<Scheme> findSchemeByName(@PathVariable String schemeName) throws ResourceNotFoundException{

        return codingTestSchemeServiceImpl.findSchemeByName(schemeName);

    }
    
    @PostMapping("/saveAttendance")
	public ResponseEntity<String> saveAttendance(@RequestBody List<request> req) {
 
    	String result = codingTestSchemeServiceImpl.saveAttendance(req);;
        logger.info("http Response \n " + result.toString());
        return new ResponseEntity<String>(result.toString(),org.springframework.http.HttpStatus.OK);
	}
    
    @PostMapping("/saveAttendancePartTwo")
	public ResponseEntity<String> saveAttendancePartTwo(@RequestBody List<request> req) {
    	
        String result = codingTestSchemeServiceImpl.saveAttendancePartTwo(req);
        logger.info("http Response \n " + result.toString());
        return new ResponseEntity<String>(result.toString(),org.springframework.http.HttpStatus.OK);
	}


    @PostMapping("/filterScheme")
    
    public ResponseEntity<String> fetchSchemeByFilter(@RequestBody RequestPayload requestPayload) throws ResourceNotFoundException {

        long schemeId = requestPayload.getRequest().getSchemeId();
        String filter = requestPayload.getRequest().getFilter();

        JSONObject result = new JSONObject();
        result = codingTestSchemeServiceImpl.fetchSchemeByFilter(schemeId, filter);
        logger.info("JSON Response \n " + result.toString());
        return new ResponseEntity<String>(result.toString(),org.springframework.http.HttpStatus.OK);

    }


}
