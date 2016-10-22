package br.com.fabricadeprogramador.tuc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    List<Produto> produtolist = new ArrayList<>();

    @Bind(R.id.cod_Barras)
    EditText codbarras;

    @Bind(R.id.desc_produto)
    EditText descproduto;

    @Bind(R.id.preco_Produto)
    EditText precoproduto;

    @OnClick(R.id.btn_conf)
    public void buscar(){
        String cod = codbarras.getText().toString();

        for (int i=0; i<produtolist.size(); i++){
            if (produtolist.get(i).getCodigoBarra().equals(cod)){
                Produto p = produtolist.get(i);
                descproduto.setText(p.getDescricao().toString());
                precoproduto.setText(p.getValor().toString());
                break;
            }
        }
    }


    public void carregarprodutos(){
        produtolist.add(new Produto(1,"1001", "Banana", 1.0));
        produtolist.add(new Produto(1,"1101", "Arroz", 8.0));
        produtolist.add(new Produto(1,"1011", "Feijão", 6.0));
        produtolist.add(new Produto(1,"0001", "Farinha", 3.0));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        carregarprodutos();
    }




}
