package crolling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class TagCrolling {

    final String URL = "https://www.acmicpc.net/problem/tags";
    String tags[];

    TagCrolling(){

        Document doc = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements element = doc.select(".table-bordered");
        Elements elements = element.select("a");

        tags = new String[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            tags[i] = elements.get(i).text();
        }


    }

    public void showTags(){
        for (String tag : tags){
            System.out.println(tag);
        }
    }

    public String[] getTags() {
        return tags;
    }

    public static void main(String[] args) {
        // Jsoup를 이용해서 네이버 스포츠 크롤링
        TagCrolling tc = new TagCrolling();
        tc.showTags();
    }

}

