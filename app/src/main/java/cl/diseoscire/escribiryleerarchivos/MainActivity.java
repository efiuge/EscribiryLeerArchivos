package cl.diseoscire.escribiryleerarchivos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearUnArchivo();
        leerUnArchivo();

    }

    private void leerUnArchivo() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("texto.txt")));

            String str;
            while ((str = br.readLine())!= null){
                String[] datos = str.split(";");
                System.out.println("--------------------");
                System.out.println("Leer "+str);
                for (String tmp : datos){
                    System.out.println("Dato "+tmp);
                }

            }
            System.out.println("BRLine "+br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            Log.d("Error",e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("Error",e.getMessage());
            e.printStackTrace();
        }
    }

    private void crearUnArchivo() {

        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        list.add("1;18480428-k;Eric;Figueroa;Soto");
        list.add("1;18480428-k;Eric;Figueroa;Soto");
        list.add("1;18480428-k;Eric;Figueroa;Soto");
        list.add("1;18480428-k;Eric;Figueroa;Soto");
        list.add("1;18480428-k;Eric;Figueroa;Soto");
        list.add("1;18480428-k;Eric;Figueroa;Soto");
        list.add("1;18480428-k;Eric;Figueroa;Soto");
        try {
            FileOutputStream file = openFileOutput("texto.txt",MODE_PRIVATE);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(file));
            try {

                for(String tmp : list){
                    System.out.println("Linea "+tmp);
                    bw.write(tmp);
                    bw.newLine();

                }

                bw.close();

            } catch (IOException e) {
            Log.d("Error",e.getMessage());
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            Log.d("Error",e.getMessage());
            e.printStackTrace();
        }
    }
}
