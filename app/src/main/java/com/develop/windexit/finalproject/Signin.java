package com.develop.windexit.finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.develop.windexit.finalproject.Common.Common;
import com.develop.windexit.finalproject.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Signin extends AppCompatActivity {
    MaterialEditText mphone, mpassword;
    Button msignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mphone =  findViewById(R.id.phone);
        mpassword =  findViewById(R.id.password);

        msignin =  findViewById(R.id.signin);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference table_user = database.getReference("User");
        msignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Common.isConnectedToINternet(getBaseContext()))
                {
                    final ProgressDialog mdialog = new ProgressDialog(Signin.this);

                    mdialog.setMessage("please wait...");
                    mdialog.show();
                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child(mphone.getText().toString()).exists()) {
                                mdialog.dismiss();
                                User user = dataSnapshot.child(mphone.getText().toString()).getValue(User.class);

                                user.setPhone(mphone.getText().toString());
                                if (user.getPassword().equals(mpassword.getText().toString())) {
                                    Intent i = new Intent(Signin.this, Home.class);
                                    Common.currentUser = user;
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(Signin.this, "signin error..", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                mdialog.dismiss();
                                Toast.makeText(Signin.this, "user not exist..", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else {
                    Toast.makeText(Signin.this,"please check your internet connection",Toast.LENGTH_SHORT).show();
                    return;
                }
            }


        });
    }
}
