package com.market.simplified.service;

import com.market.simplified.entity.Scheme;
import com.market.simplified.entity.model.Dataum;
import com.market.simplified.entity.model.Root;
import com.market.simplified.exception.ResourceNotFoundException;

import java.util.List;

import org.json.JSONObject;

public interface CodeingTestSchemeService {

    String addAllScheme(List<Scheme> scheme);

    List<Scheme> findSchemeByName(String schemeName) throws ResourceNotFoundException;

    JSONObject fetchSchemeByFilter(long schemeId, String filter) throws ResourceNotFoundException;

    List<Dataum> filterByDate(List<Dataum> data, String filter);
    
    

}
