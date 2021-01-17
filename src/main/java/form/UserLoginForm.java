package form;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class UserLoginForm {

	@NotBlank(message = "名字不能为空")
	private String username;

	@NotBlank(message = "密码不能为空")
	private String password;
}
