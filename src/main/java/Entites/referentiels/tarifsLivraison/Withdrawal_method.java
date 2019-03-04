package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;

public class Withdrawal_method implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int WM_id;
	private String WM_name;
	private float WM_price;
	private int WM_distance_min;
	private int WM_distance_max;
	private int WM_estimated_delivery_min;
	private int WM_estimated_delivery_max;
	
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
	public float getWM_price() {
		return WM_price;
	}
	public void setWM_price(float wM_price) {
		WM_price = wM_price;
	}
	public int getWM_distance_min() {
		return WM_distance_min;
	}
	public void setWM_distance_min(int wM_distance_min) {
		WM_distance_min = wM_distance_min;
	}
	public int getWM_distance_max() {
		return WM_distance_max;
	}
	public void setWM_distance_max(int wM_distance_max) {
		WM_distance_max = wM_distance_max;
	}
	public int getWM_estimated_delivery_min() {
		return WM_estimated_delivery_min;
	}
	public void setWM_estimated_delivery_min(int wM_estimated_delivery_min) {
		WM_estimated_delivery_min = wM_estimated_delivery_min;
	}
	public int getWM_estimated_delivery_max() {
		return WM_estimated_delivery_max;
	}
	public void setWM_estimated_delivery_max(int wM_estimated_delivery_max) {
		WM_estimated_delivery_max = wM_estimated_delivery_max;
	}
	public Withdrawal_method(int wM_id, String wM_name, float wM_price, int wM_distance_min, int wM_distance_max,
			int wM_estimated_delivery_min, int wM_estimated_delivery_max) {
		super();
		WM_id = wM_id;
		WM_name = wM_name;
		WM_price = wM_price;
		WM_distance_min = wM_distance_min;
		WM_distance_max = wM_distance_max;
		WM_estimated_delivery_min = wM_estimated_delivery_min;
		WM_estimated_delivery_max = wM_estimated_delivery_max;
	}
	public Withdrawal_method(int wM_id) {
		super();
		WM_id = wM_id;
		
	}
	public Withdrawal_method() {
		super();
	}
	

}
	
	