package com.example.app_btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.*;

public class RegisterActivity extends AppCompatActivity {
    private Button btRegister,btCancel;
    private TextInputEditText email,password;
    protected FirebaseAuth mFirebaseAuth;
    private  static  final  String CHANNEL_1_ID = "channel1";
    private  static  final  String CHANNEL_2_ID = "channel2";
    private NotificationManagerCompat managerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFirebaseAuth=FirebaseAuth.getInstance();
        initView();
        managerCompat = NotificationManagerCompat.from(this);
        createNotificationChannels();
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                mFirebaseAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            makeText(RegisterActivity.this,
                                    "Succsessfull!!", LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            makeText(RegisterActivity.this,
                                    "Fail!!", LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is channel 1");
            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel1.setDescription("This is channel 2");
            NotificationManager manager =
                    this.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }

    private void sendOnChannel1(){
        String title = email.getText().toString();
        String content = password.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,
                CHANNEL_1_ID).setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
        int notiID = 1;
        managerCompat.notify(notiID,notification);
    }
    private void sendOnChannel2(){
        String title = email.getText().toString();
        String content = password.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,
                CHANNEL_2_ID).setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_CALL).build();
        int notiID = 2;
        managerCompat.notify(notiID,notification);
    }


    private void initView() {
        btCancel=findViewById(R.id.btCancel);
        btRegister=findViewById(R.id.btRegister);
        email= (TextInputEditText)findViewById(R.id.txtEmail);
        password= (TextInputEditText)findViewById(R.id.txtPass);
    }
}
