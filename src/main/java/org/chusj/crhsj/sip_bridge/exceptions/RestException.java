package org.chusj.crhsj.sip_bridge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestException extends ResponseStatusException {

  private final HttpStatus httpStatus;

  public RestException(HttpStatus httpStatus, String message) {
    super(httpStatus, message);
    this.httpStatus = httpStatus;
  }

  public RestException(Exception exception, HttpStatus httpStatus) {
    super(httpStatus,exception.getMessage(),exception);
    this.httpStatus = httpStatus;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}
