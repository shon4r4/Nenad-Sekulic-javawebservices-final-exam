package com.javawebservices.finalexam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rpsgame")
public class RPSController {

	//Method to post users choice.
	@RequestMapping(value="/choice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String userInput(@RequestParam(value="choice",defaultValue = "rock") String choice) {
		return RPSService.whoWins(choice.toLowerCase());
	}
	
	//Shows the results from recent games.
	@RequestMapping(value="/result", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public String result() {
		String pattern = "{ \"Player score\":\"%s\", \n, \"Computer Score\":\"%s\", \n, \"Games played\":\"%s\", \n, \"Ties\":\"%s\" }";
		return String.format(pattern, RPSBean.getPlayerScore(), RPSBean.getComputerScore(), RPSBean.getGames(), RPSBean.getTies());

	}
}