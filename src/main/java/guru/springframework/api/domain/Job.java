package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Job implements Serializable
{
	private static final long serialVersionUID = -8733179001517726063L;
	
	private String title = null;
	private String company = null;
	private Map<String, Object> additionalProperties = new HashMap<>();
}
