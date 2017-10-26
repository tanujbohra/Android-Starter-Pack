package com.example.tanuj.workoutsadvisor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanuj on 21/06/17.
 */

public class WorkoutExpert {
    List <String> getWorkouts (String workouttypes)
    {
        List <String> workout = new ArrayList<String>();

        if(workouttypes.equals("Chest"))
        {
            workout.add("Bench Press");
            workout.add("Cable Flys");
        }
        else if(workouttypes.equals("Triceps"))
        {
            workout.add("Tricep Extesions");
            workout.add("Tricep Pushdowns");
        }
        else if(workouttypes.equals("Shoulders"))
        {
            workout.add("Shoulder Press");
        }
        else if(workouttypes.equals("Biceps"))
        {
            workout.add("Bicep Curls");
        }
        return workout;
    }
}
