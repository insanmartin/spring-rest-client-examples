package guru.springframework.springrestclientexamples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import guru.springframework.springrestclientexamples.services.ApiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController 
{
    private ApiService apiService;

    public UserController( ApiService apiService )
    {
        this.apiService = apiService;
    }

    @GetMapping( { "", "/", "/index" } )
    public String index()
    {
        return "index";
    }

    //Reactive way of getting information is using ServerWebExchange
    @PostMapping( "/users" )
    public String formPost( Model model, ServerWebExchange serverWebExchange )
    {
    	log.debug( "Received formPost getUsers" );
/*    	
        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        Integer limit = Integer.parseInt( map.get( "limit" ).get(0) );

        log.debug("Received Limit value: " + limit);
        //default if null or zero
        if( limit == null || limit == 0 )
        {
            log.debug( "Setting limit to default of 10" );
            limit = 10;
        }

        model.addAttribute( "users", apiService.getUsers( limit ) );
*/
    	model.addAttribute( "users", 
    			apiService
    					.getUsers( serverWebExchange
    						.getFormData()
    						//instead of calling block, we map to the limit
    						.map( data -> Integer.parseInt( data.getFirst( "limit" ) ) ) ) );

        return "userlist";
    }
}