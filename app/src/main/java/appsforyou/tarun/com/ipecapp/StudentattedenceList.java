package appsforyou.tarun.com.ipecapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import appsforyou.tarun.com.ipecapp.R;

public class StudentattedenceList extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

    //***
    String datetime;
//*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentattedence_list);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String year=bundle.getString("year");
        String section=bundle.getString("section");

//***
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        datetime = dateformat.format(c.getTime());
//*****

        getListofStudent(year,section);
    }

    private void getListofStudent(final String year, final String section){

        final Boolean[] is_this_first_time_marking_for_this_lecture = new Boolean[1];
        final String[][] status = new String[1][1];
        final long[] noofstudent = new long[1];


        Query query =reference.child("IPEC").child("classes").child(year+"year");
        reference.child("IPEC").child("classes").child(year+"year");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("section")){
                    noofstudent[0] =dataSnapshot.child("section").child(section).getChildrenCount();

//****
                    // yaha par if else laga ke check kario......
                    // sabse pehle  yaha par s1 ke anda jaa ...
                    // au check kar ki uske ander datetime wala child hai ya nahi agar nahi hai to s1 ke aner datetime wala childbana de..
                    dataSnapshot.child("section").child(section).child("s1");


                    if (dataSnapshot.hasChild(datetime)){
                        is_this_first_time_marking_for_this_lecture[0] =false;
//yaha par tughe saari students ke ander jaana hoga aur date time walle node ke ander se
// statuskey ki value uthani hgi status ki usko STATUS array me rak lio...Status ka size una hee hogajitna no of studnts kaa

                        status[0] = new String[(int) noofstudent[0]];
                        for (int i = 1; i<= noofstudent[0]; i++){
                            status[0][i-1] = dataSnapshot.child("section").child(section).child("s"+i).child(datetime).child("status").getValue().toString();


                            status[0][i-1] ="absent";
                        }

                    }
                    else{
                        is_this_first_time_marking_for_this_lecture[0] =true;

                        status[0] = new String[(int) noofstudent[0]];
                        for (int i = 1; i<= noofstudent[0]; i++){
                            //yaha par chid daalna hai datetime har ek student ke ander
                            reference.child("IPEC").child("classes").child(year+"year").child("section").child(section).child("s"+i).child(datetime).child(datetime).setValue(datetime);
                            status[0][i-1] ="present";
                        }


                    }
//****




                    String[] allstudentname=new String[(int) noofstudent[0]];
                    String [] allsudentid=new String[(int) noofstudent[0]];


                    LinearLayout container = ( LinearLayout)findViewById(R.id.container);

                    LinearLayout[] row_container = new LinearLayout[(int) noofstudent[0]];
                    TextView[]  student_id_tv = new TextView[(int) noofstudent[0]];
                    TextView[]  student_name_tv = new TextView[(int) noofstudent[0]];
                    final TextView[]  student_status_tv = new TextView[(int) noofstudent[0]];


                    final float scale = StudentattedenceList.this.getResources().getDisplayMetrics().density;


                    for (int i = 1; i<= noofstudent[0]; i++){
                        String name=dataSnapshot.child("section").child(section).child("s"+i).child("name").getValue().toString();
                        String studentId=dataSnapshot.child("section").child(section).child("s"+i).child("sid"+i).getValue().toString();
                        allstudentname[i-1]=name;
                        allsudentid[i-1]=studentId;

                        //---------------
                        row_container[i-1] = new LinearLayout(StudentattedenceList.this);
                        student_id_tv[i-1] = new TextView(StudentattedenceList.this);
                        student_name_tv[i-1]  = new TextView(StudentattedenceList.this);
                        student_status_tv[i-1]  = new TextView(StudentattedenceList.this);

                        row_container[i-1].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (35 * scale + 0.5f)));
                        row_container[i-1].setOrientation(LinearLayout.HORIZONTAL);



                        student_id_tv[i-1].setLayoutParams(new LinearLayout.LayoutParams((int) (132 * scale + 0.5f), (int) (35 * scale + 0.5f)));
                        student_name_tv[i-1].setLayoutParams(new LinearLayout.LayoutParams((int) (132 * scale + 0.5f), (int) (35 * scale + 0.5f)));
                        student_status_tv[i-1].setLayoutParams(new LinearLayout.LayoutParams((int) (132 * scale + 0.5f), (int) (35 * scale + 0.5f)));

                        student_id_tv[i-1].setText(studentId);
                        student_name_tv[i-1].setText(name);
                        if(status[0][i-1]=="absent"){
                            student_status_tv[i-1].setText("A");
                            student_status_tv[i-1].setTextColor(Color.RED);
                        }else{
                            student_status_tv[i-1].setText("P");
                            student_status_tv[i-1].setTextColor(Color.GREEN);

                        }

                        student_id_tv[i-1].setTextSize(15);
                        student_name_tv[i-1].setTextSize(15);
                        student_status_tv[i-1].setTextSize(18);

                        row_container[i-1].addView(student_id_tv[i-1]);
                        row_container[i-1].addView(student_name_tv[i-1]);
                        row_container[i-1].addView(student_status_tv[i-1]);
                        final int finalI = i;
                        row_container[i-1].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (status[0][finalI - 1].equals("absent")){
                                    student_status_tv[finalI -1].setText("P");
                                    student_status_tv[finalI -1].setTextColor(Color.GREEN);
                                    status[0][finalI-1]="present";
                                }else {
                                    student_status_tv[finalI -1].setText("A");
                                    student_status_tv[finalI -1].setTextColor(Color.RED);
                                    status[0][finalI -1]="absent";
                                }

                            }
                        });

                        container.addView(row_container[i-1]);




                    }



                }
                else {

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Button save_button = (Button)findViewById(R.id.button2);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//yha par jab save button dabega tab har ek student ke ander jaake datetime waale syudent ke ander jaaker
                //               naya status node banaio aur uski value true ya false kar dio
                //              aur child aaegi day ki ,lectureno kee,par avi corh de usko
//har ek student me iterate loop se kario jaise upar kia hai ....s+i lagak aur usnme status boolean arry ki value stus chid banake usme daal di

                if (is_this_first_time_marking_for_this_lecture[0] =true){


                    for (int i = 1; i<= noofstudent[0]; i++){
                        reference.child("IPEC").child("classes").child(year+"year").child("section").child(section).child("s"+i).child(datetime).child("status").setValue(status[0][i-1]);
                       // yaha par har ek student ke ander jaaker datetime child ke ander jaa aur fir  "status" child ke ander jaaker usko status[0][i-1] ki value update kar de
                    }

                }
                else{
                    for (int i = 1; i<= noofstudent[0]; i++){
                        //yaha par har ek student ke ander jaaker datetime child ke ander jaa aur usko ek aur child de "status" naam kaa aur usko status[0][i-1] ki value dede
                        reference.child("IPEC").child("classes").child(year+"year").child("section").child(section).child("s"+i).child(datetime).child("status").setValue(status[0][i-1]);


                    }


                }


            }
        });


    }
}