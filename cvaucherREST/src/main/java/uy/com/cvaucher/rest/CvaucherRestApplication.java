package uy.com.cvaucher.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import uy.com.cvaucher.rest.statemachine.events.PacienteEvents;
import uy.com.cvaucher.rest.statemachine.states.PacienteStates;

@SpringBootApplication
public class CvaucherRestApplication implements CommandLineRunner{

	@Autowired
	private StateMachine<PacienteStates, PacienteEvents> stateMachine;
	
	public static void main(String[] args) {
		SpringApplication.run(CvaucherRestApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		stateMachine.sendEvent(PacienteEvents.E1);
		stateMachine.sendEvent(PacienteEvents.E2);
	}
}
