package appsforyou.tarun.com.ipecapp;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button student,teacher,guest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student=(Button)findViewById(R.id.buttonstudent);
        teacher=(Button)findViewById(R.id.buttonteacher);
        guest=(Button)findViewById(R.id.buttonguest);
        student.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent student=new Intent(MainActivity.this,HomeActivity_Student.class);
               startActivity(student);
           }
       });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacher=new Intent(MainActivity.this,Teacher_Login_Activity.class);
                startActivity(teacher);
            }
        });
    }

}
