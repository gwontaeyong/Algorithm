package crolling;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProblemCrolling {

    String URL = "https://www.acmicpc.net/problem/tag/";
    int page = 1;

    String problems[];
    String percent[];

    ProblemCrolling(String tag){



    }

    public static void main(String[] args) {
        ProblemCrolling pc = new ProblemCrolling("BFS");
    }

}