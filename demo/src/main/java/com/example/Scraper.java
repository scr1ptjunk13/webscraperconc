package com.example;

// html parsing and data extraction

import java.util.*;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
// import com.example.scappeddata.Product;

public class Scraper {
    //static - i feel it'll interfere with the concurrency - we'll see that later

    private Document doc;
    public static void connect(String url){
        
        doc = Jsoup.connect(url);

    }

    // layer 1 extraction
    public static void select(String selector){

    }

    //layer 2 extraction
    public static void extractData(Element element , String attr)
    {

    }
}
