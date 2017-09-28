package com.algonquincollege.dosh0005.event_handling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.algonquincollege.dosh0005.event_handling.R.id.username;

public class MainActivity extends AppCompatActivity {

    protected Button btnSubmit;
    protected EditText userNameEditText, passWordEditText;
    protected boolean userFlag, passFlag;
    protected String tostMSG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        userNameEditText = (EditText) findViewById(username);
        passWordEditText = (EditText) findViewById(R.id.password);
        userFlag = false;
        passFlag = false;
        tostMSG = "";

        // register an anonymous inner class as the event handler for bigButton
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = userNameEditText.getText().toString();
                String password = passWordEditText.getText().toString();


                if (validateUsername(username) && validatePassword(password)) {
                    Toast.makeText(getApplicationContext(),
                            tostMSG,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private boolean validateUsername(String username) {
        if (username.isEmpty()) {
            userNameEditText.setError("Username is required");
            userNameEditText.requestFocus();
            return false;
        } else if (username.length() <= 4) {
            userNameEditText.setError("Too short");
            userNameEditText.requestFocus();
            return false;
        } else if (username.length() < 8) {
            userNameEditText.setError("Username must be exactly 8 characters ");
            userNameEditText.requestFocus();
            return false;
        } else {
            if (!(Character.isLowerCase(username.charAt(0)) && Character.isLowerCase(username.charAt(1)))) {
                userNameEditText.setError("invalid: upper-case");
                userNameEditText.requestFocus();
                return false;
            }
            if (!((Character.isLowerCase(username.charAt(2)) || Character.isDigit(username.charAt(2)))
                    && (Character.isLowerCase(username.charAt(3)) || Character.isDigit(username.charAt(3))))) {
                userNameEditText.setError("invalid: non-alphabetical character");
                userNameEditText.requestFocus();
                return false;
            }
            if (!(Character.isDigit(username.charAt(4))
                    && Character.isDigit(username.charAt(5))
                    && Character.isDigit(username.charAt(6))
                    && Character.isDigit(username.charAt(7)))) {
                userNameEditText.setError("invalid: positions 5 to 8 are not digits");
                userNameEditText.requestFocus();
                return false;
            }
        }
        tostMSG = "Username Pass Validation";
        return true;
    }

    private boolean validatePassword(String password) {
        if (password.isEmpty()) {
            passWordEditText.setError("Password is required");
            passWordEditText.requestFocus();
            return false;
        } else if (password.length() <= 3) {
            passWordEditText.setError("Too short");
            passWordEditText.requestFocus();
            return false;
        } else if (password.length() < 5) {
            passWordEditText.setError("Password must contain minimum 5 character");
            passWordEditText.requestFocus();
            return false;
        }
        tostMSG += "\nPassword Pass Validation";
        return true;
    }


}
