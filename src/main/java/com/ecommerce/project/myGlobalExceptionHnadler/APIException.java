package com.ecommerce.project.myGlobalExceptionHnadler;

public class APIException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public APIException() {
	}

	public APIException(String message) {
// EXPLANATION OF SUPER KEYWORD
// HERE THE RuntimeException IS THE SUPER CLASS
// AND THIS CLASS HAS THE CONSTRUCTOR 
// calling the constructor of the parent class (in this case, RuntimeException)
//that takes a message as a parameter.
		// i am doing changes
		
		super(message);
		
	}

}
