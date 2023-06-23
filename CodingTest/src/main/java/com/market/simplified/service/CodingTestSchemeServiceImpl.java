package com.market.simplified.service;

import com.market.simplified.entity.AttendanceEntity;
import com.market.simplified.entity.Scheme;
import com.market.simplified.entity.model.Attendance;
import com.market.simplified.entity.model.Dataum;
import com.market.simplified.entity.model.Root;
import com.market.simplified.entity.model.request;
import com.market.simplified.exception.InvalidInputException;
import com.market.simplified.exception.ResourceNotFoundException;
import com.market.simplified.repository.AttendanceRepository;
import com.market.simplified.repository.CodingTestSchemeRepository;
import com.market.simplified.repositoryImpl.AttendanceRepositoryImpl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Date;

//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CodingTestSchemeServiceImpl implements CodeingTestSchemeService {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
	AttendanceRepository attendanceRepo;
    
    @Autowired
	AttendanceRepositoryImpl attendanceRepoImpl;
    
    

    @Autowired
    CodingTestSchemeRepository codingTestschemeRepository;

    public String addAllScheme(List<Scheme> schemes) {

    	codingTestschemeRepository.saveAll(schemes);

        return "All Scheme Successfully Stored in DB";

    }

    public List<Scheme> findSchemeByName(String schemeName) throws ResourceNotFoundException {

        List<Scheme> scheme = Optional.of(codingTestschemeRepository.findBySchemeName(schemeName)).orElse(null);

        if(scheme.isEmpty()) {
        throw new ResourceNotFoundException("No scheme with this name: "+schemeName);
        }else {
        return scheme; }

    }


    @SuppressWarnings("unused")
    public JSONObject fetchSchemeByFilter(long schemeId, String filter) throws ResourceNotFoundException{

    	String url = "https://api.mfapi.in/mf/" + schemeId;

    	Root response = restTemplate.getForObject(url, Root.class);

    	if(response.getMeta().getScheme_name()==null){
    		throw new ResourceNotFoundException("No Scheme with this ID: "+schemeId);
    	}

    	List<Dataum> dataList = filterByDate(response.getData(), filter);

    	Root root = new Root();
    	root.setMeta(response.getMeta());
    	root.setData(dataList);

    	if(root!=null) {

    		JSONObject resultJson = new JSONObject();
    		resultJson.put("fundHouse", root.getMeta().getFund_house());
    		resultJson.put("schemeCode", root.getMeta().getScheme_code());
    		resultJson.put("schemeName", root.getMeta().getScheme_name());


    		int len = root.getData().size();  
    		ArrayList<String[]> list1 = new ArrayList<String[]>();
    		String[] schemeArrayNav = new String[ len ]; 
    		String[] schemeArrayDate = new String[ len ]; 

    		for (int i = 0; i < len; i++)  {
    			schemeArrayNav[i] = root.getData().get(i).getNav(); 
    			schemeArrayDate[i] = root.getData().get(i).getDate();

    		}
    		list1.add(schemeArrayNav);
    		list1.add(schemeArrayDate);
    		resultJson.put("data", list1);

    		JSONObject resultJsonobj= new JSONObject();
    		resultJsonobj.put("response", resultJson);
    		return resultJsonobj;

    	}else {
    		throw new ResourceNotFoundException("Fetching scheme by Date filter is Not containg Datas: ");
    	}   
    }

	public String saveAttendance(List<request> req) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<AttendanceEntity> attendanceEntityList = new ArrayList<>();

		for(request aa : req) {

			Date reqDate = null;
			try {
				reqDate = sdf.parse(aa.getcDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			List<AttendanceEntity> attendanceEntityResult = attendanceRepo.getEmployeeDetails(aa.getResponsiblePersonId(), sdf.format(reqDate));

			if(!attendanceEntityResult.isEmpty()) {
				for(AttendanceEntity res : attendanceEntityResult) {
					Date dataBaseDate = null;
					try {
						dataBaseDate = sdf.parse(sdf.format(res.getcDate()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					int result = reqDate.compareTo(dataBaseDate);
					if(res.getResponsiblePersonId().equalsIgnoreCase(aa.getResponsiblePersonId()) && result == 0) {
						System.out.println("Database Date is equal to Requested Date");
						break;	
					} else {
						AttendanceEntity temp = new AttendanceEntity();
						temp.setResponsiblePersonId(aa.getResponsiblePersonId());
						temp.setResponsiblePersonName(aa.getResponsiblePersonName());
						temp.setResponsiblePersonMob(aa.getResponsiblePersonMob());
						temp.setCookingCenterId(aa.getCookingCenterId());
						temp.setCookingCenterName(aa.getCookingCenterName());
						temp.setUnderEmployeeName(aa.getUnderEmployeeName());
						temp.setUnderEmpId(aa.getUnderEmpId());
						temp.setUnderEmpMob(aa.getUnderEmpMob());
						temp.setcDate(reqDate);
						temp.setStatus(aa.getStatus());
						temp.setAdminId(aa.getAdminId());
						temp.setAdminName(aa.getAdminName());

						attendanceEntityList.add(temp);

					}	
				}
			} else {
				AttendanceEntity temp = new AttendanceEntity();
				temp.setResponsiblePersonId(aa.getResponsiblePersonId());
				temp.setResponsiblePersonName(aa.getResponsiblePersonName());
				temp.setResponsiblePersonMob(aa.getResponsiblePersonMob());
				temp.setCookingCenterId(aa.getCookingCenterId());
				temp.setCookingCenterName(aa.getCookingCenterName());
				temp.setUnderEmployeeName(aa.getUnderEmployeeName());
				temp.setUnderEmpId(aa.getUnderEmpId());

				temp.setUnderEmpMob(aa.getUnderEmpMob());
				temp.setcDate(reqDate);
				temp.setStatus(aa.getStatus());
				temp.setAdminId(aa.getAdminId());
				temp.setAdminName(aa.getAdminName());

				attendanceEntityList.add(temp);
			}
		}
		if(!attendanceEntityList.isEmpty()) {
			attendanceRepo.saveAll(attendanceEntityList);
			return "Attendance List Saved";
		} else {
			return "all Attendance List are already saved";
		}

	}
	
	//saveAttendancePartTwo
	public String saveAttendancePartTwo(List<request> req) {

		String response = null;
        Date dataBaseDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<AttendanceEntity> attendanceEntityList = new ArrayList<>();

		List<AttendanceEntity> attendanceEntityResult = attendanceRepoImpl.getEmployeeInfo(req);

		if(!attendanceEntityResult.isEmpty()) {

			for(AttendanceEntity res : attendanceEntityResult) {
				System.out.println(res.getcDate());
				System.err.println(res.getResponsiblePersonId());

				response =  res.getResponsiblePersonId();
				
				try {
					dataBaseDate = sdf.parse(sdf.format(res.getcDate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return response+" ID and date is "+dataBaseDate;
	}

    public List<Dataum> filterByDate(List<Dataum> data, String filter) {

        List<Dataum> filteredData = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();

        if (filter.equalsIgnoreCase("1M")) {
        	filteredData =  data.stream().filter(d ->
        	LocalDate.parse(d.getDate(), DATE_FORMAT).isAfter(currentDate.minusDays(31)))
        			.collect(Collectors.toList());
        } else if(filter.equalsIgnoreCase("1W")) {
        	filteredData = data.stream().filter(d ->
        	LocalDate.parse(d.getDate(), DATE_FORMAT).isAfter(currentDate.minusDays(7)))
        			.collect(Collectors.toList());
        } else if(filter.equalsIgnoreCase("1Y")) {
        	filteredData = data.stream().filter(d ->
        	LocalDate.parse(d.getDate(), DATE_FORMAT).isAfter(currentDate.minusYears(1)))
        			.collect(Collectors.toList());
        }else if(filter.equalsIgnoreCase("5Y")) {
        	filteredData = data.stream().filter(d ->
        	LocalDate.parse(d.getDate(), DATE_FORMAT).isAfter(currentDate.minusYears(5)))
        			.collect(Collectors.toList());
        } else {
        	throw new InvalidInputException("Try with : 1M,1W,1Y,5Y, "+"Invalid Input Exception : "+filter);
        }        
        return filteredData;
    }


}
