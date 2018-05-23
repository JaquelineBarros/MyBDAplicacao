package com.example.marcio.mybdaplicacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityDeletarUsuario extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText txt_id;
    Button btnApagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_usuario);



        myDb = new DataBaseHelper(this);
        txt_id = (EditText)findViewById(R.id.edit_id);
        btnApagar= (Button)findViewById(R.id.btn_apagar);

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMe();
            }
        });
    }
    private void ClickMe(){
        String id = txt_id.getText().toString();
        int result = myDb.deletarData(id);
        Toast.makeText(this, "dados deletado com sucesso.",Toast.LENGTH_SHORT).show();

    }
}

