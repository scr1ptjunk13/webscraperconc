package com.example;

import java.util.*;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import com.example.scappeddata.Product;

public class Main {
    private static Document doc;

    public static void main(String[] args) {
        initializeDocument();
        interactiveTester();
    }

    private static void initializeDocument() {
        try {
            doc = Jsoup.connect(ConfigLoader.getProperty("base_url"))
                .userAgent(ConfigLoader.getProperty("user_agent"))
                .header("Accept-Language", ConfigLoader.getProperty("accept_language"))
                .get();
        } catch(IOException e) {
            throw new RuntimeException("Failed to connect to the website", e);
        }
    }

    private static void interactiveTester() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter a CSS selector (or 'quit' to exit):");
            String selector = scanner.nextLine();

            if (selector.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                Elements elements = doc.select(selector);
                System.out.println("Found " + elements.size() + " elements:");
                for (Element element : elements) {
                    System.out.println(element.outerHtml());
                }
            } catch (Exception e) {
                System.out.println("Error with selector: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // private static void scrapeProducts() {
    //     List<Product> products = new ArrayList<>();
    //     Elements productElements = doc.select("li.product");
        
    //     for(Element productElement : productElements) {
    //         Product product = new Product();
    //         product.setURL(productElement.selectFirst("a").attr("href"));
    //         product.setImage(productElement.selectFirst("img").attr("src"));
    //         product.setName(productElement.selectFirst("h2").text());
    //         product.setPrice(productElement.selectFirst("span").text());
    //         products.add(product);
    //     }

    //     // Print or process the products as needed
    //     for (Product product : products) {
    //         System.out.println(product);
    //     }
    // }
}