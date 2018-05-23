package com.example.marcio.mybdaplicacao;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityUsuario extends AppCompatActivity {
    DataBaseHelper myDb;
    TextView txtResult;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        myDb = new DataBaseHelper(this);

        txtResult = (TextView) findViewById(R.id.textView);
        btnClick = (Button) findViewById(R.id.button2);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });


    }
    private  void ClickMe(){
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();

        if(res!=null && res.getCount()>0){
            while (res.moveToNext()){
                stringBuffer.append("Id: " + res.getString(0) + "\n");
                stringBuffer.append("Nome: " + res.getString(1) + "\n");
                stringBuffer.append("Sobrenome: " + res.getString(2) + "\n");
                stringBuffer.append("Idade: " + res.getString(3) + "\n");
                stringBuffer.append("Profissão: " + res.getString(4) + "\n" + "\n");
            }

            txtResult.setText(stringBuffer.toString());
            Toast.makeText(this, "Dados recuperados com sucesso!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Dados não recuperados!", Toast.LENGTH_SHORT).show();
        }
    }
}