package com.example.nisargdoshi.myclassroom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class crt_new_classroom extends AppCompatActivity {
        Button btn_new_class;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crt_new_classroom);
        btn_new_class=(Button)findViewById(R.id.crt_new_class_btn);



        btn_new_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.crt_new_class_popup, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText classname = (EditText) promptsView.findViewById(R.id.editText3);
                final EditText classsection = (EditText) promptsView.findViewById(R.id.editText4);
                final EditText classsubject = (EditText) promptsView.findViewById(R.id.editText5);
                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setTitle("Create class")
                        .setPositiveButton("Create",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                       if(classname.getText().toString().equals(""))
                                       {
                                            Toast.makeText(getBaseContext(),"please enter class name",Toast.LENGTH_LONG).show();
                                       }
                                        else if(classsection.getText().toString().equals(""))
                                       {
                                           Toast.makeText(getBaseContext(),"please enter section of class",Toast.LENGTH_LONG).show();
  //
                                       }
                                        else if(classsubject.getText().toString().equals(""))
                                       {
                                           Toast.makeText(getBaseContext(),"please enter subject for class",Toast.LENGTH_LONG).show();
                                       }
                                        else if(classname.getText().toString().length()>0 && classsection.getText().toString().length()>0&&classsubject.toString().toString().length()>0)
                                       {
                                           Toast.makeText(getBaseContext(),classname.getText().toString()+classsection.getText().toString()+classsubject.getText().toString(),Toast.LENGTH_LONG).show();
                                            Intent i=new Intent(getBaseContext(),virtual_classroom.class);
                                           i.putExtra("classname",classname.getText().toString());
                                           i.putExtra("classsection",classsection.getText().toString());
                                           i.putExtra("classsubject",classsubject.getText().toString());
                                           startActivity(i);
                                       }
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });
    }
}
