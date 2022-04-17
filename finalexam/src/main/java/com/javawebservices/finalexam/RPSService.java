package com.javawebservices.finalexam;

import java.util.Random;

public class RPSService {

	
		public static String computerChoice() {
			Random rand = new Random();
			int randomNumber = rand.nextInt(2) + 1;
			
			switch(randomNumber) {
			case 0:
				return "rock";
						
			case 1:
				return "paper";
						
			case 2:
				return "scissors";
						
			}
			return null;
		}
		
	
		public static boolean validMove(String choice) {
			if(choice.equals("rock") || choice.equals("paper") || choice.equals("scissors")) {
				return true;
			}
			return false;
		}
		
		//Checks who wins the game.
		public static String whoWins(String choice) {
			String computerChoice = computerChoice();
			if(validMove(choice.toLowerCase())) {
				String playerChoice = choice;	
				if(playerChoice.equals("rock")) {
					if(computerChoice.equals("rock")) {
						RPSBean.setTies(RPSBean.getTies() +1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						return "{ \"Result\":\"Tie\"}";
					}
					if(computerChoice.equals("paper")) {
						RPSBean.setComputerScore(RPSBean.getComputerScore() + 1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						String pattern = "{ \"Player shows\":\"%s\", \n, \"Computer shows\":\"%s\", \n, \"Winner\":\"Computer\"}";
						return String.format(pattern, playerChoice, computerChoice);
					}
					if(computerChoice.equals("scissors")) {
						RPSBean.setPlayerScore(RPSBean.getPlayerScore() + 1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						String pattern = "{ \"Player shows\":\"%s\", \n, \"Computer shows\":\"%s\", \n, \"Winner\":\"Player\"}";
						return String.format(pattern, playerChoice, computerChoice);
					}
					
				}
				
				if(playerChoice.equals("paper")) {
					if(computerChoice.equals("rock")) {
						RPSBean.setPlayerScore(RPSBean.getPlayerScore() + 1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						String pattern = "{ \"Player shows\":\"%s\", \n, \"Computer shows\":\"%s\", \n, \"Winner\":\"Player\"}";
						return String.format(pattern, playerChoice, computerChoice);
					}
					if(computerChoice.equals("paper")) {
						RPSBean.setTies(RPSBean.getTies() +1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						return "{ \"Result\":\"Tie\"}";
					}
					if(computerChoice.equals("scissors")) {
						RPSBean.setComputerScore(RPSBean.getComputerScore() + 1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						String pattern = "{ \"Player shows\":\"%s\", \n, \"Computer shows\":\"%s\", \n, \"Winner\":\"Computer\"}";
						return String.format(pattern, playerChoice, computerChoice);
					}
				}
				
				if(playerChoice.equals("scissors")) {
					if(computerChoice.equals("rock")) {
						RPSBean.setComputerScore(RPSBean.getComputerScore() + 1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						String pattern = "{ \"Player shows\":\"%s\", \n, \"Computer shows\":\"%s\", \n, \"Winner\":\"Computer\"}";
						return String.format(pattern, playerChoice, computerChoice);
					}
					if(computerChoice.equals("paper")) {
						RPSBean.setPlayerScore(RPSBean.getPlayerScore() + 1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						String pattern = "{ \"Player shows\":\"%s\", \n, \"Computer shows\":\"%s\", \n, \"Winner\":\"Player\"}";
						return String.format(pattern, playerChoice, computerChoice);
					}
					if(computerChoice.equals("scissors")) {
						RPSBean.setTies(RPSBean.getTies() +1);
						RPSBean.setGames(RPSBean.getGames() + 1);
						return "{ \"Result\":\"Tie\"}";
					}
				}
			}return "bad input";
			
			

			
			
		}

}
