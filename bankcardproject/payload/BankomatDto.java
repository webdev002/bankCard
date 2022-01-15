package uz.pdp.bankcardproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.bankcardproject.entity.Card;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankomatDto {

    @NotNull
    private String language;

    @NotNull
    private String bankName;

    @NotNull
    private Long balance;

    @NotNull
    private List<CardDto> cardDtoList;
}
