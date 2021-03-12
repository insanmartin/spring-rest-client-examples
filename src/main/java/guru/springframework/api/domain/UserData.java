package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData implements Serializable 
{
	private static final long serialVersionUID = 5033865832826635699L;
	
	List<User> data;
}
