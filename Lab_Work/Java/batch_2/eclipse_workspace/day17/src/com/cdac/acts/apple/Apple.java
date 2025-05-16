package com.cdac.acts.apple;

import java.util.Objects;

public class Apple {
	private String colour;
	private Double Weight;
	private String tatse;

	public Apple(String colour, Double weight, String tatse) {
		this.colour = colour;
		Weight = weight;
		this.tatse = tatse;
	}


	@Override
	public String toString() {
		return colour+"Apple [colour=" + colour + ", Weight=" + Weight + ", tatse=" + tatse + "]\n";
	}


	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Double getWeight() {
		return Weight;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public String getTatse() {
		return tatse;
	}

	public void setTatse(String tatse) {
		this.tatse = tatse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Weight, colour, tatse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		return Objects.equals(Weight, other.Weight) && Objects.equals(colour, other.colour)
				&& Objects.equals(tatse, other.tatse);
	}

}
