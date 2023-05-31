package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Actor;

@RestController
@RequestMapping("/api/actor/")
public class ActorOperationsController {

	@GetMapping("/find/{id}")
	public ResponseEntity<Actor> getActorDetailById(@PathVariable("id") Integer actorId) {

		// write code to retirve actor from DB
		Actor actor = new Actor(actorId, "Paul Pogba", 28f, "Footballer");
		// Object will be convertred to JSON automatically by Message converter by
		// DispatcherServlet by taking hep of DispatcherServlet.
		// all this are auatomatically done, bacause we are using @RestController
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}
}
