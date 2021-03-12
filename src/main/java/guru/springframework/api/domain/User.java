package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable
{
	private static final long serialVersionUID = -5029538761345854136L;
	
	private String gender = null;
	private Name name = null;
	private Location location = null;
	
	@Email
	private String email = null;
	private Login login = null;
	private String phone = null;
	private Job job = null;
	private Billing billing = null;
	private String language = null;
	private String currency = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
