package cvv.project.foodlog.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class UserPersonalInfo {
    private String name;
    private BigDecimal weight;
    private Character sex;
    private String goal; //bulk/cut/maintain
}
