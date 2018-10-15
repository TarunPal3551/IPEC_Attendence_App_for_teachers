package appsforyou.tarun.com.ipecapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity_Teacher extends AppCompatActivity {
    //    CardView[][] lecturs=new CardView[6][8];
//    TextView [][] subjectname=new TextView[6][8];
    FirebaseDatabase database;
    private static final String TAG = "HomeActivity_Teacher";
    DatabaseReference reference;
    CardView monLecture1, monLecture2, monLecture3, monLecture4, monLecture5, monLecture6, monLecture7, monLecture8,
            tueLecture1, tueLecture2, tueLecture3, tueLecture4, tueLecture5, tueLecture6, tueLecture7, tueLecture8,
            wedlecture1, wedlecture2, wedlecture3, wedlecture4, wedlecture5, wedlecture6, wedlecture7, wedlecture8,
            thuLecture1, thuLecture2, thuLecture3, thuLecture4, thuLecture5, thuLecture6, thuLecture7, thuLecture8,
            friLecture1, friLecture2, friLecture3, friLecture4, friLecture5, friLecture6, friLecture7, friLecture8,
            satlecture1, satlecture2, satlecture3, satlecture4, satlecture5, satlecture6, satlecture7, satlecture8;


    TextView tvsubmonLecture1, tvsubmonLecture2, tvsubmonLecture3, tvsubmonLecture4, tvsubmonLecture5, tvsubmonLecture6, tvsubmonLecture7, tvsubmonLecture8,
            tvsubtueLecture1, tvsubtueLecture2, tvsubtueLecture3, tvsubtueLecture4, tvsubtueLecture5, tvsubtueLecture6, tvsubtueLecture7, tvsubtueLecture8,
            tvsubwedlecture1, tvsubwedlecture2, tvsubwedlecture3, tvsubwedlecture4, tvsubwedlecture5, tvsubwedlecture6, tvsubwedlecture7, tvsubwedlecture8,
            tvsubthuLecture1, tvsubthuLecture2, tvsubthuLecture3, tvsubthuLecture4, tvsubthuLecture5, tvsubthuLecture6, tvsubthuLecture7, tvsubthuLecture8,
            tvsubfriLecture1, tvsubfriLecture2, tvsubfriLecture3, tvsubfriLecture4, tvsubfriLecture5, tvsubfriLecture6, tvsubfriLecture7, tvsubfriLecture8,
            tvsubsatlecture1, tvsubsatlecture2, tvsubsatlecture3, tvsubsatlecture4, tvsubsatlecture5, tvsubsatlecture6, tvsubsatlecture7, tvsubsatlecture8;


    TextView tvyearmonLecture1, tvyearmonLecture2, tvyearmonLecture3, tvyearmonLecture4, tvyearmonLecture5, tvyearmonLecture6, tvyearmonLecture7, tvyearmonLecture8,
            tvyeartueLecture1, tvyeartueLecture2, tvyeartueLecture3, tvyeartueLecture4, tvyeartueLecture5, tvyeartueLecture6, tvyeartueLecture7, tvyeartueLecture8,
            tvyearwedlecture1, tvyearwedlecture2, tvyearwedlecture3, tvyearwedlecture4, tvyearwedlecture5, tvyearwedlecture6, tvyearwedlecture7, tvyearwedlecture8,
            tvyearthuLecture1, tvyearthuLecture2, tvyearthuLecture3, tvyearthuLecture4, tvyearthuLecture5, tvyearthuLecture6, tvyearthuLecture7, tvyearthuLecture8,
            tvyearfriLecture1, tvyearfriLecture2, tvyearfriLecture3, tvyearfriLecture4, tvyearfriLecture5, tvyearfriLecture6, tvyearfriLecture7, tvyearfriLecture8,
            tvyearsatlecture1, tvyearsatlecture2, tvyearsatlecture3, tvyearsatlecture4, tvyearsatlecture5, tvyearsatlecture6, tvyearsatlecture7, tvyearsatlecture8;

    TextView tvsecmonLecture1, tvsecmonLecture2, tvsecmonLecture3, tvsecmonLecture4, tvsecmonLecture5, tvsecmonLecture6, tvsecmonLecture7, tvsecmonLecture8,
            tvsectueLecture1, tvsectueLecture2, tvsectueLecture3, tvsectueLecture4, tvsectueLecture5, tvsectueLecture6, tvsectueLecture7, tvsectueLecture8,
            tvsecwedlecture1, tvsecwedlecture2, tvsecwedlecture3, tvsecwedlecture4, tvsecwedlecture5, tvsecwedlecture6, tvsecwedlecture7, tvsecwedlecture8,
            tvsecthuLecture1, tvsecthuLecture2, tvsecthuLecture3, tvsecthuLecture4, tvsecthuLecture5, tvsecthuLecture6, tvsecthuLecture7, tvsecthuLecture8,
            tvsecfriLecture1, tvsecfriLecture2, tvsecfriLecture3, tvsecfriLecture4, tvsecfriLecture5, tvsecfriLecture6, tvsecfriLecture7, tvsecfriLecture8,
            tvsecsatlecture1, tvsecsatlecture2, tvsecsatlecture3, tvsecsatlecture4, tvsecsatlecture5, tvsecsatlecture6, tvsecsatlecture7, tvsecsatlecture8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__teacher);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String teacher_id = bundle.getString("Teacher_id");
        getAllData(teacher_id);
        monLecture1 = (CardView) findViewById(R.id.monlecture1);
        monLecture2 = (CardView) findViewById(R.id.monlecture2);
        monLecture3 = (CardView) findViewById(R.id.monlecture3);
        monLecture4 = (CardView) findViewById(R.id.monlecture4);
        monLecture5 = (CardView) findViewById(R.id.monlecture5);
        monLecture6 = (CardView) findViewById(R.id.monlecture6);
        monLecture7 = (CardView) findViewById(R.id.monlecture7);
        monLecture8 = (CardView) findViewById(R.id.monlecture8);
        tueLecture1 = (CardView) findViewById(R.id.tuelecture1);
        tueLecture2 = (CardView) findViewById(R.id.tuelecture2);
        tueLecture3 = (CardView) findViewById(R.id.tuelecture3);
        tueLecture4 = (CardView) findViewById(R.id.tuelecture4);
        tueLecture5 = (CardView) findViewById(R.id.tuelecture5);
        tueLecture6 = (CardView) findViewById(R.id.tuelecture6);
        tueLecture7 = (CardView) findViewById(R.id.tuelecture7);
        tueLecture8 = (CardView) findViewById(R.id.tuelecture8);
        wedlecture1 = (CardView) findViewById(R.id.wedlecture1);
        wedlecture2 = (CardView) findViewById(R.id.wedlecture2);
        wedlecture3 = (CardView) findViewById(R.id.wedlecture3);
        wedlecture4 = (CardView) findViewById(R.id.wedlecture4);
        wedlecture5 = (CardView) findViewById(R.id.wedlecture5);
        wedlecture6 = (CardView) findViewById(R.id.wedlecture6);
        wedlecture7 = (CardView) findViewById(R.id.wedlecture7);
        wedlecture8 = (CardView) findViewById(R.id.wedlecture8);
        thuLecture1 = (CardView) findViewById(R.id.thulecture1);
        thuLecture2 = (CardView) findViewById(R.id.thulecture2);
        thuLecture3 = (CardView) findViewById(R.id.thulecture3);
        thuLecture4 = (CardView) findViewById(R.id.thulecture4);
        thuLecture5 = (CardView) findViewById(R.id.thulecture5);
        thuLecture6 = (CardView) findViewById(R.id.thulecture6);
        thuLecture7 = (CardView) findViewById(R.id.thulecture7);
        thuLecture8 = (CardView) findViewById(R.id.thulecture8);
        friLecture1 = (CardView) findViewById(R.id.frilecture1);
        friLecture2 = (CardView) findViewById(R.id.frilecture2);
        friLecture3 = (CardView) findViewById(R.id.frilecture3);
        friLecture4 = (CardView) findViewById(R.id.frilecture4);
        friLecture5 = (CardView) findViewById(R.id.frilecture5);
        friLecture6 = (CardView) findViewById(R.id.frilecture6);
        friLecture7 = (CardView) findViewById(R.id.frilecture7);
        friLecture8 = (CardView) findViewById(R.id.frilecture8);
        satlecture1 = (CardView) findViewById(R.id.satlecture1);
        satlecture2 = (CardView) findViewById(R.id.satlecture2);
        satlecture3 = (CardView) findViewById(R.id.satlecture3);
        satlecture4 = (CardView) findViewById(R.id.satlecture4);
        satlecture5 = (CardView) findViewById(R.id.satlecture5);
        satlecture6 = (CardView) findViewById(R.id.satlecture6);
        satlecture7 = (CardView) findViewById(R.id.satlecture7);
        satlecture8 = (CardView) findViewById(R.id.satlecture8);
        tvsecmonLecture1 = (TextView) findViewById(R.id.monlecture1yearsection);
        tvsecmonLecture2 = (TextView) findViewById(R.id.monlecture2yearsection);
        tvsecmonLecture3 = (TextView) findViewById(R.id.monlecture3yearsection);
        tvsecmonLecture4 = (TextView) findViewById(R.id.monlecture4yearsection);
        tvsecmonLecture5 = (TextView) findViewById(R.id.monlecture5yearsection);
        tvsecmonLecture6 = (TextView) findViewById(R.id.monlecture6yearsection);
        tvsecmonLecture7 = (TextView) findViewById(R.id.monlecture7yearsection);
        tvsecmonLecture8 = (TextView) findViewById(R.id.monlecture8yearsection);
        tvsectueLecture1 = (TextView) findViewById(R.id.tuelecture1yearsection);
        tvsectueLecture2 = (TextView) findViewById(R.id.tuelecture2yearsection);
        tvsectueLecture3 = (TextView) findViewById(R.id.tuelecture3yearsection);
        tvsectueLecture4 = (TextView) findViewById(R.id.tuelecture4yearsection);
        tvsectueLecture5 = (TextView) findViewById(R.id.tuelecture5yearsection);
        tvsectueLecture6 = (TextView) findViewById(R.id.tuelecture6yearsection);
        tvsectueLecture7 = (TextView) findViewById(R.id.tuelecture7yearsection);
        tvsectueLecture8 = (TextView) findViewById(R.id.tuelecture8yearsection);
        tvsecwedlecture1 = (TextView) findViewById(R.id.wedlecture1yearsection);
        tvsecwedlecture2 = (TextView) findViewById(R.id.wedlecture2yearsection);
        tvsecwedlecture3 = (TextView) findViewById(R.id.wedlecture3yearsection);
        tvsecwedlecture4 = (TextView) findViewById(R.id.wedlecture4yearsection);
        tvsecwedlecture5 = (TextView) findViewById(R.id.wedlecture5yearsection);
        tvsecwedlecture6 = (TextView) findViewById(R.id.wedlecture6yearsection);
        tvsecwedlecture7 = (TextView) findViewById(R.id.wedlecture7yearsection);
        tvsecwedlecture8 = (TextView) findViewById(R.id.wedlecture8yearsection);
        tvsecthuLecture1 = (TextView) findViewById(R.id.thulecture1yearsection);
        tvsecthuLecture2 = (TextView) findViewById(R.id.thulecture2yearsection);
        tvsecthuLecture3 = (TextView) findViewById(R.id.thulecture3yearsection);
        tvsecthuLecture4 = (TextView) findViewById(R.id.thulecture4yearsection);
        tvsecthuLecture5 = (TextView) findViewById(R.id.thulecture5yearsection);
        tvsecthuLecture6 = (TextView) findViewById(R.id.thulecture6yearsection);
        tvsecthuLecture7 = (TextView) findViewById(R.id.thulecture7yearsection);
        tvsecthuLecture8 = (TextView) findViewById(R.id.thulecture8yearsection);
        tvsecfriLecture1 = (TextView) findViewById(R.id.frilecture1yearsection);
        tvsecfriLecture2 = (TextView) findViewById(R.id.frilecture2yearsection);
        tvsecfriLecture3 = (TextView) findViewById(R.id.frilecture3yearsection);
        tvsecfriLecture4 = (TextView) findViewById(R.id.frilecture4yearsection);
        tvsecfriLecture5 = (TextView) findViewById(R.id.frilecture5yearsection);
        tvsecfriLecture6 = (TextView) findViewById(R.id.frilecture6yearsection);
        tvsecfriLecture7 = (TextView) findViewById(R.id.frilecture7yearsection);
        tvsecfriLecture8 = (TextView) findViewById(R.id.frilecture8yearsection);
        tvsecsatlecture1 = (TextView) findViewById(R.id.satlecture1yearsection);
        tvsecsatlecture2 = (TextView) findViewById(R.id.satlecture2yearsection);
        tvsecsatlecture3 = (TextView) findViewById(R.id.satlecture3yearsection);
        tvsecsatlecture4 = (TextView) findViewById(R.id.satlecture4yearsection);
        tvsecsatlecture5 = (TextView) findViewById(R.id.satlecture5yearsection);
        tvsecsatlecture6 = (TextView) findViewById(R.id.satlecture6yearsection);
        tvsecsatlecture7 = (TextView) findViewById(R.id.satlecture7yearsection);
        tvsecsatlecture8 = (TextView) findViewById(R.id.satlecture8yearsection);
        tvyearmonLecture1 = (TextView) findViewById(R.id.monlecture1year);
        tvyearmonLecture2 = (TextView) findViewById(R.id.monlecture2year);
        tvyearmonLecture3 = (TextView) findViewById(R.id.monlecture3year);
        tvyearmonLecture4 = (TextView) findViewById(R.id.monlecture4year);
        tvyearmonLecture5 = (TextView) findViewById(R.id.monlecture5year);
        tvyearmonLecture6 = (TextView) findViewById(R.id.monlecture6year);
        tvyearmonLecture7 = (TextView) findViewById(R.id.monlecture7year);
        tvyearmonLecture8 = (TextView) findViewById(R.id.monlecture8year);
        tvyeartueLecture1 = (TextView) findViewById(R.id.tuelecture1year);
        tvyeartueLecture2 = (TextView) findViewById(R.id.tuelecture2year);
        tvyeartueLecture3 = (TextView) findViewById(R.id.tuelecture3year);
        tvyeartueLecture4 = (TextView) findViewById(R.id.tuelecture4year);
        tvyeartueLecture5 = (TextView) findViewById(R.id.tuelecture5year);
        tvyeartueLecture6 = (TextView) findViewById(R.id.tuelecture6year);
        tvyeartueLecture7 = (TextView) findViewById(R.id.tuelecture7year);
        tvyeartueLecture8 = (TextView) findViewById(R.id.tuelecture8year);
        tvyearwedlecture1 = (TextView) findViewById(R.id.wedlecture1year);
        tvyearwedlecture2 = (TextView) findViewById(R.id.wedlecture2year);
        tvyearwedlecture3 = (TextView) findViewById(R.id.wedlecture3year);
        tvyearwedlecture4 = (TextView) findViewById(R.id.wedlecture4year);
        tvyearwedlecture5 = (TextView) findViewById(R.id.wedlecture5year);
        tvyearwedlecture6 = (TextView) findViewById(R.id.wedlecture6year);
        tvyearwedlecture7 = (TextView) findViewById(R.id.wedlecture7year);
        tvyearwedlecture8 = (TextView) findViewById(R.id.wedlecture8year);
        tvyearthuLecture1 = (TextView) findViewById(R.id.thulecture1year);
        tvyearthuLecture2 = (TextView) findViewById(R.id.thulecture2year);
        tvyearthuLecture3 = (TextView) findViewById(R.id.thulecture3year);
        tvyearthuLecture4 = (TextView) findViewById(R.id.thulecture4year);
        tvyearthuLecture5 = (TextView) findViewById(R.id.thulecture5year);
        tvyearthuLecture6 = (TextView) findViewById(R.id.thulecture6year);
        tvyearthuLecture7 = (TextView) findViewById(R.id.thulecture7year);
        tvyearthuLecture8 = (TextView) findViewById(R.id.thulecture8year);
        tvyearfriLecture1 = (TextView) findViewById(R.id.frilecture1year);
        tvyearfriLecture2 = (TextView) findViewById(R.id.frilecture2year);
        tvyearfriLecture3 = (TextView) findViewById(R.id.frilecture3year);
        tvyearfriLecture4 = (TextView) findViewById(R.id.frilecture4year);
        tvyearfriLecture5 = (TextView) findViewById(R.id.frilecture5year);
        tvyearfriLecture6 = (TextView) findViewById(R.id.frilecture6year);
        tvyearfriLecture7 = (TextView) findViewById(R.id.frilecture7year);
        tvyearfriLecture8 = (TextView) findViewById(R.id.frilecture8year);
        tvyearsatlecture1 = (TextView) findViewById(R.id.satlecture1year);
        tvyearsatlecture2 = (TextView) findViewById(R.id.satlecture2year);
        tvyearsatlecture3 = (TextView) findViewById(R.id.satlecture3year);
        tvyearsatlecture4 = (TextView) findViewById(R.id.satlecture4year);
        tvyearsatlecture5 = (TextView) findViewById(R.id.satlecture5year);
        tvyearsatlecture6 = (TextView) findViewById(R.id.satlecture6year);
        tvyearsatlecture7 = (TextView) findViewById(R.id.satlecture7year);
        tvyearsatlecture8 = (TextView) findViewById(R.id.satlecture8year);


        tvsubmonLecture1 = (TextView) findViewById(R.id.monlecture1subject1);
        tvsubmonLecture2 = (TextView) findViewById(R.id.monlecture2subject2);
        tvsubmonLecture3 = (TextView) findViewById(R.id.monlecture3subject3);
        tvsubmonLecture4 = (TextView) findViewById(R.id.monlecture4subject4);
        tvsubmonLecture5 = (TextView) findViewById(R.id.monlecture5subject5);
        tvsubmonLecture6 = (TextView) findViewById(R.id.monlecture6subject6);
        tvsubmonLecture7 = (TextView) findViewById(R.id.monlecture7subject7);
        tvsubmonLecture8 = (TextView) findViewById(R.id.monlecture8subject8);


        tvsubtueLecture1 = (TextView) findViewById(R.id.tuelecture1subject1);
        tvsubtueLecture2 = (TextView) findViewById(R.id.tuelecture2subject2);
        tvsubtueLecture3 = (TextView) findViewById(R.id.tuelecture3subject3);
        tvsubtueLecture4 = (TextView) findViewById(R.id.tuelecture4subject4);
        tvsubtueLecture5 = (TextView) findViewById(R.id.tuelecture5subject5);
        tvsubtueLecture6 = (TextView) findViewById(R.id.tuelecture6subject6);
        tvsubtueLecture7 = (TextView) findViewById(R.id.tuelecture7subject7);
        tvsubtueLecture8 = (TextView) findViewById(R.id.tuelecture8subject8);

        tvsubwedlecture1 = (TextView) findViewById(R.id.wedlecture1subject1);
        tvsubwedlecture2 = (TextView) findViewById(R.id.wedlecture2subject2);
        tvsubwedlecture3 = (TextView) findViewById(R.id.wedlecture3subject3);
        tvsubwedlecture4 = (TextView) findViewById(R.id.wedlecture4subject4);
        tvsubwedlecture5 = (TextView) findViewById(R.id.wedlecture5subject5);
        tvsubwedlecture6 = (TextView) findViewById(R.id.wedlecture6subject6);
        tvsubwedlecture7 = (TextView) findViewById(R.id.wedlecture7subject7);
        tvsubwedlecture8 = (TextView) findViewById(R.id.wedlecture8subject8);


        tvsubthuLecture1 = (TextView) findViewById(R.id.thulecture1subject1);
        tvsubthuLecture2 = (TextView) findViewById(R.id.thulecture2subject2);

        tvsubthuLecture3 = (TextView) findViewById(R.id.thulecture3subject3);
        tvsubthuLecture4 = (TextView) findViewById(R.id.thulecture4subject4);

        tvsubthuLecture5 = (TextView) findViewById(R.id.thulecture5subject5);
        tvsubthuLecture6 = (TextView) findViewById(R.id.thulecture6subject6);

        tvsubthuLecture7 = (TextView) findViewById(R.id.thulecture7subject7);
        tvsubthuLecture8 = (TextView) findViewById(R.id.thulecture8subject8);


        tvsubfriLecture1 = (TextView) findViewById(R.id.frilecture1subject1);
        tvsubfriLecture2 = (TextView) findViewById(R.id.frilecture2subject2);
        tvsubfriLecture3 = (TextView) findViewById(R.id.frilecture3subject3);
        tvsubfriLecture4 = (TextView) findViewById(R.id.frilecture4subject4);
        tvsubfriLecture5 = (TextView) findViewById(R.id.frilecture5subject5);
        tvsubfriLecture6 = (TextView) findViewById(R.id.frilecture6subject6);
        tvsubfriLecture7 = (TextView) findViewById(R.id.frilecture7subject7);
        tvsubfriLecture8 = (TextView) findViewById(R.id.frilecture8subject8);

        tvsubsatlecture1 = (TextView) findViewById(R.id.satlecture1subject1);
        tvsubsatlecture2 = (TextView) findViewById(R.id.satlecture2subject2);
        tvsubsatlecture3 = (TextView) findViewById(R.id.satlecture3subject3);
        tvsubsatlecture4 = (TextView) findViewById(R.id.satlecture4subject4);
        tvsubsatlecture5 = (TextView) findViewById(R.id.satlecture5subject5);
        tvsubsatlecture6 = (TextView) findViewById(R.id.satlecture6subject6);
        tvsubsatlecture7 = (TextView) findViewById(R.id.satlecture7subject7);
        tvsubsatlecture8 = (TextView) findViewById(R.id.satlecture8subject8);
        monLecture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card1=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card1.putExtra("year",tvyearmonLecture1.getText().toString());
                card1.putExtra("section",tvsecmonLecture1.getText().toString());
                startActivity(card1);
            }
        });
        monLecture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card2=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card2.putExtra("year",tvyearmonLecture2.getText().toString());
                card2.putExtra("section",tvsecmonLecture2.getText().toString());
                startActivity(card2);

            }
        });
        monLecture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card3=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card3.putExtra("year",tvyearmonLecture3.getText().toString());
                card3.putExtra("section",tvsecmonLecture3.getText().toString());
                startActivity(card3);

            }
        });
        monLecture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card4=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card4.putExtra("year",tvyearmonLecture4.getText().toString());
                card4.putExtra("section",tvsecmonLecture4.getText().toString());
                startActivity(card4);

            }
        });
        monLecture5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card5=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card5.putExtra("year",tvyearmonLecture5.getText().toString());
                card5.putExtra("section",tvsecmonLecture5.getText().toString());
                startActivity(card5);

            }
        });
        monLecture6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card6=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card6.putExtra("year",tvyearmonLecture6.getText().toString());
                card6.putExtra("section",tvsecmonLecture6.getText().toString());
                startActivity(card6);

            }
        });
        monLecture7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card7=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card7.putExtra("year",tvyearmonLecture7.getText().toString());
                card7.putExtra("section",tvsecmonLecture7.getText().toString());
                startActivity(card7);

            }
        });
        monLecture8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card8=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card8.putExtra("year",tvyearmonLecture8.getText().toString());
                card8.putExtra("section",tvsecmonLecture8.getText().toString());
                startActivity(card8);

            }
        });
        tueLecture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card1=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card1.putExtra("year",tvyeartueLecture1.getText().toString());
                card1.putExtra("section",tvsectueLecture1.getText().toString());
                startActivity(card1);

            }
        });
        tueLecture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card2=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card2.putExtra("year",tvyeartueLecture2.getText().toString());
                card2.putExtra("section",tvsectueLecture2.getText().toString());
                startActivity(card2);

            }
        });
        tueLecture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card3=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card3.putExtra("year",tvyeartueLecture3.getText().toString());
                card3.putExtra("section",tvsectueLecture3.getText().toString());
                startActivity(card3);

            }
        });
        tueLecture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card4=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card4.putExtra("year",tvyeartueLecture4.getText().toString());
                card4.putExtra("section",tvsectueLecture4.getText().toString());
                startActivity(card4);

            }
        });
        tueLecture5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card5=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card5.putExtra("year",tvyeartueLecture5.getText().toString());
                card5.putExtra("section",tvsectueLecture5.getText().toString());
                startActivity(card5);

            }
        });
        tueLecture6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card6=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card6.putExtra("year",tvyeartueLecture6.getText().toString());
                card6.putExtra("section",tvsectueLecture6.getText().toString());
                startActivity(card6);

            }
        });
        tueLecture7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card7=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card7.putExtra("year",tvyeartueLecture7.getText().toString());
                card7.putExtra("section",tvsectueLecture7.getText().toString());
                startActivity(card7);

            }
        });
        tueLecture8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card8=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card8.putExtra("year",tvyeartueLecture8.getText().toString());
                card8.putExtra("section",tvsectueLecture8.getText().toString());
                startActivity(card8);

            }
        });
        wedlecture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card1=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card1.putExtra("year",tvyearwedlecture1.getText().toString());
                card1.putExtra("section",tvsecwedlecture1.getText().toString());
                startActivity(card1);

            }
        });
        wedlecture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card2=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card2.putExtra("year",tvyearwedlecture2.getText().toString());
                card2.putExtra("section",tvsecwedlecture2.getText().toString());
                startActivity(card2);

            }
        });
        wedlecture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card3=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card3.putExtra("year",tvyearwedlecture3.getText().toString());
                card3.putExtra("section",tvsecwedlecture3.getText().toString());
                startActivity(card3);

            }
        });
        wedlecture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card4=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card4.putExtra("year",tvyearwedlecture4.getText().toString());
                card4.putExtra("section",tvsecwedlecture4.getText().toString());
                startActivity(card4);

            }
        });
        wedlecture5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card5=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card5.putExtra("year",tvyearwedlecture5.getText().toString());
                card5.putExtra("section",tvsecwedlecture5.getText().toString());
                startActivity(card5);

            }
        });
        wedlecture6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card6=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card6.putExtra("year",tvyearwedlecture6.getText().toString());
                card6.putExtra("section",tvsecwedlecture6.getText().toString());
                startActivity(card6);

            }
        });
        wedlecture7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card7=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card7.putExtra("year",tvyearwedlecture7.getText().toString());
                card7.putExtra("section",tvsecwedlecture7.getText().toString());
                startActivity(card7);

            }
        });
        wedlecture8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card8=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card8.putExtra("year",tvyearwedlecture5.getText().toString());
                card8.putExtra("section",tvsecwedlecture5.getText().toString());
                startActivity(card8);

            }
        });
        thuLecture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card1=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card1.putExtra("year",tvyearthuLecture1.getText().toString());
                card1.putExtra("section",tvsecthuLecture1.getText().toString());
                startActivity(card1);

            }
        });
        thuLecture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card2=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card2.putExtra("year",tvyearthuLecture2.getText().toString());
                card2.putExtra("section",tvsecthuLecture2.getText().toString());
                startActivity(card2);

            }
        });
        thuLecture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card3=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card3.putExtra("year",tvyearthuLecture3.getText().toString());
                card3.putExtra("section",tvsecthuLecture3.getText().toString());
                startActivity(card3);

            }
        });
        thuLecture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card4=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card4.putExtra("year",tvyearthuLecture4.getText().toString());
                card4.putExtra("section",tvsecthuLecture4.getText().toString());
                startActivity(card4);

            }
        });
        thuLecture5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card5=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card5.putExtra("year",tvyearthuLecture5.getText().toString());
                card5.putExtra("section",tvsecthuLecture5.getText().toString());
                startActivity(card5);

            }
        });
        thuLecture6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card6=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card6.putExtra("year",tvyearthuLecture6.getText().toString());
                card6.putExtra("section",tvsecthuLecture6.getText().toString());
                startActivity(card6);

            }
        });
        thuLecture7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card7=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card7.putExtra("year",tvyearthuLecture7.getText().toString());
                card7.putExtra("section",tvsecthuLecture7.getText().toString());
                startActivity(card7);

            }
        });
        thuLecture8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card8=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card8.putExtra("year",tvyearthuLecture8.getText().toString());
                card8.putExtra("section",tvsecthuLecture8.getText().toString());
                startActivity(card8);

            }
        });
        friLecture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card1=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card1.putExtra("year",tvyearfriLecture1.getText().toString());
                card1.putExtra("section",tvsecfriLecture1.getText().toString());
                startActivity(card1);

            }
        });
        friLecture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card2=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card2.putExtra("year",tvyearfriLecture2.getText().toString());
                card2.putExtra("section",tvsecfriLecture2.getText().toString());
                startActivity(card2);

            }
        });
        friLecture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card2=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card2.putExtra("year",tvyearfriLecture2.getText().toString());
                card2.putExtra("section",tvsecfriLecture2.getText().toString());
                startActivity(card2);

            }
        });
        friLecture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card4=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card4.putExtra("year",tvyearfriLecture2.getText().toString());
                card4.putExtra("section",tvsecfriLecture2.getText().toString());
                startActivity(card4);

            }
        });
        friLecture5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card5=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card5.putExtra("year",tvyearfriLecture5.getText().toString());
                card5.putExtra("section",tvsecfriLecture5.getText().toString());
                startActivity(card5);

            }
        });
        friLecture6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card6=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card6.putExtra("year",tvyearfriLecture6.getText().toString());
                card6.putExtra("section",tvsecfriLecture6.getText().toString());
                startActivity(card6);

            }
        });
        friLecture7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card7=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card7.putExtra("year",tvyearfriLecture7.getText().toString());
                card7.putExtra("section",tvsecfriLecture7.getText().toString());
                startActivity(card7);

            }
        });
        friLecture8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card8=new Intent(HomeActivity_Teacher.this,StudentattedenceList.class);
                card8.putExtra("year",tvyearfriLecture8.getText().toString());
                card8.putExtra("section",tvsecfriLecture8.getText().toString());
                startActivity(card8);

            }
        });






    }


    private void getAllData(String teacher_id) {

        Query query = reference.child("IPEC").child("Teachers").child(teacher_id);
        if (query != null) {
            Log.d(TAG, "loginwithteacherCrenditals: " + query);
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("TimeTable").hasChild("Monday")) {
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("1_per")) {
                            String mondaylecture1teachersection = dataSnapshot.child("TimeTable").child("Monday").child("1_per").child("class").child("section").getValue().toString();
                            String mondaylecture1year = dataSnapshot.child("TimeTable").child("Monday").child("1_per").child("class").child("year").getValue().toString();
                            String mondaylecture1subject = dataSnapshot.child("TimeTable").child("Monday").child("1_per").child("class").child("subject").getValue().toString();

                            tvsecmonLecture1.setText(mondaylecture1teachersection);
                            tvyearmonLecture1.setText(mondaylecture1year);
                            tvsubmonLecture1.setText(mondaylecture1subject);
                            Log.d(TAG, "onDataChange: " + mondaylecture1teachersection + "     " + mondaylecture1year);
                            Toast.makeText(HomeActivity_Teacher.this, mondaylecture1teachersection + "" + mondaylecture1year, Toast.LENGTH_LONG).show();
                        } else {
                            tvsecmonLecture1.setText("N/A");
                            tvyearmonLecture1.setText("N/A");
                            tvsubmonLecture1.setText("N/A");
                            monLecture1.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));
                        }
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("2_per")) {
                            String mondaylecture2teachersection = dataSnapshot.child("TimeTable").child("Monday").child("2_per").child("class").child("section").getValue().toString();
                            String mondaylecture2lectureyear = dataSnapshot.child("TimeTable").child("Monday").child("2_per").child("class").child("year").getValue().toString();
                            String mondaylecture2subject = dataSnapshot.child("TimeTable").child("Monday").child("2_per").child("class").child("subject").getValue().toString();
                            tvsecmonLecture2.setText(mondaylecture2teachersection);
                            tvyearmonLecture2.setText(mondaylecture2lectureyear);
                            tvsubmonLecture2.setText(mondaylecture2subject);

                        } else {
                            tvsecmonLecture2.setText("N/A");
                            tvyearmonLecture2.setText("N/A");
                            tvsubmonLecture2.setText("N/A");
                            monLecture2.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("3_per")) {
                            String mondaylecture3teachersection = dataSnapshot.child("TimeTable").child("Monday").child("3_per").child("class").child("section").getValue().toString();
                            String mondaylecture3lectureyear = dataSnapshot.child("TimeTable").child("Monday").child("3_per").child("class").child("year").getValue().toString();
                            tvsecmonLecture3.setText(mondaylecture3teachersection);
                            tvyearmonLecture3.setText(mondaylecture3lectureyear);
                            String mondaylecture3subject = dataSnapshot.child("TimeTable").child("Monday").child("3_per").child("class").child("subject").getValue().toString();
                            tvsubmonLecture3.setText(mondaylecture3subject);
                        } else {
                            tvsecmonLecture3.setText("N/A");
                            tvyearmonLecture3.setText("N/A");
                            tvsubmonLecture3.setText("N/A");
                            monLecture3.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("4_per")) {
                            String mondaylecture4teachersection = dataSnapshot.child("TimeTable").child("Monday").child("4_per").child("class").child("section").getValue().toString();
                            String mondaylecture4lectureyear = dataSnapshot.child("TimeTable").child("Monday").child("4_per").child("class").child("year").getValue().toString();
                            tvsecmonLecture4.setText(mondaylecture4teachersection);
                            tvyearmonLecture4.setText(mondaylecture4lectureyear);
                            String mondaylecture4subject = dataSnapshot.child("TimeTable").child("Monday").child("4_per").child("class").child("subject").getValue().toString();
                            tvsubmonLecture4.setText(mondaylecture4subject);

                        } else {
                            tvsecmonLecture4.setText("N/A");
                            tvyearmonLecture4.setText("N/A");
                            tvsubmonLecture4.setText("N/A");
                            monLecture4.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("5_per")) {
                            String mondaylecture5teachersection = dataSnapshot.child("TimeTable").child("Monday").child("5_per").child("class").child("section").getValue().toString();
                            String mondaylecture5lectureyear = dataSnapshot.child("TimeTable").child("Monday").child("5_per").child("class").child("year").getValue().toString();
                            tvsecmonLecture5.setText(mondaylecture5teachersection);
                            tvyearmonLecture5.setText(mondaylecture5lectureyear);
                            String mondaylecture5subject = dataSnapshot.child("TimeTable").child("Monday").child("5_per").child("class").child("subject").getValue().toString();
                            tvsubmonLecture5.setText(mondaylecture5subject);


                        } else {
                            tvsecmonLecture5.setText("N/A");
                            tvyearmonLecture5.setText("N/A");
                            tvsubmonLecture5.setText("N/A");
                            monLecture5.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("6_per")) {
                            String mondaylecture6teachersection = dataSnapshot.child("TimeTable").child("Monday").child("6_per").child("class").child("section").getValue().toString();
                            String mondaylecture6lectureyear = dataSnapshot.child("TimeTable").child("Monday").child("6_per").child("class").child("year").getValue().toString();
                            tvsecmonLecture6.setText(mondaylecture6teachersection);
                            tvyearmonLecture6.setText(mondaylecture6lectureyear);
                            String mondaylecture6subject = dataSnapshot.child("TimeTable").child("Monday").child("6_per").child("class").child("subject").getValue().toString();
                            tvsubmonLecture6.setText(mondaylecture6subject);


                        } else {
                            tvsecmonLecture6.setText("N/A");
                            tvyearmonLecture6.setText("N/A");
                            tvsubmonLecture6.setText("N/A");
                            monLecture6.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("7_per")) {
                            String mondaylecture7teachersection = dataSnapshot.child("TimeTable").child("Monday").child("7_per").child("class").child("section").getValue().toString();
                            String mondaylecture7lectureyear = dataSnapshot.child("TimeTable").child("Monday").child("7_per").child("class").child("year").getValue().toString();
                            tvsecmonLecture7.setText(mondaylecture7teachersection);
                            tvyearmonLecture7.setText(mondaylecture7lectureyear);
                            String mondaylecture7subject = dataSnapshot.child("TimeTable").child("Monday").child("7_per").child("class").child("subject").getValue().toString();
                            tvsubmonLecture7.setText(mondaylecture7subject);


                        } else {
                            tvsecmonLecture7.setText("N/A");
                            tvyearmonLecture7.setText("N/A");
                            tvsubmonLecture7.setText("N/A");
                            monLecture7.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Monday").hasChild("8_per")) {
                            String mondaylecture8teachersection = dataSnapshot.child("TimeTable").child("Monday").child("8_per").child("class").child("section").getValue().toString();
                            String mondaylecture8lectureyear = dataSnapshot.child("TimeTable").child("Monday").child("8_per").child("class").child("year").getValue().toString();
                            tvsecmonLecture8.setText(mondaylecture8teachersection);
                            tvyearmonLecture8.setText(mondaylecture8lectureyear);
                            String mondaylecture8subject = dataSnapshot.child("TimeTable").child("Monday").child("8_per").child("class").child("subject").getValue().toString();
                            tvsubmonLecture8.setText(mondaylecture8subject);


                        } else {
                            tvsecmonLecture8.setText("N/A");
                            tvyearmonLecture8.setText("N/A");
                            tvsubmonLecture8.setText("N/A");
                            monLecture8.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }


                    }
                    if (dataSnapshot.child("TimeTable").hasChild("Tuesday")) {
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("1_per")) {
                            String tuesdaylecture1teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("1_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture1lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("1_per").child("class").child("year").getValue().toString();
                            tvsectueLecture1.setText(tuesdaylecture1teachersection);
                            tvyeartueLecture1.setText(tuesdaylecture1lectureyear);
                            String tuesdaylecture1subject = dataSnapshot.child("TimeTable").child("Tuesday").child("1_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture1.setText(tuesdaylecture1subject);

                        } else {
                            tvsectueLecture1.setText("N/A");
                            tvyeartueLecture1.setText("N/A");
                            tvsubtueLecture1.setText("N/A");
                            tueLecture1.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("2_per")) {
                            String tuesdaylecture2teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("2_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture2lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("2_per").child("class").child("year").getValue().toString();
                            tvsectueLecture2.setText(tuesdaylecture2teachersection);
                            tvyeartueLecture2.setText(tuesdaylecture2lectureyear);
                            String tuesdaylecture2subject = dataSnapshot.child("TimeTable").child("Tuesday").child("2_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture2.setText(tuesdaylecture2subject);

                        } else {
                            tvsectueLecture2.setText("N/A");
                            tvyeartueLecture2.setText("N/A");
                            tvsubtueLecture2.setText("N/A");
                            tueLecture2.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("3_per")) {
                            String tuesdaylecture3teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("3_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture3lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("3_per").child("class").child("year").getValue().toString();
                            tvsectueLecture3.setText(tuesdaylecture3teachersection);
                            tvyeartueLecture3.setText(tuesdaylecture3lectureyear);
                            String tuesdaylecture3subject = dataSnapshot.child("TimeTable").child("Tuesday").child("3_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture3.setText(tuesdaylecture3subject);

                        } else {
                            tvsectueLecture3.setText("N/A");
                            tvyeartueLecture3.setText("N/A");
                            tvsubtueLecture3.setText("N/A");
                            tueLecture3.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("4_per")) {
                            String tuesdaylecture4teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("4_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture4lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("4_per").child("class").child("year").getValue().toString();
                            tvsectueLecture4.setText(tuesdaylecture4teachersection);
                            tvyeartueLecture4.setText(tuesdaylecture4lectureyear);
                            String tuesdaylecture4subject = dataSnapshot.child("TimeTable").child("Tuesday").child("4_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture4.setText(tuesdaylecture4subject);

                        } else {
                            tvsectueLecture4.setText("N/A");
                            tvyeartueLecture4.setText("N/A");
                            tvsubtueLecture4.setText("N/A");
                            tueLecture4.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("5_per")) {
                            String tuesdaylecture5teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("5_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture5lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("5_per").child("class").child("year").getValue().toString();
                            tvsectueLecture5.setText(tuesdaylecture5teachersection);
                            tvyeartueLecture5.setText(tuesdaylecture5lectureyear);
                            String tuesdaylecture5subject = dataSnapshot.child("TimeTable").child("Tuesday").child("5_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture5.setText(tuesdaylecture5subject);

                        } else {
                            tvsectueLecture5.setText("N/A");
                            tvyeartueLecture5.setText("N/A");
                            tvsubtueLecture5.setText("N/A");
                            tueLecture5.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("6_per")) {
                            String tuesdaylecture6teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("6_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture6lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("6_per").child("class").child("year").getValue().toString();
                            tvsectueLecture6.setText(tuesdaylecture6teachersection);
                            tvyeartueLecture6.setText(tuesdaylecture6lectureyear);
                            String tuesdaylecture6subject = dataSnapshot.child("TimeTable").child("Tuesday").child("6_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture6.setText(tuesdaylecture6subject);

                        } else {
                            tvsectueLecture6.setText("N/A");
                            tvyeartueLecture6.setText("N/A");
                            tvsubtueLecture6.setText("N/A");
                           tueLecture6.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("7_per")) {
                            String tuesdaylecture7teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("7_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture7lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("7_per").child("class").child("year").getValue().toString();
                            tvsectueLecture7.setText(tuesdaylecture7teachersection);
                            tvyeartueLecture7.setText(tuesdaylecture7lectureyear);
                            String tuesdaylecture7subject = dataSnapshot.child("TimeTable").child("Tuesday").child("7_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture7.setText(tuesdaylecture7subject);

                        } else {
                            tvsectueLecture7.setText("N/A");
                            tvyeartueLecture7.setText("N/A");
                            tvsubtueLecture7.setText("N/A");
                           tueLecture7.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Tuesday").hasChild("8_per")) {
                            String tuesdaylecture8teachersection = dataSnapshot.child("TimeTable").child("Tuesday").child("8_per").child("class").child("section").getValue().toString();
                            String tuesdaylecture8lectureyear = dataSnapshot.child("TimeTable").child("Tuesday").child("8_per").child("class").child("year").getValue().toString();
                            tvsectueLecture8.setText(tuesdaylecture8teachersection);
                            tvyeartueLecture8.setText(tuesdaylecture8lectureyear);
                            String tuesdaylecture8subject = dataSnapshot.child("TimeTable").child("Tuesday").child("7_per").child("class").child("subject").getValue().toString();
                            tvsubtueLecture8.setText(tuesdaylecture8subject);
                        } else {
                            tvsectueLecture8.setText("N/A");
                            tvyeartueLecture8.setText("N/A");
                            tvsubtueLecture8.setText("N/A");
                           tueLecture8.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }


                    }
                    if (dataSnapshot.child("TimeTable").hasChild("Wednesday")) {
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("1_per")) {
                            String wednesdaylecture1teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("1_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture1lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("1_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture1.setText(wednesdaylecture1teachersection);
                            tvyearwedlecture1.setText(wednesdaylecture1lectureyear);
                            String wednesdaylecture1subject = dataSnapshot.child("TimeTable").child("Wednesday").child("1_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture1.setText(wednesdaylecture1subject);


                        } else {
                            tvsecwedlecture1.setText("N/A");
                            tvyearwedlecture1.setText("N/A");
                            tvsubwedlecture1.setText("N/A");
                            wedlecture1.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));
                        }
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("2_per")) {
                            String wednesdaylecture2teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("2_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture2lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("2_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture2.setText(wednesdaylecture2teachersection);
                            tvyearwedlecture2.setText(wednesdaylecture2lectureyear);
                            String wednesdaylecture2subject = dataSnapshot.child("TimeTable").child("Wednesday").child("2_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture2.setText(wednesdaylecture2subject);

                        } else {
                            tvsecwedlecture2.setText("N/A");
                            tvyearwedlecture2.setText("N/A");
                            tvsubwedlecture2.setText("N/A");
                            wedlecture2.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("3_per")) {
                            String wednesdaylecture3teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("3_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture3lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("3_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture3.setText(wednesdaylecture3teachersection);
                            tvyearwedlecture3.setText(wednesdaylecture3lectureyear);
                            String wednesdaylecture3subject = dataSnapshot.child("TimeTable").child("Wednesday").child("3_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture3.setText(wednesdaylecture3subject);

                        } else {
                            tvsecwedlecture3.setText("N/A");
                            tvyearwedlecture3.setText("N/A");
                            tvsubwedlecture3.setText("N/A");
                            wedlecture3.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("4_per")) {
                            String wednesdaylecture4teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("4_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture4lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("4_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture4.setText(wednesdaylecture4teachersection);
                            tvyearwedlecture4.setText(wednesdaylecture4lectureyear);
                            String wednesdaylecture4subject = dataSnapshot.child("TimeTable").child("Wednesday").child("4_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture4.setText(wednesdaylecture4subject);


                        } else {
                            tvsecwedlecture4.setText("N/A");
                            tvyearwedlecture4.setText("N/A");
                            tvsubwedlecture4.setText("N/A");
                            wedlecture4.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));
                        }
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("5_per")) {
                            String wednesdaylecture5teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("5_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture5lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("5_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture5.setText(wednesdaylecture5teachersection);
                            tvyearwedlecture5.setText(wednesdaylecture5lectureyear);
                            String wednesdaylecture5subject = dataSnapshot.child("TimeTable").child("Wednesday").child("5_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture5.setText(wednesdaylecture5subject);

                        } else {
                            tvsecwedlecture5.setText("N/A");
                            tvyearwedlecture5.setText("N/A");
                            tvsubwedlecture6.setText("N/A");
                            wedlecture5.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("6_per")) {
                            String wednesdaylecture6teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("6_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture6lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("6_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture6.setText(wednesdaylecture6teachersection);
                            tvyearwedlecture6.setText(wednesdaylecture6lectureyear);
                            String wednesdaylecture6subject = dataSnapshot.child("TimeTable").child("Wednesday").child("6_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture6.setText(wednesdaylecture6subject);


                        } else {
                            tvsecwedlecture6.setText("N/A");
                            tvyearwedlecture6.setText("N/A");
                            tvsubwedlecture6.setText("N/A");
                            wedlecture6.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("7_per")) {
                            String wednesdaylecture7teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("7_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture7lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("7_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture7.setText(wednesdaylecture7teachersection);
                            tvyearwedlecture7.setText(wednesdaylecture7lectureyear);
                            String wednesdaylecture7subject = dataSnapshot.child("TimeTable").child("Wednesday").child("7_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture7.setText(wednesdaylecture7subject);


                        } else {
                            tvsecwedlecture7.setText("N/A");
                            tvyearwedlecture7.setText("N/A");
                            tvsubwedlecture7.setText("N/A");
                            wedlecture7.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Wednesday").hasChild("8_per")) {
                            String wednesdaylecture8teachersection = dataSnapshot.child("TimeTable").child("Wednesday").child("8_per").child("class").child("section").getValue().toString();
                            String wednesdaylecture8lectureyear = dataSnapshot.child("TimeTable").child("Wednesday").child("8_per").child("class").child("year").getValue().toString();
                            tvsecwedlecture8.setText(wednesdaylecture8teachersection);
                            tvyearwedlecture8.setText(wednesdaylecture8lectureyear);
                            String wednesdaylecture8subject = dataSnapshot.child("TimeTable").child("Wednesday").child("8_per").child("class").child("subject").getValue().toString();
                            tvsubwedlecture8.setText(wednesdaylecture8subject);


                        } else {
                            tvsecwedlecture8.setText("N/A");
                            tvyearwedlecture8.setText("N/A");
                            tvsubwedlecture8.setText("N/A");
                            wedlecture8.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }


                    }
                    if (dataSnapshot.child("TimeTable").hasChild("Thursday")) {
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("1_per")) {
                            String thursdaylecture1teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("1_per").child("class").child("section").getValue().toString();
                            String thursdaylecture1lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("1_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture1.setText(thursdaylecture1teachersection);
                            tvyearthuLecture1.setText(thursdaylecture1lectureyear);
                            String thursdaylecture1subject = dataSnapshot.child("TimeTable").child("Thursday").child("1_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture1.setText(thursdaylecture1subject);


                        } else {
                            tvsecthuLecture1.setText("N/A");
                            tvyearthuLecture1.setText("N/A");
                            tvsubthuLecture1.setText("N/A");
                            thuLecture1.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("2_per")) {
                            String thursdaylecture2teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("2_per").child("class").child("section").getValue().toString();
                            String thursdaylecture2lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("2_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture2.setText(thursdaylecture2teachersection);
                            tvyearthuLecture2.setText(thursdaylecture2lectureyear);
                            String thursdaylecture2subject = dataSnapshot.child("TimeTable").child("Thursday").child("2_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture2.setText(thursdaylecture2subject);

                        } else {
                            tvsecthuLecture2.setText("N/A");
                            tvyearthuLecture2.setText("N/A");
                            tvsubthuLecture2.setText("N/A");
                            thuLecture2.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("3_per")) {
                            String thursdaylecture3teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("3_per").child("class").child("section").getValue().toString();
                            String thursdaylecture3lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("3_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture3.setText(thursdaylecture3teachersection);
                            tvyearthuLecture3.setText(thursdaylecture3lectureyear);
                            String thursdaylecture3subject = dataSnapshot.child("TimeTable").child("Thursday").child("3_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture3.setText(thursdaylecture3subject);

                        } else {
                            tvsecthuLecture3.setText("N/A");
                            tvyearthuLecture3.setText("N/A");
                            tvsubthuLecture3.setText("N/A");
                            thuLecture3.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("4_per")) {
                            String thursdaylecture4teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("4_per").child("class").child("section").getValue().toString();
                            String thursdaylecture4lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("4_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture4.setText(thursdaylecture4teachersection);
                            tvyearthuLecture4.setText(thursdaylecture4lectureyear);
                            String thursdaylecture4subject = dataSnapshot.child("TimeTable").child("Thursday").child("4_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture4.setText(thursdaylecture4subject);
                        } else {
                            tvsecthuLecture4.setText("N/A");
                            tvyearthuLecture4.setText("N/A");
                            tvsubthuLecture4.setText("N/A");
                           thuLecture4.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("5_per")) {
                            String thursdaylecture5teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("5_per").child("class").child("section").getValue().toString();
                            String thursdaylecture5lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("5_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture5.setText(thursdaylecture5teachersection);
                            tvyearthuLecture5.setText(thursdaylecture5lectureyear);
                            String thursdaylecture5subject = dataSnapshot.child("TimeTable").child("Thursday").child("5_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture5.setText(thursdaylecture5subject);

                        } else {
                            tvsecthuLecture5.setText("N/A");
                            tvyearthuLecture5.setText("N/A");
                            tvsubthuLecture5.setText("N/A");
                            thuLecture5.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("6_per")) {
                            String thursdaylecture6teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("6_per").child("class").child("section").getValue().toString();
                            String thursdaylecture6lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("6_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture6.setText(thursdaylecture6teachersection);
                            tvyearthuLecture6.setText(thursdaylecture6lectureyear);
                            String thursdaylecture6subject = dataSnapshot.child("TimeTable").child("Thursday").child("6_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture6.setText(thursdaylecture6subject);

                        } else {

                            tvsecthuLecture6.setText("N/A");
                            tvyearthuLecture6.setText("N/A");
                            tvsubthuLecture6.setText("N/A");
                           thuLecture6.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("7_per")) {
                            String thursdaylecture7teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("7_per").child("class").child("section").getValue().toString();
                            String thursdaylecture7lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("7_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture7.setText(thursdaylecture7teachersection);
                            tvyearthuLecture7.setText(thursdaylecture7lectureyear);
                            String thursdaylecture7subject = dataSnapshot.child("TimeTable").child("Thursday").child("7_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture7.setText(thursdaylecture7subject);


                        } else {
                            tvsecthuLecture7.setText("N/A");
                            tvyearthuLecture7.setText("N/A");
                            tvsubthuLecture7.setText("N/A");
                            thuLecture7.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Thursday").hasChild("8_per")) {
                            String thursdaylecture8teachersection = dataSnapshot.child("TimeTable").child("Thursday").child("8_per").child("class").child("section").getValue().toString();
                            String thursdaylecture8lectureyear = dataSnapshot.child("TimeTable").child("Thursday").child("8_per").child("class").child("year").getValue().toString();
                            tvsecthuLecture8.setText(thursdaylecture8teachersection);
                            tvyearthuLecture8.setText(thursdaylecture8lectureyear);
                            String thursdaylecture8subject = dataSnapshot.child("TimeTable").child("Thursday").child("8_per").child("class").child("subject").getValue().toString();
                            tvsubthuLecture8.setText(thursdaylecture8subject);

                        } else {
                            tvsecthuLecture8.setText("N/A");
                            tvyearthuLecture8.setText("N/A");
                            tvsubthuLecture8.setText("N/A");
                            thuLecture8.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }


                    }
                    if (dataSnapshot.child("TimeTable").hasChild("Friday")) {
                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("1_per")) {
                            String fridaylecture1teachersection = dataSnapshot.child("TimeTable").child("Friday").child("1_per").child("class").child("section").getValue().toString();
                            String fridaylecture1lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("1_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture1.setText(fridaylecture1teachersection);
                            tvyearfriLecture1.setText(fridaylecture1lectureyear);
                            String fridaylecture1subject = dataSnapshot.child("TimeTable").child("Friday").child("1_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture1.setText(fridaylecture1subject);

                        } else {
                            tvsecfriLecture1.setText("N/A");
                            tvyearfriLecture1.setText("N/A");
                            tvsubfriLecture1.setText("N/A");
                            friLecture1.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("2_per")) {
                            String fridaylecture2teachersection = dataSnapshot.child("TimeTable").child("Friday").child("2_per").child("class").child("section").getValue().toString();
                            String fridaylecture2lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("2_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture2.setText(fridaylecture2teachersection);
                            tvyearfriLecture2.setText(fridaylecture2lectureyear);
                            String fridaylecture2subject = dataSnapshot.child("TimeTable").child("Friday").child("2_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture2.setText(fridaylecture2subject);

                        } else {
                            tvsecfriLecture2.setText("N/A");
                            tvyearfriLecture2.setText("N/A");
                            tvsubfriLecture2.setText("N/A");
                            friLecture2.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));



                        }
                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("3_per")) {
                            String fridaylecture3teachersection = dataSnapshot.child("TimeTable").child("Friday").child("3_per").child("class").child("section").getValue().toString();
                            String fridaylecture3lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("3_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture3.setText(fridaylecture3teachersection);
                            tvyearfriLecture3.setText(fridaylecture3lectureyear);
                            String fridaylecture3subject = dataSnapshot.child("TimeTable").child("Friday").child("3_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture3.setText(fridaylecture3subject);

                        } else {
                            tvsecfriLecture3.setText("N/A");
                            tvyearfriLecture3.setText("N/A");
                            tvsubfriLecture3.setText("N/A");
                            friLecture3.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("4_per")) {
                            String fridaylecture4teachersection = dataSnapshot.child("TimeTable").child("Friday").child("4_per").child("class").child("section").getValue().toString();
                            String fridaylecture4lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("4_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture4.setText(fridaylecture4teachersection);
                            tvyearfriLecture4.setText(fridaylecture4lectureyear);
                            String fridaylecture4subject = dataSnapshot.child("TimeTable").child("Friday").child("4_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture4.setText(fridaylecture4subject);

                        } else {
                            tvsecfriLecture4.setText("N/A");
                            tvyearfriLecture4.setText("N/A");
                            tvsubfriLecture4.setText("N/A");
                            friLecture4.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("5_per")) {
                            String fridaylecture5teachersection = dataSnapshot.child("TimeTable").child("Friday").child("5_per").child("class").child("section").getValue().toString();
                            String fridaylecture5lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("5_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture5.setText(fridaylecture5teachersection);
                            tvyearfriLecture5.setText(fridaylecture5lectureyear);
                            String fridaylecture5subject = dataSnapshot.child("TimeTable").child("Friday").child("5_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture5.setText(fridaylecture5subject);

                        } else {
                            tvsecfriLecture5.setText("N/A");
                            tvyearfriLecture5.setText("N/A");
                            tvsubfriLecture5.setText("N/A");
                            friLecture5.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }

                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("6_per")) {
                            String fridaylecture6teachersection = dataSnapshot.child("TimeTable").child("Friday").child("6_per").child("class").child("section").getValue().toString();
                            String fridaylecture6lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("6_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture6.setText(fridaylecture6teachersection);
                            tvyearfriLecture6.setText(fridaylecture6lectureyear);
                            String fridaylecture6subject = dataSnapshot.child("TimeTable").child("Friday").child("6_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture6.setText(fridaylecture6subject);

                        } else {
                            tvsecfriLecture6.setText("N/A");
                            tvyearfriLecture6.setText("N/A");
                            tvsubfriLecture6.setText("N/A");
                            friLecture6.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("7_per")) {
                            String fridaylecture7teachersection = dataSnapshot.child("TimeTable").child("Friday").child("7_per").child("class").child("section").getValue().toString();
                            String fridaylecture7lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("7_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture7.setText(fridaylecture7teachersection);
                            tvyearfriLecture7.setText(fridaylecture7lectureyear);
                            String fridaylecture7subject = dataSnapshot.child("TimeTable").child("Friday").child("7_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture7.setText(fridaylecture7subject);


                        } else {
                            tvsecfriLecture7.setText("N/A");
                            tvyearfriLecture7.setText("N/A");
                            tvsubfriLecture7.setText("N/A");
                            friLecture7.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Friday").hasChild("8_per")) {
                            String fridaylecture8teachersection = dataSnapshot.child("TimeTable").child("Friday").child("8_per").child("class").child("section").getValue().toString();
                            String fridaylecture8lectureyear = dataSnapshot.child("TimeTable").child("Friday").child("8_per").child("class").child("year").getValue().toString();
                            tvsecfriLecture8.setText(fridaylecture8teachersection);
                            tvyearfriLecture8.setText(fridaylecture8lectureyear);
                            String fridaylecture8subject = dataSnapshot.child("TimeTable").child("Friday").child("8_per").child("class").child("subject").getValue().toString();
                            tvsubfriLecture8.setText(fridaylecture8subject);

                        } else {
                            tvsecfriLecture8.setText("N/A");
                            tvyearfriLecture8.setText("N/A");
                            tvsubfriLecture8.setText("N/A");

                            friLecture8.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }


                    }
                    if (dataSnapshot.child("TimeTable").hasChild("Saturday")) {
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("1_per")) {
                            String saturdaylecture1teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("1_per").child("class").child("section").getValue().toString();
                            String saturdaylecture1lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("1_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture1.setText(saturdaylecture1teachersection);
                            tvyearsatlecture1.setText(saturdaylecture1lectureyear);
                            String saturdaylecture1subject = dataSnapshot.child("TimeTable").child("Saturday").child("1_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture1.setText(saturdaylecture1subject);


                        } else {
                            tvsecsatlecture1.setText("N/A");
                            tvyearsatlecture1.setText("N/A");
                            tvsubsatlecture1.setText("N/A");
                            satlecture1.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("2_per")) {
                            String saturdaylecture2teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("2_per").child("class").child("section").getValue().toString();
                            String saturdaylecture2lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("2_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture2.setText(saturdaylecture2teachersection);
                            tvyearsatlecture2.setText(saturdaylecture2lectureyear);
                            String saturdaylecture2subject = dataSnapshot.child("TimeTable").child("Saturday").child("2_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture2.setText(saturdaylecture2subject);

                        } else {
                            tvsecsatlecture2.setText("N/A");
                            tvyearsatlecture2.setText("N/A");
                            tvsubsatlecture2.setText("N/A");
                            satlecture2.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("3_per")) {
                            String saturdaylecture3teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("3_per").child("class").child("section").getValue().toString();
                            String saturdaylecture3lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("3_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture3.setText(saturdaylecture3teachersection);
                            tvyearsatlecture3.setText(saturdaylecture3lectureyear);
                            String saturdaylecture3subject = dataSnapshot.child("TimeTable").child("Saturday").child("3_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture3.setText(saturdaylecture3subject);

                        } else {
                            tvsecsatlecture3.setText("N/A");
                            tvyearsatlecture3.setText("N/A");
                            tvsubsatlecture3.setText("N/A");
                            satlecture3.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("4_per")) {
                            String saturdaylecture4teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("4_per").child("class").child("section").getValue().toString();
                            String saturdaylecture4lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("4_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture4.setText(saturdaylecture4teachersection);
                            tvyearsatlecture4.setText(saturdaylecture4lectureyear);
                            String saturdaylecture4subject = dataSnapshot.child("TimeTable").child("Saturday").child("4_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture4.setText(saturdaylecture4subject);

                        } else {
                            tvsecsatlecture4.setText("N/A");
                            tvyearsatlecture4.setText("N/A");
                            tvsubsatlecture4.setText("N/A");
                            satlecture4.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("5_per")) {
                            String saturdaylecture5teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("5_per").child("class").child("section").getValue().toString();
                            String saturdaylecture5lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("5_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture5.setText(saturdaylecture5teachersection);
                            tvyearsatlecture5.setText(saturdaylecture5lectureyear);
                            String saturdaylecture5subject = dataSnapshot.child("TimeTable").child("Saturday").child("5_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture5.setText(saturdaylecture5subject);

                        } else {
                            tvsecsatlecture5.setText("N/A");
                            tvyearsatlecture5.setText("N/A");
                            tvsubsatlecture5.setText("N/A");
                            satlecture5.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("6_per")) {
                            String saturdaylecture6teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("6_per").child("class").child("section").getValue().toString();
                            String saturdaylecture6lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("6_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture6.setText(saturdaylecture6teachersection);
                            tvyearsatlecture6.setText(saturdaylecture6lectureyear);
                            String saturdaylecture6subject = dataSnapshot.child("TimeTable").child("Saturday").child("6_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture6.setText(saturdaylecture6subject);


                        } else {
                            tvsecsatlecture6.setText("N/A");
                            tvyearsatlecture6.setText("N/A");
                            tvsubsatlecture6.setText("N/A");
                            satlecture6.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));


                        }
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("7_per")) {
                            String saturdaylecture7teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("7_per").child("class").child("section").getValue().toString();
                            String saturdaylecture7lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("7_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture7.setText(saturdaylecture7teachersection);
                            tvyearsatlecture7.setText(saturdaylecture7lectureyear);
                            String saturdaylecture7subject = dataSnapshot.child("TimeTable").child("Saturday").child("7_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture7.setText(saturdaylecture7subject);


                        } else {
                            tvsecsatlecture7.setText("N/A");
                            tvyearsatlecture7.setText("N/A");
                            tvsubsatlecture7.setText("N/A");
                            satlecture7.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }
                        if (dataSnapshot.child("TimeTable").child("Saturday").hasChild("8_per")) {
                            String saturdaylecture8teachersection = dataSnapshot.child("TimeTable").child("Saturday").child("8_per").child("class").child("section").getValue().toString();
                            String saturdaylecture8lectureyear = dataSnapshot.child("TimeTable").child("Saturday").child("8_per").child("class").child("year").getValue().toString();
                            tvsecsatlecture8.setText(saturdaylecture8teachersection);
                            tvyearsatlecture8.setText(saturdaylecture8lectureyear);
                            String saturdaylecture8subject = dataSnapshot.child("TimeTable").child("Saturday").child("8_per").child("class").child("subject").getValue().toString();
                            tvsubsatlecture8.setText(saturdaylecture8subject);

                        } else {
                            tvsecsatlecture8.setText("N/A");
                            tvyearsatlecture8.setText("N/A");
                            tvsubsatlecture8.setText("N/A");
                            satlecture8.setCardBackgroundColor(getResources().getColor(R.color.colordeactivate));

                        }


                    }


                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }
    }
}
