package com.example.lab07_sensores;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView A1, A2,A3,M1,M2,M3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        A1=(TextView)findViewById(R.id.textViewA1);
        A2=(TextView)findViewById(R.id.textViewA2);
        A3=(TextView)findViewById(R.id.textViewA3);
        M1=(TextView)findViewById(R.id.textViewM1);
        M2=(TextView)findViewById(R.id.textViewM2);
        M3=(TextView)findViewById(R.id.textViewM3);

        init();
    }

    private void init(){
        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);//usamos sensorr manager para acceder a los servicios de los sensoreas
        //Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor sensor2=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListener2,sensor2,SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener sensorEventListener=new SensorEventListener() {//tenemos el sensorListener
        @Override
        public void onSensorChanged(SensorEvent event) {

           /* for(int i=0; i < event.values.length;i++){
                Log.d("VALOR "+i+":",""+event.values[i]);
            }*/
            A1.setText("X = "+ event.values[0]);
            A2.setText("Y = "+ event.values[1]);
            A3.setText("Z = "+ event.values[2]);

           /* M1.setText("X = "+ event.values[0]);
            M2.setText("Y = "+ event.values[1]);
            M3.setText("Z = "+ event.values[2]);*/

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    private SensorEventListener sensorEventListener2=new SensorEventListener() {//tenemos el sensorListener
        @Override
        public void onSensorChanged(SensorEvent event) {

           /* for(int i=0; i < event.values.length;i++){
                Log.d("VALOR "+i+":",""+event.values[i]);
            }*/
            /*A1.setText("X = "+ event.values[0]);
            A2.setText("Y = "+ event.values[1]);
            A3.setText("Z = "+ event.values[2]);*/

            M1.setText("X = "+ event.values[0]);
            M2.setText("Y = "+ event.values[1]);
            M3.setText("Z = "+ event.values[2]);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor2, int accuracy) {

        }
    };
}