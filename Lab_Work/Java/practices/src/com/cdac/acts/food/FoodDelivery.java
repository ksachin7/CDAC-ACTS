package com.cdac.acts.food;

class FoodDelivery{
	private String item;
	private double price;
	private long billNo;
	private static long billNoBase= 0101012300;
	FoodDelivery[] boughtFood= new FoodDelivery[5];
	private double total;

	public FoodDelivery(){
		this.item="";
		this.price=0.0;
	}

	public FoodDelivery(String item, double price){
		this.item=item;
		this.price=price;
	}

	public double buyFood(FoodDelivery[] food, int index){
		if(index>=0 && index<food.length){
			// System.out.println("Buying food...");
			for(int i=0; i<5; i++){
				if(i==index)
					boughtFood[i]=food[index];
			}
			
			total= total+food[index].price;

			billNo=++billNoBase;
			return total;
		}else{
			System.out.println("Invalid Input!");
			return -1;
		}
	}

	void generateBill(){
			billNo=++billNoBase;
			System.out.println("\nYour Bill");
			System.out.println("---------------------------");
			for(int i=0; i<boughtFood.length; i++){
				if(boughtFood[i] != null)
					System.out.print(boughtFood[i]+"\n");
			}
			System.out.println("---------------------------");
			System.out.println("Total: "+ total);
	}

	@Override
	public String toString(){
		return item+": "+price;
	}
	
	public static void main(String[] args){
		FoodDelivery fd= new FoodDelivery();
		FoodDelivery[] food;

		food= new FoodDelivery[5];
		food[0]= new FoodDelivery("Paneer Butter Masala", 350);
		food[1]= new FoodDelivery("Chole Bhature", 120);
		food[2]= new FoodDelivery("Garlic Naan", 90);
		food[3]= new FoodDelivery("Rajma rice", 100);
		food[4]= new FoodDelivery("Special Rice plate", 250);

		fd.buyFood(food, 0);
		fd.buyFood(food, 2);

		// System.out.println("Your Bill");
		// fd.generateBill(food, );

		fd.generateBill();
	}
}