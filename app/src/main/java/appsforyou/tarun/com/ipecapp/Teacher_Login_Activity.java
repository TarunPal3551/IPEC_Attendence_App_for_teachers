package appsforyou.tarun.com.ipecapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Teacher_Login_Activity extends AppCompatActivity {
    EditText editextteacherid, edittextpassword;
    Button loginteacher;
    FirebaseDatabase database;
    DatabaseReference reference;
    private static final String TAG = "Teacher_Login_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__login_);
        editextteacherid = (EditText) findViewById(R.id.editTextteacherid);
        edittextpassword = (EditText) findViewById(R.id.editTextteacherpassword);
        loginteacher = (Button) findViewById(R.id.buttonloginteacher);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        loginteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginwithteacherCrenditals(editextteacherid.getText().toString(), edittextpassword.getText().toString());

            }
        });


    }

    private void loginwithteacherCrenditals(final String id, final String password) {
        Query query = reference.child("IPEC").child("Teachers").child(id);
        if (query != null) {
            Log.d(TAG, "loginwithteacherCrenditals: " + query);
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChild("password")){
                        String  fPassword=dataSnapshot.child("password").getValue().toString();
                        if (fPassword.equals(password)){
                            Toast.makeText(Teacher_Login_Activity.this," Exists",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(Teacher_Login_Activity.this,HomeActivity_Teacher.class);
                            intent.putExtra("Teacher_id",id);
                            startActivity(intent);
                            finish();

                        }
                        else {
                            Toast.makeText(Teacher_Login_Activity.this," Check your password",Toast.LENGTH_LONG).show();

                        }

                    }
                    else{
                        Toast.makeText(Teacher_Login_Activity.this," not Exists",Toast.LENGTH_LONG).show();


                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

//       reference.addListenerForSingleValueEvent(new ValueEventListener() {
//           @Override
//           public void onDataChange(DataSnapshot dataSnapshot) {
//               if (dataSnapshot.child("IPEC").child("Teachers").hasChild(id)){
//                   String fpassword=dataSnapshot.child("IPEC").child("Teachers").child(id).child("password").toString();
//                   if (fpassword.equals(password)){
//                       Toast.makeText(Teacher_Login_Activity.this,"Exists",Toast.LENGTH_LONG).show();
//                   }
//                   else {
//                       Toast.makeText(Teacher_Login_Activity.this," not Exists",Toast.LENGTH_LONG).show();
//
//
//                   }
//
//               }
//           }
//
//           @Override
//           public void onCancelled(DatabaseError databaseError) {
//
//           }
//       });


        }
    }

}
