package jogo.com.advinheonumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnKeyListener{
    private int numeroSorteado;
    private TextView menssagem;
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
        entrada.setOnKeyListener(this);
    }


    @Override
    public boolean onKey(View v, int KeyCode, KeyEvent event) {
        if(KeyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
            verifica();
            entrada.getText().clear();
            return true;
        }
        return false;
    }

    private void verifica() {
        int numero = Integer.parseInt(entrada.getText().toString());
        if(numero == numeroSorteado) {
            menssagem.setText(R.string.texto1);
        }
        if(numero > numeroSorteado) {
            menssagem.setText(R.string.texto2);
        }
        if(numero < numeroSorteado)  {
            menssagem.setText(R.string.texto3);
        }
    }

}