package uz.pdp.bankcardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.bankcardproject.entity.enums.Types;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String types;

    @Column(nullable = false)
    private String amalQilishMuddati;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Bankomat bankomat;

    @Column(nullable = false)
    private boolean active;

    public Card(String cardNumber, String bankName, String fullName,String  types, String amalQilishMuddati, boolean active, Bankomat bankomat) {
        this.cardNumber=cardNumber;
        this.bankName=bankName;
        this.fullName=fullName;
        this.amalQilishMuddati=amalQilishMuddati;
        this.active=active;
        this.bankomat=bankomat;
        this.types=types;
    }
}
