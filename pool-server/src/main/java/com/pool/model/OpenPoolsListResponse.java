package com.pool.model;

import java.util.List;

/**
 * The webservice response for the list of open swimming pools available in a given time
 * @author AtoS
 *
 */
public class OpenPoolsListResponse {
	

	ErrorCode errorCode;
	
	List<SwimmingPool> swimmingPoolsList;
	
	/**
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the swimmingPoolsList
	 */
	public List<SwimmingPool> getSwimmingPoolsList() {
		return swimmingPoolsList;
	}

	/**
	 * @param swimmingPoolsList the swimmingPoolsList to set
	 */
	public void setSwimmingPoolsList(List<SwimmingPool> swimmingPoolsList) {
		this.swimmingPoolsList = swimmingPoolsList;
	}

	// ErrorCode is a compulsory field
	public OpenPoolsListResponse(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}


}
