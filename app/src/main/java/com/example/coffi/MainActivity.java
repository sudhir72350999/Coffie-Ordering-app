package com.example.coffi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView quantity_textview, price_textview;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity_textview = findViewById(R.id.quantity_textview);
        price_textview = findViewById(R.id.price_textview);
    }


    public void submitOrder(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.creamCheckBox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolateCheckBox);

        EditText editText1 = (EditText) findViewById(R.id.editText);
        String name = editText1.getText().toString();

//        Log.v("MainActivity","this is edit text"+name);
//        Log.v("MainActivity", "this is message" + name);
        boolean hasCream = checkBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
//        int price = quantity*5;
        int price = calculatePrice(hasCream, hasChocolate);


        String priceMessage = createOrderSummary(price, hasCream, hasChocolate, name);
        displayMessage(priceMessage);



//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, "lucknow");
//        intent.putExtra(Intent.EXTRA_SUBJECT, "this is nice for everyone");
//        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }


        // this is for map
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6,-122.3"));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

//        String firstName = "Sudhir"
//        String lastName = "Prajapati";
//        String contactInfo = firstName + "...." + lastName;
//        contactInfo = contactInfo + "<" + lastName + "----" + firstName + "@gmail.com";
//        display(contactInfo);
//        displayPrice(quantity*5);

//        dispalyOneParameterInt(77);// this is for one parameter called in submit order method
//        dispalyOneParameterString("sudhir kumar");
//        dispalyOneParameterFloat(22.55f);
//
//
//        displayTwoParameterInt1(22,55);
//        displayTwoParameterInt2(22,56);
//        displayTwoParameterString1("sudhir","kumar");
//        displayTwoParameterString2("sudhir","kumar");
    }

    private int calculatePrice(boolean hasCream, boolean hasChocolate) {
        int basePrice = 5;

        if (hasCream) {
            basePrice = basePrice + 1; // per cup cream 1 dollar extra charge
        }
        if (hasChocolate) {
            basePrice = basePrice + 2; // per chocolate 2 dollor extra charge
        }
        return quantity * basePrice;

    }

    public void increment(View view) {
//        int quantity = 2;
//               quantity = quantity+1;
//               quantity = 2*quantity+quantity;
//               quantity=quantity+2;
//        quantity = quantity * 2;
        if (quantity == 100) {
            Toast.makeText(MainActivity.this, "You cannot have more than 100 Coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
//        int quantity = 2;
        //        quantity = quantity/2;
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    private void display(int number) {
        quantity_textview.setText("" + number);
    }

    private void displayPrice(int number) {
        price_textview.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayPriceMessage(String priceMessage) {

    }

    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        price_textview.setText(message);
    }

    //
    private void display(String message) {
        price_textview.setText(message);
    }

    // this is one parameter defined
    //for int
    private int dispalyOneParameterInt(int digit) {
        return digit;
    }

    // for string
    private String dispalyOneParameterString(String name) {
        return name;
    }

    // for float
    private float dispalyOneParameterFloat(float decimal) {
        return decimal;
    }

    // this is two parameter defined
    // for int
    private int displayTwoParameterInt1(int digit1, int digit2) {
        return digit1;   // only for one return digit1
    }

    private int displayTwoParameterInt2(int digit1, int digit2) {
        return digit1 * digit2;   //  for two return digit1 and digit2
    }

    private int displayTwoParameterIntAnyThing(int digit1, int digit2) {
        return digit1 * 5;   // for return digit1 with multiply
//        return digit1+9;   // for return digit1 with addition
//        return digit1-3;   // for return digit1 with subtraction
//        return digit1/9;   // for return digit1 with devide
    }

    // for  string
    private String displayTwoParameterString1(String name1, String name2) {
        return name1;  //  only one string return
        // note utna he
    }

    private String displayTwoParameterString2(String name1, String name2) {
        return name1 + name2; // two string return same string datatype
    }

    private String displayTwoParameterString3(String name1, int digit3) {
        return name1 + digit3; // two string return different datatype int and string
    }

    // mix concatante with string
    private String displayTwoParameterStringConcataanteMix(String myName, String myCollege, String place, int passYear) {
        return "My name is " + myName + "and I study in " + place + "My college name is" + myCollege + "I will passOut in " + passYear;
    }


    private String createOrderSummary(int price, boolean addCream, boolean addChocolate, String name) {
//        String priceMessage = " \nTotal Price in  $  is " + price + " because per cup coffee is 5 $ ";
//        priceMessage += " \n My name is  " + name;
//        priceMessage += " \n add the cream " + addCream;
//        priceMessage += " \n add the chocolate " + addChocolate;
//
//        priceMessage += " \n total order is  " + quantity;
//        priceMessage = priceMessage + "\n  Thank You for this order by sudhir the indian";
//        return priceMessage;

        String priceMessage = getString(price,name);
        priceMessage += " \n My name is  " + name;
        priceMessage += " \n add the cream " + addCream;
        priceMessage += getString(R.string.nice) + addChocolate;

        priceMessage += getString(R.string.order_total) + quantity;
//        priceMessage = priceMessage + getString(R.string.thankyou);
        return priceMessage;

    }


}