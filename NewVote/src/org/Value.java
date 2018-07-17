package org;

public class Value {
	public static int r=227;
	public static int d=206;
	
	public static int yes_vote1 = 300;
	public static int no_vote1 = 123;
	public static int avoided_vote1 = 10;
	
	public static int yes_vote1_D = 87;
	public static int no_vote1_D = 112;
	public static int avoided_vote1_D = 7;
	
	public static int yes_vote1_R = 213;
	public static int no_vote1_R = 11;
	public static int avoided_vote1_R = 3;
	
	public static int yes_vote2 = 283;
	public static int no_vote2 = 138;
	public static int avoided_vote2 = 13;
	
	public static int yes_vote2_D = 64;
	public static int no_vote2_D = 132;
	public static int avoided_vote2_D = 10;
	
	
	public static int yes_vote2_R = 219;
	public static int no_vote2_R = 5;
	public static int avoided_vote2_R = 13;
	
	public static int yes_vote3 = 247;
	public static int no_vote3 = 175;
	public static int avoided_vote3 = 12;
	
	public static int yes_vote3_D = 41;
	public static int no_vote3_D = 157;
	public static int avoided_vote3_D = 8;
	
	public static int yes_vote3_R = 206;
	public static int no_vote3_R = 17;
	public static int avoided_vote3_R = 4;
	
	public static int yes_vote4 = 242;
	public static int no_vote4 = 186;
	public static int avoided_vote4 = 6;
	
	public static int yes_vote4_D = 155;
	public static int no_vote4_D = 46;
	public static int avoided_vote4_D = 5;
	
	public static int yes_vote4_R = 87;
	public static int no_vote4_R = 139;
	public static int avoided_vote4_R = 1;

	public static float probability_of_r() {
		return (r/(r+d));
	}
	
	public static double probability_of_d() {
		return (d/(r+d));
	}
	
	public static double probability_of_y_vote1() {
		return (yes_vote1/(yes_vote1+no_vote1+avoided_vote1));
	}
	
	public double probability_of_n_vote1() {
		return (no_vote1/(yes_vote1+no_vote1+avoided_vote1));
	}
	public double probability_of_avoided_vote1() {
		return (avoided_vote1/(yes_vote1+no_vote1+avoided_vote1));
	}
	
	public double probability_of_y_vote2() {
		return (yes_vote2/(yes_vote2+no_vote2+avoided_vote2));
	}
	public double probability_of_n_vote2() {
		return (no_vote2/(yes_vote2+no_vote2+avoided_vote2));
	}
	public double probability_of_avoided_vote2() {
		return (avoided_vote2/(yes_vote2+no_vote2+avoided_vote2));
	}
	
	public double probability_of_y_vote3() {
		return (yes_vote3/(yes_vote3+no_vote3+avoided_vote3));
	}
	public double probability_of_n_vote3() {
		return (no_vote3/(yes_vote3+no_vote3+avoided_vote3));
	}
	public double probability_of_avoided_vote3() {
		return (avoided_vote3/(yes_vote3+no_vote3+avoided_vote3));
	}
	
	public double probability_of_y_vote4() {
		return (yes_vote4/(yes_vote4+no_vote4+avoided_vote4));
	}
	public double probability_of_n_vote4() {
		return (no_vote4/(yes_vote4+no_vote4+avoided_vote4));
	}
	public double probability_of_avoided_vote4() {
		return (avoided_vote4/(yes_vote4+no_vote4+avoided_vote4));
	}
	
	public double probability_of_y_vote1_D() {
		return (yes_vote1_D/(d));
	}
	public double probability_of_n_vote1_D() {
		return (no_vote1_D/(d));
	}
	public double probability_of_avoided_vote1_D() {
		return (avoided_vote1_D/(d));
	}
	
	public double probability_of_y_vote2_D() {
		return (yes_vote2_D/(d));
	}
	public double probability_of_n_vote2_D() {
		return (no_vote2_D/(d));
	}
	public double probability_of_avoided_vote2_D() {
		return (avoided_vote2_D/(d));
	}
	
	public double probability_of_y_vote3_D() {
		return (yes_vote3_D/(d));
	}
	public double probability_of_n_vote3_D() {
		return (no_vote3_D/(d));
	}
	public double probability_of_avoided_vote3_D() {
		return (avoided_vote3_D/(d));
	}
	
	public double probability_of_y_vote4_D() {
		return (yes_vote4_D/(d));
	}
	public double probability_of_n_vote4_D() {
		return (no_vote4_D/(d));
	}
	public double probability_of_avoided_vote4_D() {
		return (avoided_vote4_D/(d));
	}
	
	public double probability_of_y_vote1_R() {
		return (yes_vote1_R/(r));
	}
	public double probability_of_n_vote1_R() {
		return (no_vote1_R/(r));
	}
	public double probability_of_avoided_vote1_R() {
		return (avoided_vote1_R/(r));
	}
	
	public double probability_of_y_vote2_R() {
		return (yes_vote2_R/(r));
	}
	public double probability_of_n_vote2_R() {
		return (no_vote2_R/(r));
	}
	public double probability_of_avoided_vote2_R() {
		return (avoided_vote2_R/(r));
	}
	
	public double probability_of_y_vote3_R() {
		return (yes_vote3_R/(r));
	}
	public double probability_of_n_vote3_R() {
		return (no_vote3_R/(r));
	}
	public double probability_of_avoided_vote3_R() {
		return (avoided_vote3_R/(r));
	}
	
	

}
