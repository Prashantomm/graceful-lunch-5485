package com.masai.exceptions;

public class DuplicateEntry extends Exception{
	private static final long serialVersionUID = 1L;

	public DuplicateEntry(String msg) {
        super(msg);
    }
}