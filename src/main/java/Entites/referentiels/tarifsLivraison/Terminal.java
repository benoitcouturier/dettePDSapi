package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;

public class Terminal implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int Terminal_id;
	private int Terminal_size;
	private Command Command;
	
	public int getTerminal_id() {
		return Terminal_id;
	}
	public void setTerminal_id(int terminal_id) {
		Terminal_id = terminal_id;
	}
	public int getTerminal_size() {
		return Terminal_size;
	}
	public void setTerminal_size(int terminal_size) {
		Terminal_size = terminal_size;
	}
	public Command getCommand() {
		return Command;
	}
	public void setCommand(Command command) {
		Command = command;
	}
	
	public Terminal(int terminal_size, Command command) {
		super();
		Terminal_size = terminal_size;
		Command = command;
	}
	public Terminal() {
	}
	

}
