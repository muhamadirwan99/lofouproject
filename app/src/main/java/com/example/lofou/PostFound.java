package com.example.lofou;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class PostFound extends AppCompatActivity {

    Button ch, up;
    ImageView img;
    StorageReference mStorageRef;
    public Uri imguri;
    private StorageTask uploadTask;
    EditText editText,editText3,editText2,editText4;
    DataFound dataFound;
    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_found);
        ch=(Button)findViewById(R.id.button13);
        up=(Button)findViewById(R.id.button);
        img=(ImageView) findViewById(R.id.imageView3);
        mStorageRef= FirebaseStorage.getInstance().getReference("Images");
        editText=(EditText)findViewById(R.id.editText);
        editText3=(EditText)findViewById(R.id.editText3);
        editText2=(EditText)findViewById(R.id.editText2);
        editText4=(EditText)findViewById(R.id.editText4);
        dataFound=new DataFound();
        dbreff= FirebaseDatabase.getInstance().getReference().child("DataFound");

        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uploadTask!=null && uploadTask.isInProgress()){
                    Toast.makeText(PostFound.this,"Sedang Proses Upload", Toast.LENGTH_LONG).show();
                }else{
                    Fileuploader();
                }
            }
        });
    }

    private String getExtension(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimiTypeMap = MimeTypeMap.getSingleton();
        return mimiTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void Fileuploader(){
        String imageID;
        imageID=System.currentTimeMillis()+"."+getExtension(imguri);
        dataFound.setNamaBarang(editText.getText().toString().trim());
        dataFound.setWaktuDitemukan(editText3.getText().toString().trim());
        dataFound.setLokasi(editText2.getText().toString().trim());
        dataFound.setDeskripsi(editText4.getText().toString().trim());
        dataFound.setImageID(imageID);
        dbreff.push().setValue(dataFound);

        StorageReference Ref = mStorageRef.child(imageID);
        uploadTask=Ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(PostFound.this, "Upload sukses, Terimakasih", Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });
    }

    private void Filechooser(){
        Intent intent=new Intent();
        intent.setType("image/'");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imguri=data.getData();
            img.setImageURI(imguri);
        }
    }

    public void FoundFragment(View view) {
        Intent FoundFragment = new Intent(PostFound.this, FoundFragment.class);
        startActivity(FoundFragment);
    }

    public void Katagori(View view) {
        Intent Katagori = new Intent(PostFound.this, Katagori.class);
        startActivity(Katagori);
    }

    public void FoundT1(View view) {
        Intent FoundT1 = new Intent(PostFound.this, FoundT1.class);
        startActivity(FoundT1);
    }
}