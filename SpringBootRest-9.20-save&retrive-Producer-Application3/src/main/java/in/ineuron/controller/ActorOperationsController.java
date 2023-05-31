package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Actor;

@RestController
@RequestMapping("/api/actor/")
public class ActorOperationsController {

	/*
	 * TO test "/save" 
	 * 
	 * POST - http://localhost:9999/Producer-Application/api/actor/save
	 * { "aid" : 2, "name" : "Ozil", "age" : "33f", "type" : "cricketer" }
	 */

	@PostMapping("/save")
	public ResponseEntity<String> saveActor(@RequestBody Actor actor) {
		System.out.println(actor);
		System.out.println("------Actor object is saved");
		return new ResponseEntity<String>("actor object is saved with :" + actor.getAid(), HttpStatus.OK);
	}
}
