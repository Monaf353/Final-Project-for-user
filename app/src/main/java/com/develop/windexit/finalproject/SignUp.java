package com.develop.windexit.finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.develop.windexit.finalproject.Common.Common;
import com.develop.windexit.finalproject.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import info.hoang8f.widget.FButton;

public class SignUp extends AppCompatActivity {
    MaterialEditText edtPhone, edtName, edtPassword;

    FButton signUp;
    // TextView textView;

    public String temporary;
    public String userid;
    public static int cx, cy;
    private static DatabaseReference mUserDatabase;


    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;

    private static DatabaseReference myRef;

    private int MODE_PRIVATE;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startauthentication();

        setContentView(R.layout.activity_sign_up);

       // edtPhone = findViewById(R.id.edtphone);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);

        signUp = findViewById(R.id.signUp);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference table_user = database.getReference("User");

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isConnectedToINternet(getBaseContext())) {

                    final ProgressDialog mdialog = new ProgressDialog(SignUp.this);

                    mdialog.setMessage("please wait...");
                    mdialog.show();

                    final FirebaseUser userww = mAuth.getCurrentUser();
                    //check if user exist or not in Database
                    userID = userww.getUid();
                    final String userPhone = userww.getPhoneNumber();

                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot)
                        {

                                mdialog.dismiss();
                                User user = new User(edtName.getText().toString(), edtPassword.getText().toString());
                                table_user.child(userID).child(userPhone).setValue(user);
                                Toast.makeText(SignUp.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                                finish();
                                return;
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                } else {
                    Toast.makeText(SignUp.this, "please check your internet  connection", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        SharedPreferences mPreferences;
        mPreferences = SignUp.this.getSharedPreferences("users", MODE_PRIVATE);

        temporary = mPreferences.getString("saveuserid", "");

        if (temporary != null && !temporary.isEmpty()) {

            mAuth = FirebaseAuth.getInstance();
            mFirebaseDatabase = FirebaseDatabase.getInstance();
            myRef = mFirebaseDatabase.getReference();
            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            userid = currentFirebaseUser.getUid();

        } else {

        }

    }

    public void startauthentication() {

        SharedPreferences mPreferences;
        mPreferences = getSharedPreferences("users", MODE_PRIVATE);
        temporary = mPreferences.getString("saveuserid", "");

        if (temporary != null && !temporary.isEmpty()) {
        } else {
            Intent y = new Intent(SignUp.this, PhoneAuthActivity.class);
            y.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            y.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(y);

        }
    }
}

  /* if (dataSnapshot.child(userID).exists())
                            {*/


                            /* mdialog.dismiss();
                                Toast.makeText(SignUp.this, "Phone Number already register", Toast.LENGTH_SHORT).show();*/
// }
                           /* else
                                {*/
                                   /* FirebaseUser user = mAuth.getCurrentUser();
                                    //check if user exist or not in Database

                                    userID = user.getUid();

                                    mdialog.dismiss();
                                User user = new User(edtName.getText().toString(), edtPassword.getText().toString());
                                table_user.child(edtPhone.getText().toString()).setValue(user);

                                Toast.makeText(SignUp.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                                finish();*/
// }





   /* public void signoutbutton(View s) {
        if (s.getId() == R.id.sign_out) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you really want to Log Out ?").setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            SharedPreferences mPreferences;

                            mPreferences = getSharedPreferences("User", MODE_PRIVATE);
                            SharedPreferences.Editor editor = mPreferences.edit();
                            editor.clear();
                            editor.apply();
                            mAuth.signOut();

                            Intent y = new Intent(MainActivity.this, PhoneAuthActivity.class);
                            y.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            y.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(y);

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.setTitle("Confirm");
            dialog.show();

        }
    }*/

//setContentView(R.layout.activity_sign_up);

       /* textView = findViewById(R.id.txtPhone);
        if(getIntent()!= null){
            textView.setText(getIntent().getStringExtra("phonenew"));
        }
*/