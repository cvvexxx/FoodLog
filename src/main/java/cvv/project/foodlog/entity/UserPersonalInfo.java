package cvv.project.foodlog.entity;

import cvv.project.foodlog.model.Goal;
import cvv.project.foodlog.model.Sex;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.*;

import java.math.BigDecimal;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPersonalInfo {
    private String name;
    private BigDecimal height;
    private BigDecimal weight;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    private Goal goal;
    @Transient
    private Integer age;
}

