package com.userservice.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.userservice.bean.ResultBean;

/**
 * @author Gourav Singh
 * Global Exception Handler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * Exception Handler function
	 * @param Exception
	 * @return ResultBean
	 * @throws 
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResultBean handleException(Exception ex) {
		logger.error("Exception : " + ex.getMessage());
		ResultBean resultBean = new ResultBean();
		resultBean.setStatusCode(3000);
		resultBean.setStatusMessage("Unknown Exception");
		return resultBean;
	}
	
	/**
	 * BadRequestException Handler function
	 * @param 
	 * @return ResultBean
	 * @throws 
	 */
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Bad Request URL")
	public @ResponseBody ResultBean handleBadRequestException() {
		logger.error("BadRequestException : Wrong URL");
		ResultBean resultBean = new ResultBean();
		resultBean.setStatusCode(3001);
		resultBean.setStatusMessage("Bad Request");
		return resultBean;
	}
	
	/**
	 * MySQLIntegrityConstraintViolationException Handler function
	 * @param Exception
	 * @return ResultBean
	 * @throws 
	 */
	@ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Empty Required Parameter")
	public @ResponseBody ResultBean handleMySQLIntegrityConstraintViolationException(Exception ex) {
		logger.error("MySQLIntegrityConstraintViolationException : " + ex.getMessage());
		ResultBean resultBean = new ResultBean();
		resultBean.setStatusCode(3002);
		resultBean.setStatusMessage("Required Parameter Can not be Empty");
		return resultBean;
	}
	
	/**
	 * DuplicateDataException Handler function
	 * @param 
	 * @return ResultBean
	 * @throws 
	 */
	@ExceptionHandler(DuplicateEmailException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Email ID Already Exists")
//	public @ResponseBody ResultBean handleDuplicateDataException() {
	public void handleDuplicateDataException() {
		logger.error("DuplicateDataException : Duplicate Data Parameter");
		/*ResultBean resultBean = new ResultBean();
		resultBean.setStatusCode(3003);
		resultBean.setStatusMessage("Email ID Already Exists");
		return resultBean;*/
	}

}
