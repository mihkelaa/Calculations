package km.thony.me.calculations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText unitprice,numberofunits;
    RadioButton unitexclvat,unitinclvat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unitprice=findViewById(R.id.unitprice);
        numberofunits=findViewById(R.id.numberofunits);
        unitexclvat=findViewById(R.id.unitexclvat);
        unitinclvat=findViewById(R.id.unitinclvat);
    }
    double up=Double.parseDouble(unitprice.getText().toString());
    double numofunits=Double.parseDouble(numberofunits.getText().toString());

    public  double exclvat(double vat){
        return up*numofunits;
    }
    public  double inclvat(double vat){
        return ((up*numofunits)*0.2) + (up*numofunits);
    }
    public void onClick(View view){
        if (view.getId() == R.id.clear){
            unitprice.setText("");
            numberofunits.setText("");
        } else if (view.getId() == R.id.ok)
        {
         if(unitprice.getText().length()==0 || numberofunits.getText().length()==0){
             Toast.makeText(this, "Please enter a valid number!", Toast.LENGTH_SHORT).show();
         }
        }



    }
}
