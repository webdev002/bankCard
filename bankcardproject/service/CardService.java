package uz.pdp.bankcardproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.bankcardproject.entity.Card;
import uz.pdp.bankcardproject.entity.enums.Types;
import uz.pdp.bankcardproject.payload.ApiResponse;
import uz.pdp.bankcardproject.payload.CardDto;
import uz.pdp.bankcardproject.repository.CardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
   @Autowired
   CardRepository cardRepository;


    public List<Card> getCard() {
        List<Card> cardList = cardRepository.findAll();
        return cardList;
    }

    public ApiResponse addCard(CardDto cardDto) {
        Card card =new Card();
        card.setCardNumber(cardDto.getCardNumber());
        card.setBankName(cardDto.getBankName());
        card.setFullName(cardDto.getFullName());
        card.setTypes(cardDto.getTypes());
        card.setAmalQilishMuddati(cardDto.getAmalQilishMuddati());
        card.setActive(cardDto.isActive());
        cardRepository.save(card);
        return new ApiResponse("Saqlandi",true);
    }

    public ApiResponse editCard(Integer id, CardDto cardDto) {
        boolean exists = cardRepository.existsByCardNumberAndIdNot(cardDto.getCardNumber(), id);
        if (exists){
            return new ApiResponse("Bunday id lik card mavjud emas",false);
        }
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (optionalCard.isPresent()){
            Card card = optionalCard.get();
            card.setCardNumber(cardDto.getCardNumber());
            card.setBankName(cardDto.getBankName());
            card.setFullName(cardDto.getFullName());
            card.setTypes(cardDto.getTypes());
            card.setAmalQilishMuddati(cardDto.getAmalQilishMuddati());
            card.setActive(cardDto.isActive());
            cardRepository.save(card);
            return new ApiResponse("Card tahrirlandi",true);
        }
        return new ApiResponse("Error",false);
    }

    public ApiResponse deleteCard(Integer id) {
        cardRepository.deleteById(id);
        return new ApiResponse("Ochirildi",true);
    }
}
