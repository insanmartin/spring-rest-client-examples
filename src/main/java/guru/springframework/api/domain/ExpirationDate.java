package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpirationDate implements Serializable
{
	private static final long serialVersionUID = -8518983643888335049L;
	
	private String date = null;
	private int timezoneType = -1;
	private String timezone = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
