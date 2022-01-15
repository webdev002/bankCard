package uz.pdp.bankcardproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.bankcardproject.entity.Bankomat;
import uz.pdp.bankcardproject.entity.Card;
import uz.pdp.bankcardproject.entity.enums.Types;
import uz.pdp.bankcardproject.payload.ApiResponse;
import uz.pdp.bankcardproject.payload.BankomatDto;
import uz.pdp.bankcardproject.payload.CardDto;
import uz.pdp.bankcardproject.repository.BankomatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankomatService {
    @Autowired
    BankomatRepository bankomatRepository;

    public List<Bankomat> getBankomat() {
        List<Bankomat> bankomatList = bankomatRepository.findAll();
        return bankomatList;
    }

    public ApiResponse addBankomat(BankomatDto bankomatDto) {
        //BANKOMAT
        Bankomat bankomat = new Bankomat();
        bankomat.setLanguage(bankomatDto.getLanguage());
        bankomat.setBankName(bankomatDto.getBankName());
        bankomat.setBalance(bankomatDto.getBalance());

        //CARD
        List<Card> cardList =new ArrayList<>();
        for (CardDto cardDto : bankomatDto.getCardDtoList()) {
            Card card =new Card(
                    cardDto.getCardNumber(),
                    cardDto.getBankName(),
                    cardDto.getTypes(),
                    cardDto.getFullName(),
                    cardDto.getAmalQilishMuddati(),
                    cardDto.isActive(),
                    bankomat
            );
            cardList.add(card);
        }
        bankomat.setCard(cardList);
        bankomatRepository.save(bankomat);
        return new ApiResponse("Saqlandi",true);

    }
}
