package com.example;

import java.util.*;
import java.io.IOException;

import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;

import com.example.scappeddata.Product;



public class Main {
    public static void main(String[] args) {
            // initializing the HTML Document page variable 
    Document doc;

    //fetching the target website
    try {
        doc = Jsoup.connect("https://www.scrapingcourse.com/ecommerce/")
        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
        .header("Accept-Language", "*")
        .get();
        //if the connection fails, Jsoup throws a IOException
    }catch(IOException e) {
        throw new RuntimeException(e);
    }
    //class has to be in the same package to be retrieved
    List<Product> products = new ArrayList<>(); 


    //The .select() method is used to select elements from the HTML document based on a CSS selector.
    Elements productElements = doc.select("li.product");
    //Elements is essentially an extension of ArrayList in Java. It stores a collection of HTML elements (in this case, <li class="product"> elements).
    //if connnection is made , then get() is gauranteed 

    for(Element productElement : productElements)
    {   
        //matched element with a given class
        Product product = new Product();
        //initialisign the products
        //setters
        product.setURL(productElement.selectFirst("a").attr("href"));
        product.setImage(productElement.selectFirst("img").attr("src"));
        product.setName(productElement.selectFirst("h2").text());
        product.setPrice(productElement.selectFirst("span").text());

        products.add(product);
        //selectFirst() kaha se aa gya

        for(Product pr : products)
        {
            System.out.println(pr);
        }

    }

    }
}
//website have anti scraping system 1] set of expected HTTP header 
//avoid being blocked using manually setting these HTTP headers
//Jsoup.connect(xxx) is not using HTTP ? 

//you should always set is the User-Agent header.
//This is a string that helps the server identifies the application[browser], operating system, and vendor from which the HTTP request comes from.

//Jsoup & browser both are a type of HTTP client - Jsoup is programitcally controlled
//.get() returns the paresed HTML