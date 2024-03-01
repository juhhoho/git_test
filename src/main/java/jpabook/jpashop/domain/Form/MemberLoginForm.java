package jpabook.jpashop.domain.Form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginForm {
    @NotEmpty(message = "사용자 ID는 필수 항목입니다")
    private String mid;

    @NotEmpty(message = "사용자 PW는 필수 항목입니다")
    private String mpw;
}
