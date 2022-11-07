package com.example.mangodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Customer Id Not Found")
public class CustomerNotFoundException extends Exception{


}
