package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;

public class Withdrawal_price implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int WP_id;
	private int WP_distance;
	private int WP_price;
	
	public int getWP_id() {
		return WP_id;
	}
	public void setWP_id(int wP_id) {
		WP_id = wP_id;
	}
	public int getWP_distance() {
		return WP_distance;
	}
	public void setWP_distance(int wP_distance) {
		WP_distance = wP_distance;
	}
	public int getWP_price() {
		return WP_price;
	}
	public void setWP_price(int wP_price) {
		WP_price = wP_price;
	}
	
	public Withdrawal_price(int wP_distance, int wP_price) {
		super();
		WP_distance = wP_distance;
		WP_price = wP_price;
	}
	public Withdrawal_price(int wP_id, int wP_distance, int wP_price) {
		super();
		WP_id = wP_id;
		WP_distance = wP_distance;
		WP_price = wP_price;
	}
	public Withdrawal_price() {
	}

}
