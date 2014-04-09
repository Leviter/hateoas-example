package hello;

import hello.domain.model.Greeting;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";

//	@RequestMapping(method = RequestMethod.GET, produces = "application/vnd+com.bva-auctions.api+json;version=1.1", headers = "Accept:application/vnd+com.bva-auctions.api+json;version=1.1")
//	@RequestMapping(value = "/greeting", method= RequestMethod.GET, headers = "Accept:application/vnd.com.bva-auctions.api+json;version=1.1", produces = {"application/vnd.com.bva-auctions.api+json;version=1.1"})
//	@RequestMapping(value = "/greeting11", method= RequestMethod.GET, consumes = "application/vnd.com.bva-auctions.api+json;version=1.1", produces = {"application/vnd.com.bva-auctions.api+json;version=1.1"})
	@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = { "application/vnd.com.bva-auctions.api+json"}, headers = "version=1.1")
	@ResponseBody
	public HttpEntity<Greeting> greetingOld(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.GET, produces = "application/vnd+com.bva-auctions.api+json;version=1.0", headers = "Accept:application/vnd+com.bva-auctions.api+json;version=1.0")
	@RequestMapping(value = "/greeting", method= RequestMethod.GET, produces = { "application/vnd.com.bva-auctions.api+json"}, headers = "version=1.0" )
	@ResponseBody
	public HttpEntity<Greeting> greetingOldest(
			@RequestParam(value = "name", required = false, defaultValue = "Ancient World") String name) {

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

	@RequestMapping(value = "/greeting", method= RequestMethod.GET, produces = { "application/vnd.com.bva-auctions.api+json"}, headers = "version=2.0" )
	@ResponseBody
	public HttpEntity<Greeting> greeting(
			@RequestParam(value = "name", required = false, defaultValue = "Cruel World") String name) {

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

	@RequestMapping(value = "/greeting", method= RequestMethod.GET, produces = { "application/vnd.com.bva-auctions.api+json"})
	@ResponseBody
	public HttpEntity<Greeting> greetingGeneric(
			@RequestParam(value = "name", required = false, defaultValue = "Galaxy") String name) {

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}
}