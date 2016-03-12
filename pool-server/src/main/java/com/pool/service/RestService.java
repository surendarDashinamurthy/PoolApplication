package com.pool.service;

import java.text.ParseException;

import javax.ws.rs.GET;



import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pool.model.ErrorCode;
import com.pool.model.OpenPoolsListResponse;






//Plain old Java Object it does not extend as class or implements 
//an interface

//The class registers its methods for the HTTP GET request using the @GET annotation. 
//Using the @Produces annotation, it defines that it can deliver several MIME types,
//text, XML and HTML. 

//The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/swimmingpool")
public class RestService {

	  static Logger log = LogManager.getLogger( RestService.class.getName());	
	// This method is called if the application requests for JSON
	@GET
	@Path("/getopenpools")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OpenPoolsListResponse getOpenSwimmingPools(@QueryParam("from") String from, @QueryParam("to") String to) {
		
		log.info("BEGIN: GetOpenSwimmingPools begin. Parameters from "+from+" to "+to);
		
		OpenPoolsListResponse response = null;

		try {
			response = OpenPools.getOpenSwimmingPools(from, to);
		} catch (ParseException e) {
			log.error("Parsing error while reading inputs "+ from + "and "+to);
			ErrorCode errorCode = new ErrorCode("1",
					"Error while parsing Invalid Inputs");
			response = new OpenPoolsListResponse(errorCode);
			
		}catch(Exception e){
			log.error("Error while executing the list of swimming pools " + e.getMessage());
			ErrorCode errorCode = new ErrorCode("9",
					"Please Contact the administrator");
			response = new OpenPoolsListResponse(errorCode);
			
		}
		
		
		log.info("END: GetOpenSwimmingPools begin");
		return response;
	}

}