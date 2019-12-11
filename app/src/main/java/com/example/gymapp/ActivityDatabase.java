package com.example.gymapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Activity.class,setActivities.class},version = 1,exportSchema = false)
public abstract class ActivityDatabase extends RoomDatabase {

    public abstract AllActivityDAO AllActivityDAO();

    public abstract setActivitiesDAO setActivitiesDAO();

    private static ActivityDatabase instance;

    public static synchronized ActivityDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,ActivityDatabase.class,"GYMActivities")
                    .allowMainThreadQueries()
                    .addCallback(initalCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback initalCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            InitialAsynTask initialAsynTask=new InitialAsynTask(instance);
            initialAsynTask.execute();
        }
    };

    private static class InitialAsynTask extends AsyncTask<Void,Void, Void>{

        private AllActivityDAO allActivityDAO;

        public InitialAsynTask(ActivityDatabase db){
            allActivityDAO=db.AllActivityDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String link,desc;

            desc="A push-up can be completed anywhere and uses almost" +
                    " every muscle in the body, particularly your chest" +
                    " muscles. Frequent push-ups increase your functional" +
                    " and core strength and can help prevent back and shoulder injuries. ";
            link="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/mh-formcheck-index-social-1551985785.png";
            Activity activity=new Activity("Push-up",link,desc);
            allActivityDAO.insert(activity);


            desc="You are spoilt for choice when it comes to " +
                    "exercises that work the glutes, but according" +
                    " to research by the American Council on" +
                    " Exercise (ACE), the squat always comes out on top.";
            link="https://www.mensjournal.com/wp-content/uploads/mf/1280-squat-barbell-james-michelfelder_0.jpg?w=1200&h=1200&crop=1";
            activity=new Activity("The Squat",link,desc);
            allActivityDAO.insert(activity);


            desc="The abs are often the one area most people want " +
                    "to focus on with their training. For a long " +
                    "time sit ups were considered the best way to " +
                    "tone and strengthen your abs, however research " +
                    "found that completing sit ups alone would have " +
                    "little impact on toning your abs.";
            link="https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/08/08/14/istock-674564328.jpg";
            activity=new Activity("The Bicycle Manoeuvre",link,desc);
            allActivityDAO.insert(activity);


            link="https://i.ebayimg.com/images/g/5T8AAOSw-mdbfm0L/s-l640.jpg";
            desc="A great exercise to work your back is the pull-up." +
                    " This exercise targets the latissimus dorsi (lats)" +
                    " and rhomboids muscles of the back, however due to" +
                    " the nature of the movement, other muscles such as " +
                    "the biceps and deltoid are also utilised in the pull up.";
            activity=new Activity("The Back: Pull-Up",link,desc);
            allActivityDAO.insert(activity);

            link="http://www.inmotionlife.com/wp-content/uploads/Stability-Ball-Hamstring-Curl.jpg";
            desc="Completing Swiss ball hamstring curls are a good " +
                    "way to improve your hamstrings. To complete " +
                    "this exercise, put your feet on a Swiss ball, " +
                    "so that your heels are in a stable position on the ball,";
            activity=new Activity("Hamstrings: Swiss Ball Hamstring Curl",link,desc);
            allActivityDAO.insert(activity);

            link="https://media1.popsugar-assets.com/files/thumbor/wdgNrfin9tJHa2PwJOlMiljJdws/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2015/09/25/939/n/1922398/1a467384_Tricep-Dips.jpg";
            desc="When it comes to upper arms, most people think about the biceps, which run along the front of the arm. ";
            activity=new Activity("Upper Arms: Triceps Dips",link,desc);
            allActivityDAO.insert(activity);

            link="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/766/tone-thighs-1516988882.jpg?resize=480:*";
            desc="The lunge is an exercise that works a range of muscles, alongside improving core strength " +
                    "and flexibility; the lunge is also extremely effective in improving your thighs.";
            activity=new Activity("Thighs: The Lunge",link,desc);
            allActivityDAO.insert(activity);

            link="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/0607-side-plank-leg-lift-1441032989.jpg";
            desc="To tighten the muscles and reduce your risk of back pain, " +
                    "the side bridge is a good exercise to complete.";
            activity=new Activity("The Side Bridge",link,desc);
            allActivityDAO.insert(activity);

            link="https://cdn2.omidoo.com/sites/default/files/imagecache/full_width/images/bydate/20130703/shutterstock122087452.jpg";
            desc="Research at San Diego State University found that " +
                    "the single-leg squat was the move that most challenged " +
                    "the gluteus medius - the muscle in the hip.";
            activity=new Activity("The Single-Leg Squat",link,desc);
            allActivityDAO.insert(activity);

            return null;
        }
    }

}
