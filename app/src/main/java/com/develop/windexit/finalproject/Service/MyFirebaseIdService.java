package com.develop.windexit.finalproject.Service;

import com.develop.windexit.finalproject.Common.Common;
import com.develop.windexit.finalproject.Model.Token;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by WINDEX IT on 12-Mar-18.
 */

public class MyFirebaseIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        if (Common.currentUser != null)
            updateTokenToServer(refreshToken); //when have refresh token , we need update to our Realtime database
    }

    private void updateTokenToServer(String refreshToken) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference("Tokens");
        Token token = new Token(refreshToken, false);
        tokens.child(Common.currentUser.getPhone())
                .setValue(token);

    }
}
