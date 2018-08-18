package jogo.com.advinheonumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
//        implements View.OnKeyListener{
    private int numeroSorteado;
    private TextView menssagem;
    private TextView contador;
    private EditText entrada;
    private int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preparacaoInicial();
    }

    private void preparacaoInicial() {
        numeroSorteado = (int) (Math.random() *101);
        menssagem = findViewById(R.id.mensagem);
        entrada = findViewById(R.id.entrada);
        contador = findViewById(R.id.contador);
        final Button botao = findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifica();
            }
        });
//        entrada.setOnKeyListener(this);
    }


//    @Override
//    public boolean onKey(View v, int KeyCode, KeyEvent event) {
//        if(KeyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
//            verifica();
//            entrada.getText().clear();
//            return true;
//        }
//        return false;
//    }

    private void verifica() {
        int numero = Integer.parseInt(entrada.getText().toString());
        if(numero == numeroSorteado) {
            menssagem.setText(R.string.texto1);
            cont++;
            contador.setText(String.valueOf(cont));
            entrada.getText().clear();
        }
        else if(numero > numeroSorteado) {
            menssagem.setText(R.string.texto2);
            cont++;
            contador.setText(String.valueOf(cont));
            entrada.getText().clear();
        }
        else  {
            menssagem.setText(R.string.texto3);
            cont++;
            contador.setText(String.valueOf(cont));
            entrada.getText().clear();
        }
    }

}