package com.example.tanuj.workoutsadvisor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindWorkoutActivity extends Activity {

    private WorkoutExpert expert = new WorkoutExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_workout);
    }

    public void onClickFindWorkout(View view)
    {
        TextView workouts = (TextView)findViewById(R.id.workout);
        Spinner workouttype = (Spinner)findViewById(R.id.workouttype);

        String workout= String.valueOf(workouttype.getSelectedItem());
        //workouts.setText(workout);
        List <String> workoutList = expert.getWorkouts(workout);

        StringBuilder workoutsFormatted = new StringBuilder();
        for(String work: workoutList){
            workoutsFormatted.append(work).append("\n");
        }
        workouts.setText(workoutsFormatted);
    }

}
