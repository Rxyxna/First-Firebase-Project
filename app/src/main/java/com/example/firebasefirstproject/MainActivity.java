package com.example.firebasefirstproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addData (View view) {
        Map<String, Object> notes = new HashMap<>();
        notes.put("Title", "Math");
        notes.put("Text", "2+2");
        notes.put("Tag", "School");
        notes.put("Favorite", false);

        // Add a new document with a generated ID
        db.collection("Notes")
                .add(notes)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("added");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("error");
                        System.out.println(e);

                    }
                });
    }
    public void setData (View view) {
        Map<String, Object> notesData = new HashMap<>();
        notesData.put("Title", "love");
        notesData.put("Text", "Alisa");
        notesData.put("Tag", "Private");
        notesData.put("Favorite", true);
        notesData.put("Mood", "In love");

        Notes notes = new Notes("asd", "in love");

        db.collection("Notes")
                .document("ada")
                .set(notesData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }


}
