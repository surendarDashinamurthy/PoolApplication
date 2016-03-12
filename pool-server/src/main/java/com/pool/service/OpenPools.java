package com.pool.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pool.model.ErrorCode;
import com.pool.model.OpenPoolsListResponse;
import com.pool.model.SwimmingPool;

/**
 * Service gets the list of swimming pools that are open
 * 
 * @author AtoS
 * 
 */

public class OpenPools {
	static Logger log = LogManager.getLogger(OpenPools.class.getName());

	public static OpenPoolsListResponse getOpenSwimmingPools(String from,
			String to) throws ParseException {
		// Initilisation

		ErrorCode errorCode = new ErrorCode("9",
				"Please Contact the administrator");
		OpenPoolsListResponse response = new OpenPoolsListResponse(errorCode);

		// Input Verification

		if (from != null && to != null) {
			
			Date startingTime=convertStringToDate(from);
			Date endingTime=convertStringToDate(to);

			// Normal Execution
			List<SwimmingPool> swimmingPoolsList = new ArrayList<SwimmingPool>();

			SwimmingPool swimmingPool = new SwimmingPool();
			swimmingPool.setName("AlexJany");
			swimmingPool.setAddress("Argoulets Metro");
			swimmingPool.setPhoneNumber("0566223311");

			errorCode.setCode("0");
			errorCode.setMessage("Everything is fine");

			swimmingPoolsList.add(swimmingPool);

			response.setSwimmingPoolsList(swimmingPoolsList);
			response.setErrorCode(errorCode);
		} else {

			log.error("Input Values are not valid");
			errorCode = new ErrorCode("1",
					"Please check the input values");
			response = new OpenPoolsListResponse(errorCode);
		}

		return response;

	}

	/*
	 * Method returns a string in ISOFormat yyyy-MM-dd'T'HH:mm:ss.SSSXXX to a
	 * date object in java
	 */

	public static Date convertStringToDate(String dateInISOFormat)
			throws ParseException {
		Date convertedDate = null;
		if (dateInISOFormat != null) {
			DateFormat dateFormatISO = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

			convertedDate = dateFormatISO.parse(dateInISOFormat);

		}
		return convertedDate;

	}
}
