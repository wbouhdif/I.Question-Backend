//package spineapp.backend.services;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class RegistrationService {
//    private EmailValidatorService emailValidatorService;
//    public String register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidatorService.test(request.getEmail());
//        if (!isValidEmail) {
//            throw new IllegalStateException("email not valid");
//        }
//        return "it works";
//    }
//}
