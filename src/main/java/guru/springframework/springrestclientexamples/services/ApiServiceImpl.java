package guru.springframework.springrestclientexamples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService
{
	private RestTemplate restTemplate;
	
	//"http://private-anon-76745767f6-apifaketory.apiary-mock.com/api/user?limit="
	private final String api_url;

	public ApiServiceImpl( RestTemplate restTemplate, @Value( "${api.url}" ) String api_url )
	{
		super();
		this.restTemplate = restTemplate;
		this.api_url = api_url;
	}

	@Override
	public List<User> getUsers(Integer limit)
	{
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
												.fromUriString( api_url )
												.queryParam( "limit", limit );
		
		UserData userData = restTemplate.getForObject( uriBuilder.toUriString(), UserData.class );
		return userData.getData();
	}
	
	@Override
	public Flux<User> getUsers( Mono<Integer> limit )
	{
		return WebClient
				//use this uri
				.create( api_url )
				//method to use: get
				.get()
				//add parameter to uri
				.uri( UriBuilder -> UriBuilder.queryParam( "limit", limit.block() ).build() )
				.accept( MediaType.APPLICATION_JSON )
				//exchange between the WebClient and the server side
				.exchange()
				//takes the response and map to a Mono of UserData.class type
				.flatMap( resp -> resp.bodyToMono( UserData.class ) )
				//creates the flux of users using method getData (return List<Users>)
				.flatMapIterable( UserData::getData );
	}
}
