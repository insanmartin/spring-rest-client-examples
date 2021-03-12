package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name implements Serializable
{
	private static final long serialVersionUID = -2412483134328140008L;
	
	private String title = null;
	private String first = null;
	private String last = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
