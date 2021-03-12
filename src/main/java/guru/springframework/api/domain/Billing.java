package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Billing implements Serializable
{
	private static final long serialVersionUID = -4448018068264532737L;
	
	private Card card = null;
	private String iban = null;
	private String swift = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
