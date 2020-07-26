package com.example.daggersamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daggersamples.car.Car;
import com.example.daggersamples.modules.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.builder().dieselEngineModule(new DieselEngineModule(1000)).build();
        component.inject(this);

        car.drive();

    }
}