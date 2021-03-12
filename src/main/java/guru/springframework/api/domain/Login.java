package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login implements Serializable 
{
	private static final long serialVersionUID = -6298070203140118037L;
	
	private String username = null;
	private String password = null;
	private String md5 = null;
	private String sha1 = null;
	private String sha256 = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
