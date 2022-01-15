package uz.pdp.bankcardproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.bankcardproject.entity.Bankomat;
import uz.pdp.bankcardproject.entity.enums.Types;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    @NotNull
    private String cardNumber;

    @NotNull
    private String bankName;

    @NotNull
    private String fullName;

    @NotNull
    private Integer bankomat;

    private String types;

    @NotNull
    private String amalQilishMuddati;

    @NotNull
    private boolean active;
}
