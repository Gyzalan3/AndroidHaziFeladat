package com.example.mainfeladat1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText elsoSzam;
    private EditText masodikSzam;
    private TextView eredmeny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elsoSzam = findViewById(R.id.elsoSzam);
        masodikSzam = findViewById(R.id.masodikSzam);
        eredmeny = findViewById(R.id.txtEredmeny);

        Button osszadasBTN = findViewById(R.id.btnOsszeadas);
        Button kivonasBTN = findViewById(R.id.btnKivonas);
        Button szorzasBTN = findViewById(R.id.btnSzorzas);
        Button osztasBTN = findViewById(R.id.btnOsztas);

        osszadasBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muveletElvegzese("+");
            }
        });

        kivonasBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muveletElvegzese("-");
            }
        });

        szorzasBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muveletElvegzese("*");
            }
        });

        osztasBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muveletElvegzese("/");
            }
        });
    }
    private void muveletElvegzese(String muvelet) {
        try {
            double szam1 = Double.parseDouble(elsoSzam.getText().toString());
            double szam2 = Double.parseDouble(masodikSzam.getText().toString());
            double eredmenye;

            switch (muvelet) {
                case "+":
                    eredmenye = szam1 + szam2;
                    break;
                case "-":
                    eredmenye = szam1 - szam2;
                    break;
                case "*":
                    eredmenye = szam1 * szam2;
                    break;
                case "/":
                    if (szam2 == 0) {
                        throw new ArithmeticException("Nullával való osztás nem lehet.");
                    }
                    eredmenye = szam1 / szam2;
                    break;
                default:
                    throw new UnsupportedOperationException("Valami hiba történt.");
            }

            eredmeny.setText(String.valueOf(eredmenye));
        } catch (NumberFormatException e) {
            eredmeny.setText("Kérlek, számokat adj meg.");
        } catch (ArithmeticException e) {
            eredmeny.setText(e.getMessage());
        } catch (Exception e) {
            eredmeny.setText("Hiba történt: " + e.getMessage());
        }
    }

}