package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location implements Serializable
{
	private static final long serialVersionUID = -8487302089081033040L;
	
	private String street = null;
	private String city = null;
	private String state = null;
	private String postCode = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
