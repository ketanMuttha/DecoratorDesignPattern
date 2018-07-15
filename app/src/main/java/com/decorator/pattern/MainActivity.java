package com.decorator.pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.decorator.pattern.breaverage.Beverage;
import com.decorator.pattern.breaverage.Chocolate;
import com.decorator.pattern.breaverage.Espresso;
import com.decorator.pattern.breaverage.decorator.BeverageDecorator;
import com.decorator.pattern.breaverage.decorator.MilkDecorator;
import com.decorator.pattern.breaverage.decorator.SugarDecorator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.beverage_spinner)
    Spinner mBeverageType;

    @BindView(R.id.milk_check)
    CheckBox mMilkChecked;

    @BindView(R.id.sugar_check)
    CheckBox mSugarChecked;

    @BindView(R.id.total)
    TextView mTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addItemsOnBeverageTypeSpinner();
    }

    @OnClick(R.id.submit)
    public void orderSubmit(View view) {
        String type=mBeverageType.getSelectedItem().toString();
        Beverage beverage;
        if(type.equals("Espresso")){
            beverage=new Espresso();
        }
        else
        {
            beverage=new Chocolate();
        }

        if(mMilkChecked.isChecked() && mSugarChecked.isChecked()){

            beverage=new MilkDecorator(new SugarDecorator(beverage));
        }else if(mMilkChecked.isChecked()){
            beverage=new MilkDecorator(beverage);
        }else if(mSugarChecked.isChecked()){
            beverage=new SugarDecorator(beverage);
        }

        mTotal.setText("Your total= "+beverage.getCost()+"$");

    }


    // add items into beverage spinner dynamically
    public void addItemsOnBeverageTypeSpinner() {
        List<String> list = new ArrayList<String>();
        list.add("Espresso");
        list.add("Chocolate");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBeverageType.setAdapter(dataAdapter);


    }

}
