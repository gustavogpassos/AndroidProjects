package moveis.dispositivos.graduacao.upf.com.primeiroandroid;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView txtPost;
    public Button btnLimpar;
    public Button btnSair;
    private Spinner spinner;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLimpar) {
            txtPost.setText("...");
        } else {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPost = (TextView)findViewById(R.id.txtPost);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);
        btnSair = (Button)findViewById(R.id.btnSair);

        spinner = (Spinner) findViewById(R.id.spinner);

        btnLimpar.setOnClickListener(this);
        btnSair.setOnClickListener(this);

        //classe INTERNA ANÔNIMA
        /*btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPost.setText("...");
            }
        });*/

        //btnLimpar.setOnClickListener(clickListener);
    }

    public void chamaTelaComentario(View view){
        //txtPost.setText(txtPost.getText() + " clicou... " + spinner.getSelectedItem());
        Intent intent = new Intent(this, ComentarioActivity.class);

        //setar dados na intent para a outra tela
        intent.putExtra("gostou", spinner.getSelectedItemPosition()==0?true:false);
        intent.putExtra("timestamp", System.currentTimeMillis());

        startActivity(intent);
    }

    //VARIAVEL DA INTERFACE
    /*View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            txtPost.setText("...");
        }
    };*/
}
