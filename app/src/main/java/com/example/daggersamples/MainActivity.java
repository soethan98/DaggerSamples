package com.example.daggersamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daggersamples.car.Car;
import com.example.daggersamples.di.component.ActivityComponent;
import com.example.daggersamples.di.component.DaggerAppComponent;
import com.example.daggersamples.di.modules.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1;

    @Inject
    Car car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityComponent activityComponent = ((ExampleApp) getApplication()).getAppComponent()
                .getActivityComponent(new DieselEngineModule(100));


//        ActivityComponent activityComponent = ((ExampleApp) getApplication()).getActivityComponent();
        activityComponent.inject(this);
//
        car1.drive();
        car2.drive();

    }
}