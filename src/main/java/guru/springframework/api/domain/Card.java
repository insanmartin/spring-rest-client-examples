package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card implements Serializable
{
	private static final long serialVersionUID = -2927963757494339028L;
	
	private String type = null;
	private String number = null;
	private ExpirationDate expirationDate = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
