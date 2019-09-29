package com.example.gymapp;

import java.util.ArrayList;

public class Utility {
    private static ArrayList<Activity> allActivities;
   // private static ArrayList<Activity> planedActivities=new ArrayList<>();
    public static int noOfActivitiesplanned;


    private static ArrayList<Activity> monActivities;
    private static ArrayList<Activity> tueActivities;
    private static ArrayList<Activity> wedActivities;
    private static ArrayList<Activity> friActivities;
    private static ArrayList<Activity> thurActivities;
    private static ArrayList<Activity> satActivities;


    public Utility() {
        if(monActivities==null){
            monActivities=new ArrayList<>();
        }
        if(tueActivities==null){
            tueActivities=new ArrayList<>();
        }
        if(wedActivities==null){
            wedActivities=new ArrayList<>();
        }
        if(thurActivities==null){
            thurActivities=new ArrayList<>();
        }
        if(friActivities==null){
            friActivities=new ArrayList<>();
        }
        if(satActivities==null){
            satActivities=new ArrayList<>();
        }
        if(allActivities==null){
            allActivities=new ArrayList<>();
            intializeAll();
        }

    }

    public static int getNoOfActivitiesplanned() {
        return noOfActivitiesplanned;
    }

    public static void setNoOfActivitiesplanned(int noOfActivitiesplanned) {
        Utility.noOfActivitiesplanned = noOfActivitiesplanned;
    }

    public static ArrayList<Activity> getMonActivities() {
        return monActivities;
    }

    public Boolean addmonActivity(Activity a){
        return monActivities.add(a);
    }

    public Boolean removemonActivity(Activity a){
        return monActivities.remove(a);
    }

    public static ArrayList<Activity> getTueActivities() {
        return tueActivities;
    }

    public Boolean addtueActivity(Activity a){
        return tueActivities.add(a);
    }

    public Boolean removetueActivity(Activity a){
        return tueActivities.remove(a);
    }

    public static ArrayList<Activity> getWedActivities() {
        return wedActivities;
    }

    public Boolean addwedActivity(Activity a){
        return wedActivities.add(a);
    }

    public Boolean removewedActivity(Activity a){
        return wedActivities.remove(a);
    }

    public static ArrayList<Activity> getFriActivities() {
        return friActivities;
    }

    public Boolean addfriActivity(Activity a){
        return friActivities.add(a);
    }

    public Boolean removefriActivity(Activity a){
        return friActivities.remove(a);
    }

    public static ArrayList<Activity> getThurActivities() {
        return thurActivities;
    }

    public Boolean addthurActivity(Activity a){
        return thurActivities.add(a);
    }

    public Boolean removethurActivity(Activity a){
        return thurActivities.remove(a);
    }

    public static ArrayList<Activity> getSatActivities() {
        return satActivities;
    }

    public Boolean addsatActivity(Activity a){
        return satActivities.add(a);
    }

    public Boolean removesatActivity(Activity a){
        return satActivities.remove(a);
    }


    public static ArrayList<Activity> getAllActivities() {
        return allActivities;
    }

    public void intializeAll(){
        String link,desc;

        desc="A push-up can be completed anywhere and uses almost" +
                " every muscle in the body, particularly your chest" +
                " muscles. Frequent push-ups increase your functional" +
                " and core strength and can help prevent back and shoulder injuries. ";
        link="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/mh-formcheck-index-social-1551985785.png";
        Activity activity=new Activity("Push-up",link,desc);
        allActivities.add(activity);


        desc="You are spoilt for choice when it comes to " +
                "exercises that work the glutes, but according" +
                " to research by the American Council on" +
                " Exercise (ACE), the squat always comes out on top.";
        link="https://www.mensjournal.com/wp-content/uploads/mf/1280-squat-barbell-james-michelfelder_0.jpg?w=1200&h=1200&crop=1";
        activity=new Activity("The Squat",link,desc);
        allActivities.add(activity);


        desc="The abs are often the one area most people want " +
                "to focus on with their training. For a long " +
                "time sit ups were considered the best way to " +
                "tone and strengthen your abs, however research " +
                "found that completing sit ups alone would have " +
                "little impact on toning your abs.";
        link="https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/08/08/14/istock-674564328.jpg";
        activity=new Activity("The Bicycle Manoeuvre",link,desc);
        allActivities.add(activity);


        link="https://i.ebayimg.com/images/g/5T8AAOSw-mdbfm0L/s-l640.jpg";
        desc="A great exercise to work your back is the pull-up." +
                " This exercise targets the latissimus dorsi (lats)" +
                " and rhomboids muscles of the back, however due to" +
                " the nature of the movement, other muscles such as " +
                "the biceps and deltoid are also utilised in the pull up.";
        activity=new Activity("The Back: Pull-Up",link,desc);
        allActivities.add(activity);

        link="http://www.inmotionlife.com/wp-content/uploads/Stability-Ball-Hamstring-Curl.jpg";
        desc="Completing Swiss ball hamstring curls are a good " +
                "way to improve your hamstrings. To complete " +
                "this exercise, put your feet on a Swiss ball, " +
                "so that your heels are in a stable position on the ball,";
        activity=new Activity("Hamstrings: Swiss Ball Hamstring Curl",link,desc);
        allActivities.add(activity);

        link="https://media1.popsugar-assets.com/files/thumbor/wdgNrfin9tJHa2PwJOlMiljJdws/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2015/09/25/939/n/1922398/1a467384_Tricep-Dips.jpg";
        desc="When it comes to upper arms, most people think about the biceps, which run along the front of the arm. ";
        activity=new Activity("Upper Arms: Triceps Dips",link,desc);
        allActivities.add(activity);

        link="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/766/tone-thighs-1516988882.jpg?resize=480:*";
        desc="The lunge is an exercise that works a range of muscles, alongside improving core strength " +
                "and flexibility; the lunge is also extremely effective in improving your thighs.";
        activity=new Activity("Thighs: The Lunge",link,desc);
        allActivities.add(activity);

        link="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/0607-side-plank-leg-lift-1441032989.jpg";
        desc="To tighten the muscles and reduce your risk of back pain, " +
                "the side bridge is a good exercise to complete.";
        activity=new Activity("The Side Bridge",link,desc);
        allActivities.add(activity);

        link="https://cdn2.omidoo.com/sites/default/files/imagecache/full_width/images/bydate/20130703/shutterstock122087452.jpg";
        desc="Research at San Diego State University found that " +
                "the single-leg squat was the move that most challenged " +
                "the gluteus medius - the muscle in the hip.";
        activity=new Activity("The Single-Leg Squat",link,desc);
        allActivities.add(activity);

    }




//    public static ArrayList<Activity> getPlanedActivities() {
//        return planedActivities;
//    }
//
//    public Boolean addplanedActivity(Activity a){
//        return planedActivities.add(a);
//    }
//
//    public Boolean removeplanedActivity(Activity a){
//        return planedActivities.remove(a);
//    }



}
