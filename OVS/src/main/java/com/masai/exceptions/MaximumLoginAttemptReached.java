package com.masai.exceptions;

public class MaximumLoginAttemptReached extends Exception{
	private static final long serialVersionUID = 1L;

	public MaximumLoginAttemptReached(String msg) {
		super(msg);
	}
}
