package mx.edu.ittepic.tpdm_practica4_juanmejia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView caja1,caja2,caja3,ecaja1,ecaja2,ecaja3;
    Button iniciar;
    Boolean variable = true;
    Thread thread;
    Runnable runnable;
    int c1 = 0;
    int c2 = 0;
    int c3 = 0;
    String mc1,mc2,mc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caja1 = findViewById(R.id.caja1);
        caja2 = findViewById(R.id.caja2);
        caja3 = findViewById(R.id.caja3);
        ecaja1 = findViewById(R.id.ecaja1);
        ecaja2 = findViewById(R.id.ecaja2);
        ecaja3 = findViewById(R.id.ecaja3);
        iniciar = findViewById(R.id.iniciar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread = new Thread(){
                    public void run(){
                        while(variable) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            int r1 = (int) (Math.random()*7)+1;

                            if(r1 >= 0 && c1 < 20){
                                c1+=r1;
                                mc1 = "";
                            }else{
                                if(c1 >= 20 ){
                                    mc1 = "trabajo interno";
                                    c1 = c1;
                                    c1 = 0;
                                }
                            }

                            int r2 = (int) (Math.random()*7)+1;

                            if(r2 >= 0 && c2 < 20){
                                c2+=r2;
                                mc2 = "";
                            }else{
                                if(c2 >= 20 ){
                                    mc2 = "trabajo interno";
                                    c2 = c2;
                                    c2 = 0;
                                }
                            }

                            int r3 = (int) (Math.random()*7)+1;

                            if(r3 >= 0 && c3 < 20){
                                c3+=r3;
                                mc3 = "";
                            }else{
                                if(c3 >= 20 ){
                                    mc3 = "trabajo interno";
                                    c3 = c3;
                                    c3 = 0;
                                }
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    caja1.setText(c1+"");
                                    caja2.setText(c2+"");
                                    caja3.setText(c3+"");
                                    ecaja1.setText(mc1);
                                    ecaja2.setText(mc2);
                                    ecaja3.setText(mc3);
                                }
                            });

                            try {
                                sleep(300);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }

                        }//while
                    }//run
                };//thread
                thread.start();
            }//onClick
        });//setOnClick
    }//onCreate
}//class
