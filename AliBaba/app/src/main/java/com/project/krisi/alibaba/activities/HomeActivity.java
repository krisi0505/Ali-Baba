package com.project.krisi.alibaba.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.krisi.alibaba.R;

public class HomeActivity extends AppCompatActivity {
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mStorageRef = FirebaseStorage.getInstance().getReference();

//        Uri file = Uri.fromFile(new File(""));
//        StorageReference riversRef = mStorageRef.child("");
//
//
//        riversRef.putFile(file)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        // Get a URL to the uploaded content
//                        @SuppressWarnings("VisibleForTests") Uri downloadUrl = taskSnapshot.getDownloadUrl();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle unsuccessful uploads
//                        // ...
//                    }
//                });
//
//        File localFile = null;
//        try {
//            localFile = File.createTempFile("images", "jpg");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        riversRef.getFile(localFile)
//                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                        // Successfully downloaded data to local file
//                        // ...
//                        Context context = getApplicationContext();
//                        CharSequence text = "Got the file!";
//                        int duration = Toast.LENGTH_SHORT;
//
//                        Toast toast = Toast.makeText(context, text, duration);
//                        toast.show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle failed download
//                // ...
//                Context context = getApplicationContext();
//                CharSequence text = "Nope";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//            }
//        });

        Button btnPlay = (Button) findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playActivity = new Intent(HomeActivity.this, LevelActivity.class);

                startActivity(playActivity);
            }
        });

        Button btnInstructions = (Button) findViewById(R.id.btn_instructions);
        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instructionsActivity = new Intent(HomeActivity.this, InstructionsActivity.class);
                startActivity(instructionsActivity);
            }
        });

        Button btnMap = (Button) findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapActivity = new Intent(HomeActivity.this, TreasureMapActivity.class);
                startActivity(mapActivity);
            }
        });

        Button btnHighScores = (Button) findViewById(R.id.btn_scores);
        btnHighScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoresActivity = new Intent(HomeActivity.this, ScoresActivity.class);
                startActivity(scoresActivity);
            }
        });
    }
}
