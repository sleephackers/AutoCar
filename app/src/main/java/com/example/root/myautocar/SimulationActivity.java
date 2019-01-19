package com.example.root.myautocar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SimulationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public float speed,distance,initvelo;
    public int fuel,gear;
    private Spinner spinner;
    private Boolean isbrakepressed=false,accpressed=false;
    Button brake,accelerator,refill,collision;
    TextView speedometer,fueltext;
    private static final String[] gears = {"1","2","3","4","5","6"};
    private Handler handler;
    private CarStats carStats;

    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        getSupportActionBar().hide();
        brake=findViewById(R.id.brake);
        accelerator=findViewById(R.id.accelerator);
        refill=findViewById(R.id.refill);
        collision=findViewById(R.id.generatecollision);
        spinner = (Spinner)findViewById(R.id.spinner);
        speedometer=findViewById(R.id.speedometer);
        fueltext=findViewById(R.id.fuel);
        carStats=new CarStats("root4",24.4,24.4,fuel,speed);
        initvelo=0;
        fuel=50;
        fueltext.setText(""+fuel);
        gear=1;
        speed=initvelo;

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                sendstats();
                handler.postDelayed(this, 5000);
            }
        };

        handler.postDelayed(runnable, 5000);



        brake.setOnTouchListener(new RepeatListener(400, 75, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CHCEK", "In OnClick");
                if(speed==0);
                else {
                    speed--;
                    initvelo=speed;
                }
                speedometer.setText("" + speed);
            }
        }));

        accelerator.setOnTouchListener(new RepeatListener(400, 200, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CHCEK", "In OnClick");

                speed+=gear;
                speedometer.setText("" + speed);
            }
        }));

        refill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            fuel=50;
            fueltext.setText(""+fuel);
            }
        });

        collision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SimulationActivity.this,
                android.R.layout.simple_spinner_item,gears);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    //Use this function to send data every 10 seconds

    private void sendstats()
    {
        if(speed==0);
        else {
            fuel--;
            fueltext.setText("" + fuel);
        }
        carStats.setSpeed(speed);
        carStats.setFuel(fuel);
        //carStats.setLat();
        Log.e(SimulationActivity.class.getSimpleName(), "sendstats ");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                gear=1;
                Toast.makeText(getApplicationContext(), "Current Gear: 1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                gear=2;
                Toast.makeText(getApplicationContext(), "Current Gear: 2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                gear=3;
                Toast.makeText(getApplicationContext(), "Current Gear: 3", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                gear=4;
                Toast.makeText(getApplicationContext(), "Current Gear: 4", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                gear=5;
                Toast.makeText(getApplicationContext(), "Current Gear: 5", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                gear=6;
                Toast.makeText(getApplicationContext(), "Reverse Gear Activated", Toast.LENGTH_LONG).show();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub


    }

}

