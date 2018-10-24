package km.thony.me.calculations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final double vat = 20;
    EditText unitprice,unitamount,vattxt,amountincvat,amountexlvat;
    RadioButton exclude, include;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unitprice = findViewById(R.id.uniteprice);
        unitamount = findViewById(R.id.uniteamount);
        vattxt = findViewById(R.id.vattxt);
        amountexlvat = findViewById(R.id.amountexlvat);
        amountincvat = findViewById(R.id.amountincvat);
        exclude = findViewById(R.id.radioButton2);
        include = findViewById(R.id.radioButton3);
    }

    public void onClick(View view) {
        if (view.getId()== R.id.clear){
            unitamount.setText("");
            unitprice.setText("");
            Toast.makeText(this,"Cleared",Toast.LENGTH_LONG).show();
            return;
        }

        if (view.getId() == R.id.ok){
            if (unitprice.getText().length() == 0 ){
                Toast.makeText(this,"Enter a valid price",Toast.LENGTH_SHORT).show();
                return;
            }
            if (unitamount.getText().length() == 0 ){
                Toast.makeText(this,"Enter a valid amount of items",Toast.LENGTH_SHORT).show();
                return;
            }
            DecimalFormat value = new DecimalFormat("#.##");

            double unitpriceint = Double.parseDouble(unitprice.getText().toString());
            double unitamountint = Double.parseDouble(unitamount.getText().toString());

            double totalprice = unitamountint*unitpriceint;
            String totalpricetxt = Double.toString(totalprice);
            String totalpricewv = Double.toString(totalprice*1.2);
            String totalvat = Double.toString((totalprice*1.2)-totalprice );
            if (exclude.isChecked()) {
                amountexlvat.setText(totalpricetxt);
                amountincvat.setText(totalpricewv);
                vattxt.setText(totalvat);
                return;
            }


            String totalpricewovat = Double.toString(totalprice*0.8);
            String totalvatinc = Double.toString(totalprice-(totalprice*0.8));

            if(include.isChecked()) {
                amountincvat.setText(totalpricetxt);
                amountexlvat.setText(totalpricewovat);
                vattxt.setText(totalvatinc);
                return;
            }
            return;
        }

    }


}
