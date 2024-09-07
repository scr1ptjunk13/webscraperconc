package com.example.scappeddata;

public class Product extends Object{ //every class implicitly extends Object
    private String url; 
    private String image;
    private String name;
    private String price;

    //getters and setters

    public void setURL(String url){
      this.url = url;
    }
    public void setImage(String image){
      this.image = image;
    }
    public void setName(String name){
      this.name = name;
    }
    public void setPrice(String price){
      this.price = price;
    }

    //??
    public String toString() { 
		return "{ \"url\":\"" + url + "\", " 
				+ " \"image\": \"" + image + "\", " 
				+ "\"name\":\"" + name + "\", " 
				+ "\"price\": \"" + price + "\" }"; 
	} 
  //add funcitons ?

}


//theory

//toString() is a method that is already defined in Java. It is part of the Object class, which is the root class for all Java objects.
// Since every class in Java implicitly extends Object, the toString() method is available in every class.