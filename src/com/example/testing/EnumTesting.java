package com.example.testing;

public class EnumTesting {

	public enum Planet {

		MERCURY (3.7),
		VENUS (8.87),
		EARTH (9.8),
		MARS (3.71),
		JUPITER (24.92),
		SATURN (10.44),
		URANUS (8.87),
		NEPTUNE (11.15);

		double relativeGravity;

		Planet(double g) {
			relativeGravity = g;
		}
		
		void findYourWeight(double weightOnEarth) {
			double relativeWeightFactor = relativeGravity / Planet.EARTH.relativeGravity;
			System.out.println("Your relative weight: " + (weightOnEarth * relativeWeightFactor));
		}
	}



	public static void main(String[] args) {
		Planet p1 = Planet.JUPITER;
		p1.findYourWeight(0.39325842696629215 * 100);
	}
}
