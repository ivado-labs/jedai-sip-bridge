package org.chusj.crhsj.sip_bridge.controller_advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class GeneralControllerAdvice implements ResponseBodyAdvice<Object> {
  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object body,
                                MethodParameter returnType, MediaType selectedContentType,
                                Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                ServerHttpRequest request, ServerHttpResponse response) {
    if (returnType.getContainingClass().isAnnotationPresent(RestController.class)) {
      if (body == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            String.format("Unable to find %s for query %s", returnType.getParameterType().getSimpleName(),
                ((ServletServerHttpRequest) request).getServletRequest().getQueryString()));
      }
    }
    return body;
  }
}
