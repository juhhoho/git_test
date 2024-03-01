package jpabook.jpashop.domain.Form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateForm {
    @Size(min=3, max=25)
    @NotEmpty(message = "사용자 ID는 필수 항목입니다")
    private String mid;

    @NotEmpty(message = "사용자 PW는 필수 항목입니다")
    private String mpw1;

    @NotEmpty(message = "사용자 PW 확인은  필수 항목입니다")
    private String mpw2;

    @NotEmpty(message = "사용자 E-MAIL은  필수 항목입니다")
    @Email
    private String email;




}
