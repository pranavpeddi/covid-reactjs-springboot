package com.Pranav.Backend.PlayGround;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Pg {

    public static void main(String [] args)throws IOException
    {
        final String url="https://www.mygov.in/covid-19";
        Document doc= Jsoup.connect(url).get();
     //   System.out.println(doc.getElementsByClass("testing_result").select(""));

      Elements links=doc.getElementsByClass("testing_result");

        for(Element ele: links)
        {
            System.out.println("samples tested till  today:"+ele.getElementsByClass("testing_count").text());
        }


        Elements links2=doc.getElementsByClass("testing_sample");

        for(Element ele: links2)
        {
            System.out.println("samples tested today:"+ele.getElementsByClass("testing_count").text());
        }
    }
}
