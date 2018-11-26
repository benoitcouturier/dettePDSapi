package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;

public class Withdrawal_method implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int WM_id;
	private String WM_name;
	private Withdrawal_price WP;
	
	public int getWM_id() {
		return WM_id;
	}
	public void setWM_id(int wM_id) {
		WM_id = wM_id;
	}
	public String getWM_name() {
		return WM_name;
	}
	public void setWM_name(String wM_name) {
		WM_name = wM_name;
	}
	public Withdrawal_price getWP() {
		return WP;
	}
	public void setWP(Withdrawal_price wP) {
		WP = wP;
	}
	
	public Withdrawal_method(String wM_name, Withdrawal_price wP) {
		super();
		WM_name = wM_name;
		WP = wP;
	}
	public Withdrawal_method() {
	}
	
}
