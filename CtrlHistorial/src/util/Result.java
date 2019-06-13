/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author apple
 */
public class Result  <T>{
    
    private boolean operationStatus;
    private String message;
    private T result;

    
    /**
	 * constructor vacio
	 */
	public Result() {
		super();
	}
	
	/**
	 * @param operationStatus
	 */
	public Result(Boolean operationStatus) {
		this.operationStatus=operationStatus;
	}

	
	/**
	 * @param operationStatus
	 * @param message
	 * @param result
	 */
	public Result(Boolean operationStatus,String message,T result) {
		this.operationStatus=operationStatus;
		this.message=message;
		this.result=result;
	}

    /**
     * @return the operationStatus
     */
    public boolean isOperationStatus() {
        return operationStatus;
    }

    /**
     * @param operationStatus the operationStatus to set
     */
    public void setOperationStatus(boolean operationStatus) {
        this.operationStatus = operationStatus;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the result
     */
    public T getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(T result) {
        this.result = result;
    }
    
    
    
    
    
}
