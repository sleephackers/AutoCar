package com.example.root.myautocar;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
    LocationManager locationManager;
    Button brake,accelerator,refill,collision;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 16;
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
//        Log.e("poda", "onCreate: "+ checkLocationPermission());
//        if (checkLocationPermission()==true) {
//            Log.e("HI3", "returned checkLocationPermission true ");
//
//            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//            Log.e("HIII", "Location: "+location.getLatitude()+" "+ location.getLongitude());
//        } else {
//            Log.e("ERROR LOCATION", "Check location permission returned false");
//            Log.e("HI3", "returned checkLocationPermission false ");
//
//        }

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
                if (gear == 6)
                    speed++;
                else {
                        speed +=gear;
                        speedometer.setText("" + speed);

                }
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
//
//    public boolean checkLocationPermission() {
//        Log.e("HI1", "Inside checkLocationPermission ");
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//                new AlertDialog.Builder(this)
//                        .setTitle("Permission")
//                        .setMessage("App requires your location")
//                        .setPositiveButton("Turn On", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                ActivityCompat.requestPermissions(SimulationActivity.this,
//                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                                        MY_PERMISSIONS_REQUEST_LOCATION);
//                                Log.e("HI2", "Location Accepted ");
//
//                            }
//                        })
//                        .setNegativeButton("Dont Allow", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(getApplicationContext(), "Various Functionalities won't work", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .create()
//                        .show();
//
//
//            } else {
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION);
//            }
//            return false;
//        } else {
//            return true;
//        }
//    }

    //Use this function to send data every 10 seconds

    private void sendstats()
    {
        if(speed==0 || fuel==0);
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

