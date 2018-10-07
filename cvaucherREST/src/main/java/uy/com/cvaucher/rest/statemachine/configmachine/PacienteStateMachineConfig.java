package uy.com.cvaucher.rest.statemachine.configmachine;

import java.util.EnumSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import uy.com.cvaucher.rest.statemachine.events.PacienteEvents;
import uy.com.cvaucher.rest.statemachine.states.PacienteStates;


@Configuration
@EnableStateMachine
public class PacienteStateMachineConfig extends EnumStateMachineConfigurerAdapter<PacienteStates, PacienteEvents>{
	
	@Override
	public void configure(StateMachineConfigurationConfigurer<PacienteStates, PacienteEvents> config) throws Exception{
		config
			.withConfiguration()
				.autoStartup(true)
				.listener(listener());
	}
	
	@Override
	public void configure(StateMachineStateConfigurer<PacienteStates, PacienteEvents> states) throws Exception{
		states
			.withStates()
				.initial(PacienteStates.S1)
					.states(EnumSet.allOf(PacienteStates.class));
	}
	
	@Override
    public void configure(StateMachineTransitionConfigurer<PacienteStates, PacienteEvents> transitions) throws Exception{
		transitions
        .withExternal()
            .source(PacienteStates.SI).target(PacienteStates.S1).event(PacienteEvents.E1)
            .and()
        .withExternal()
            .source(PacienteStates.S1).target(PacienteStates.S2).event(PacienteEvents.E2);
	}
	
	@Bean
	public StateMachineListener<PacienteStates, PacienteEvents> listener(){
		return new StateMachineListenerAdapter<PacienteStates, PacienteEvents>(){
			@Override
			public void stateChanged(State<PacienteStates,PacienteEvents> from, State<PacienteStates,PacienteEvents> to) {
				 System.out.println("State change to " + to.getId());
			}
		};
	}
}
