package com.example.lofou;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class Edit extends AppCompatActivity {

    EditText nama,email,nohp;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button tombol;
    String eemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        nama = findViewById(R.id.nama_profil);
        email = findViewById(R.id.email_profil);
        nohp = findViewById(R.id.nohp_profil);
        tombol = findViewById(R.id.reset);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                nama.setText(documentSnapshot.getString("nama"));
                email.setText(documentSnapshot.getString("email"));
                eemail = documentSnapshot.getString("email");
                nohp.setText(documentSnapshot.getString("nohp"));
            }
        });

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView resetmail = new TextView(v.getContext());
                resetmail.setGravity(Gravity.CENTER);
                resetmail.setTextColor(Color.parseColor("#464647"));
                resetmail.setText(eemail);
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password");
                passwordResetDialog.setMessage("Link Reset Password Akan Dikirim Ke Email Dibawah Ini");
                passwordResetDialog.setView(resetmail);

                passwordResetDialog.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = resetmail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Edit.this, "Link Reset Telah Berhasil Dikirim",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Edit.this, "Error ! Link Reset Tidak Terkirim "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                passwordResetDialog.create().show();

            }
        });
    }

    public void UploadF(View view) {
        Intent UploadF = new Intent(Edit.this, UploadF.class);
        startActivity(UploadF);
    }


    public void EditProfil(View view) {
        Intent EditProfil = new Intent(Edit.this, MainActivity.class);
        startActivity(EditProfil);
    }
}