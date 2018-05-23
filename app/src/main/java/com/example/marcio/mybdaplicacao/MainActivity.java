package com.example.marcio.mybdaplicacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView addUsua;
    ImageView usua;
    ImageView altUsua;

    TextView txt_addUsua;
    TextView txt_usua;
    TextView txt_altUsua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addUsua = (ImageView) findViewById(R.id.img_3);
        usua = (ImageView) findViewById(R.id.img_1);
        altUsua = (ImageView) findViewById(R.id.img_2);
    }

    public void btnClickAddUsers(View v) {
        Intent i = new Intent(this, ActivityAddUsuario.class);
        startActivity(i);
    }

    public void btnClickUser(View v) {
        Intent i = new Intent(this, ActivityUsuario.class);
        startActivity(i);
    }

    public void btnClickAltUser(View v) {
        Intent i = new Intent(this, ActivityAlterarUsuario.class);
        startActivity(i);
    }
    public void btnClickDeleteUser(View v){
        Intent i = new Intent(this, ActivityDeletarUsuario.class );
        startActivity(i);
    }

}
