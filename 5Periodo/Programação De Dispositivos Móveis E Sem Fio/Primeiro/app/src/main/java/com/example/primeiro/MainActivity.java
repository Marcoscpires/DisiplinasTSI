package com.example.primeiro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText entrada;
    TextView resultado;
    ListView lista;
    ArrayAdapter adapter;

    int soma = 0;
    ArrayList<Integer> numeros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = (EditText) findViewById(R.id.editor);
        resultado = (TextView) findViewById(R.id.resultado);
        lista = (ListView) findViewById(R.id.lista);

        if (savedInstanceState != null){
            soma = savedInstanceState.getInt("soma_atual",0);
            resultado.setText("Resultado: "+soma);
            numeros = savedInstanceState.getIntegerArrayList("lista_nums");
        }
        if(numeros == null) {
            numeros = new ArrayList<>();
        }
        adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_list_item_multiple_choice,
                numeros);
        lista.setAdapter( adapter );
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    public void somar(View btn){
        String txt = entrada.getText().toString();
        try{
            int vlr = Integer.parseInt( txt );
            soma += vlr;
            numeros.add(vlr);
            resultado.setText("Resultado "+soma);
            entrada.setText("");
            adapter.notifyDataSetChanged();
        } catch(NumberFormatException nfe){
            Toast.makeText(this, "Informe um número a somar", Toast.LENGTH_SHORT).show();
        }
    }

    public void remover(View btn){
        /* Remover quando o modo de seleção for SINGLE_CHOICE
        int pos = lista.getCheckedItemPosition();
        if (pos < 0){
            Toast.makeText(this, "Selecione o número a remover", Toast.LENGTH_SHORT).show();
        } else {
            Integer val = numeros.remove(pos);
            soma -= val;
            resultado.setText("Resultado: "+soma);
            adapter.notifyDataSetChanged();
            lista.clearChoices();
        }
        */
        //Quando o modo for MULTIPLE:
        int cont = lista.getCheckedItemCount();
        if(cont > 0){
            SparseBooleanArray sels = lista.getCheckedItemPositions();
            ArrayList<Integer> aRemover = new ArrayList<>( cont );
            for (int i = 0; i < numeros.size(); i++){
                if (sels.get(i)) {
                    aRemover.add(numeros.get(i));
                    soma -= numeros.get(i);
                }
            }
            numeros.removeAll( aRemover );
            resultado.setText("Resultado: "+soma);
            adapter.notifyDataSetChanged();
            lista.clearChoices();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle dados) {
        super.onSaveInstanceState(dados);
        dados.putInt("soma_atual",soma);
        dados.putIntegerArrayList("lista_nums",numeros);
    }
}