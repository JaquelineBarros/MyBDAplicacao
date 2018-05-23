package com.example.marcio.mybdaplicacao;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAlterarUsuario extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText text_id, text_nome, text_sobrenome, text_idade, text_profissao;
    Button btnAtualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_usuario);

        myDb = new DataBaseHelper(this);
        text_id = (EditText) findViewById(R.id.edit_id);
        text_nome = (EditText) findViewById(R.id.edit_nome1);
        text_sobrenome = (EditText) findViewById(R.id.edit_sobrenome1);
        text_idade = (EditText) findViewById(R.id.edit_idade1);
        text_profissao = (EditText) findViewById(R.id.edit_profissao1);

        btnAtualizar = (Button) findViewById(R.id.btn_atualizar);

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
    }

    private void ClickMe() {
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        String id = text_id.getText().toString();
        String nome = text_nome.getText().toString();
        String sobrenome = text_sobrenome.getText().toString();
        String idade = text_idade.getText().toString();
        String profissao = text_profissao.getText().toString();;

        Boolean result = myDb.updateData( id, nome,  sobrenome, idade, profissao);

        if (result ==false) {
            Toast.makeText(this, "Dados alterados com sucesso.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro ao alterar dados.", Toast.LENGTH_SHORT).show();
        }
    }
}
