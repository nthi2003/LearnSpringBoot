package userRest.userRest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import userRest.userRest.service.error.IdInvalidException;

@RestController
public class Home {

   @GetMapping("/")
   public  String Home() throws IdInvalidException {
       if(true) throw new IdInvalidException("check");
       return "Heee";
   }

}
