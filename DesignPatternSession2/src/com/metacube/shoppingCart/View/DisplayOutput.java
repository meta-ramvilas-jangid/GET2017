package com.metacube.shoppingCart.View;

public class DisplayOutput<T> {
	private static DisplayOutput display;

	public static DisplayOutput getInstance() {
		if (display == null) {
			synchronized (DisplayOutput.class) {
				if (display == null) {
					display = new DisplayOutput();
				}
			}
		}

		return display;
	}

	/**
	 * Display the output on the console
	 * 
	 * @param obj
	 */
	public void displayOutput(T obj) {
		System.out.println(obj);
	}
}
