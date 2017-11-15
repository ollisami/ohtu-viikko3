package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "00000000";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();

        url = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String courseInfoText = Request.Get(url).execute().returnContent().asString();
        
        url = "https://studies.cs.helsinki.fi/ohtustats/stats";
        String statsResponse = Request.Get(url).execute().returnContent().asString();
        
        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        CourseInfo info = mapper.fromJson(courseInfoText, CourseInfo.class);
        
        System.out.println("Kurssi: " + info.getName() + ", " + info.getTerm());
        
        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        
        int taskCount = 0;
        int hoursCount = 0;
        
        for (Submission submission : subs) {
            submission.setExercisesCount(info.getExercises()[submission.getWeek()-1]);
            taskCount  += submission.getExercises().length;
            hoursCount += submission.getHours();
            System.out.println(submission);
        }
        System.out.println("");
        System.out.println("Yhteensä " + taskCount + " tehtävää, " + hoursCount + " tuntia");

        int student = 0;
        int total   = 0;
        
        for (int i = 1; i <= parsittuData.keySet().size(); i++) {
            student += parsittuData.get("" + i).getAsJsonObject().get("students").getAsInt();
            total   += parsittuData.get("" + i).getAsJsonObject().get("exercise_total").getAsInt();
        }
        System.out.println("kurssilla yhteensä " + student + " palautusta, palautettuja tehtäviä " + total + " kpl");
    }
}