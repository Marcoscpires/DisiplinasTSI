package com.example.garagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Veiculo> veiculos;
    EditText edMarca, edModelo, edAno, edPlaca, edValor;
    RadioGroup botoes;
    ListView lista;
    ArrayAdapter<Veiculo> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMarca = (EditText) findViewById(R.id.ed_marca);
        edModelo = (EditText) findViewById(R.id.ed_modelo);
        edAno = (EditText) findViewById(R.id.ed_ano);
        edPlaca = (EditText) findViewById(R.id.ed_placa);
        edValor = (EditText) findViewById(R.id.ed_valor);
        botoes = (RadioGroup) findViewById(R.id.rg_tipo);
        lista = (ListView) findViewById(R.id.lista_veiculos);
        veiculos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, veiculos);
                lista.setAdapter(adapter);
    }

    public void adicionar(View view){
        Veiculo v = new Veiculo();
        switch (botoes.getCheckedRadioButtonId()){
            case R.id.rb_automovel: v.setTipo('A'); break;
            case R.id.rb_motocicleta: v.setTipo('M'); break;
            case R.id.rb_caminhao: v.setTipo('C'); break;
        }
        v.setMarca(edMarca.getText().toString());
        v.setModelo(edModelo.getText().toString());
        v.setAno(Integer.parseInt(edAno.getText().toString()));
        v.setPlaca(edPlaca.getText().toString());
        v.setValor(Double.parseDouble(edValor.getText().toString()));
        veiculos.add(v);
        adapter.notifyDataSetChanged();
        edMarca.setText("");
        edModelo.setText("");
        edAno.setText("");
        edPlaca.setText("");
        edValor.setText("");



    }
}