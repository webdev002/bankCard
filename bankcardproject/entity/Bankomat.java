package uz.pdp.bankcardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bankomat {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private Long balance;

    @OneToMany(mappedBy = "bankomat",cascade = CascadeType.ALL)
    private List<Card> card;

}
