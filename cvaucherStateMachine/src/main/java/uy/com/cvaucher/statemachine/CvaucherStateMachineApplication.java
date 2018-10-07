package uy.com.cvaucher.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import uy.com.cvaucher.statemachine.events.Events;
import uy.com.cvaucher.statemachine.states.States;

@SpringBootApplication
public class CvaucherStateMachineApplication implements CommandLineRunner {

	@Autowired
	private StateMachine<States, Events> stateMachine;
	
	public static void main(String[] args) {
		SpringApplication.run(CvaucherStateMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    stateMachine.sendEvent(Events.E1);
	    stateMachine.sendEvent(Events.E2);
	}
}
