package hello;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class Greeting extends ResourceSupport {

	private final String content;

	public Greeting(String content) {
		this.content = content;
	}
}
