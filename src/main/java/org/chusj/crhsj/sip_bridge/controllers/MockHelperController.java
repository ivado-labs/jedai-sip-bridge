package org.chusj.crhsj.sip_bridge.controllers;


import java.io.IOException;
import org.chusj.crhsj.sip_bridge.exceptions.RestException;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@RestController
public class MockHelperController {

  private final ResourceLoader resourceLoader;

  public MockHelperController(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  @GetMapping(value = "/file/{fileName}", produces = "text/csv")
  public byte[] downloadFile(@PathVariable String fileName) {
    try {
      return this.resourceLoader.getResource(String.format("classpath:db/excel_files/%s.csv", fileName)).getInputStream().readAllBytes();
    } catch (IOException e) {
      throw new RestException(HttpStatus.NOT_FOUND, "Not Found");
    }
  }

}
