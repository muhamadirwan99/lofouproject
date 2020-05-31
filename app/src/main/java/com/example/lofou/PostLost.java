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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class PostLost extends AppCompatActivity {

    Button ch, up;
    ImageView img;
    StorageReference mStorageRef;
    public Uri imguri;
    private StorageTask uploadTask;
    EditText editText,editText3,editText2,editText4;
    DataLost dataLost;
    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_lost);

        ch=(Button)findViewById(R.id.button12);
        up=(Button)findViewById(R.id.button);
        img=(ImageView) findViewById(R.id.imageView2);
        mStorageRef= FirebaseStorage.getInstance().getReference("Images");
        editText=(EditText)findViewById(R.id.editText);
        editText3=(EditText)findViewById(R.id.editText3);
        editText2=(EditText)findViewById(R.id.editText2);
        editText4=(EditText)findViewById(R.id.editText4);
        dataLost=new DataLost();
        dbreff= FirebaseDatabase.getInstance().getReference().child("DataLost");

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
                    Toast.makeText(PostLost.this,"Sedang Proses Upload", Toast.LENGTH_LONG).show();
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
        dataLost.setNamaBarang(editText.getText().toString().trim());
        dataLost.setWaktuKehilangan(editText3.getText().toString().trim());
        dataLost.setLokasi(editText2.getText().toString().trim());
        dataLost.setDeskripsi(editText4.getText().toString().trim());
        dataLost.setImageID(imageID);
        dbreff.push().setValue(dataLost);

        StorageReference Ref = mStorageRef.child(imageID);
        uploadTask=Ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(PostLost.this, "Upload sukses", Toast.LENGTH_LONG).show();
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

    public void Katagori(View view) {
        Intent Katagori = new Intent(PostLost.this, Katagori.class);
        startActivity(Katagori);
    }

    public void LostT1(View view) {
        Intent  LostT1 = new Intent(PostLost.this, LostT1.class);
        startActivity(LostT1);
    }

    public void Hadiah(View view) {
        Intent  Hadiah = new Intent(PostLost.this, Hadiah.class);
        startActivity(Hadiah);
    }

}
