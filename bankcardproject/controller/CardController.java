package uz.pdp.bankcardproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.bankcardproject.entity.Card;
import uz.pdp.bankcardproject.payload.ApiResponse;
import uz.pdp.bankcardproject.payload.CardDto;
import uz.pdp.bankcardproject.service.CardService;

import java.beans.IntrospectionException;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @GetMapping
    public HttpEntity<?> getCard(){
        List<Card> card = cardService.getCard();
        return ResponseEntity.ok(card);
    }

    @PreAuthorize(value = "hasAnyRole('DIRECTOR','CUSTOMER')")
    @PostMapping
     public HttpEntity<?> addCard(@RequestBody CardDto cardDto){
        ApiResponse apiResponse = cardService.addCard(cardDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','CUSTOMER')")
    @PutMapping("{id}")
    public HttpEntity<?> editCard(@PathVariable Integer id,@RequestBody CardDto cardDto){
        ApiResponse apiResponse = cardService.editCard(id, cardDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @DeleteMapping("{id}")
    public HttpEntity<?> deleteCard(@PathVariable Integer id){
        ApiResponse apiResponse = cardService.deleteCard(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:403).body(apiResponse);
    }
}
