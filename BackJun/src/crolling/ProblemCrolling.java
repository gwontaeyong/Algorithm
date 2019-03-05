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

        URL += tag;
        Document doc = null;

        outer: while (true) {
            // proList.clear();


            try {

                doc = Jsoup.connect(URL + page).get();

                Elements problemLists = doc.getElementsByClass("problem-list");

                Element problemList = problemLists.get(0);
                Elements widgetBoxList = problemList.getElementsByClass("widget-box-sub");

                for (Element problem : widgetBoxList) {

                    if (problem.getElementsByClass("week_num").size() == 0)
                        break outer;

                    Element week_num = problem.getElementsByClass("week_num").get(0);
                    Element percent = problem.getElementsByClass("code-sub-mum").get(2);

                    float percentigy = Float.parseFloat(percent.text().substring(0, percent.text().length() - 1));
                    String number = week_num.text().substring(0, week_num.text().length() - 1);

                    if (percentigy <= maxDif && percentigy >= minDif)
                        proList.add(number);

                }

                page++;

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                break;
            }

        }

        while (idx < proList.size()) {

            if (problemCount == 3) {
                System.out.println(line);
                line = "";
                problemCount = 0;

            }

            line += proList.get(idx) + " ";
            problemCount++;
            idx++;
        }

        System.out.println(line);

        System.out.println(proList);
        System.out.println("difficult 3");




















    }

    public static void main(String[] args) {
        ProblemCrolling pc = new ProblemCrolling("BFS");
    }

}