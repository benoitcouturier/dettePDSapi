package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;

public class Withdrawal_method implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int WM_id;
	private String WM_name;
	private int WM_distance;
	private int WM_price;
	
	public Withdrawal_method(int wM_id, String wM_name, int wM_distance, int wM_price) {
		super();
		WM_id = wM_id;
		WM_name = wM_name;
		WM_distance = wM_distance;
		WM_price = wM_price;
	}
	
	public Withdrawal_method(int wM_id) {
		super();
		WM_id = wM_id;
	}
	
	public Withdrawal_method() {
		super();
	}
	
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
	public int getWM_distance() {
		return WM_distance;
	}
	public void setWM_distance(int wM_distance) {
		WM_distance = wM_distance;
	}
	public int getWM_price() {
		return WM_price;
	}
	public void setWM_price(int wM_price) {
		WM_price = wM_price;
	}
	
	
}
