package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;

public class Command_state implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int CommandS_id;
	private String CommandS_name;
	
	public int getCommandS_id() {
		return CommandS_id;
	}
	public void setCommandS_id(int commandS_id) {
		CommandS_id = commandS_id;
	}
	public String getCommandS_name() {
		return CommandS_name;
	}
	public void setCommandS_name(String commandS_name) {
		CommandS_name = commandS_name;
	}
	public Command_state(String commandS_name) {
		super();
		CommandS_name = commandS_name;
	}
	public Command_state(int commandS_id, String commandS_name) {
		super();
		CommandS_id = commandS_id;
		CommandS_name = commandS_name;
	}
	public Command_state() {
	}
	
	
	
}
