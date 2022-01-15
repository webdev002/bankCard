package uz.pdp.bankcardproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.bankcardproject.entity.Bankomat;
import uz.pdp.bankcardproject.payload.ApiResponse;
import uz.pdp.bankcardproject.payload.BankomatDto;
import uz.pdp.bankcardproject.service.BankomatService;

import java.util.List;

@RestController
@RequestMapping("/api/bankomat")
public class BankomatController {
    @Autowired
    BankomatService bankomatService;

    @GetMapping
    public HttpEntity<?> getBankomat(){
        List<Bankomat> bankomat = bankomatService.getBankomat();
        return ResponseEntity.ok(bankomat);
    }

    @PostMapping
    public HttpEntity<?> addBankomat(@RequestBody BankomatDto bankomatDto){
        ApiResponse apiResponse = bankomatService.addBankomat(bankomatDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
