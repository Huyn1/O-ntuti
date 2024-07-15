package fpoly.huynvph52251.trochi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ivPlayer, ivMay;
    private TextView tvResult;
    private Button btndan, btnlaa, btnkeoo;

    private int[] images = {R.drawable.dam, R.drawable.la, R.drawable.keo};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlayer = findViewById(R.id.ivPlayer);
        ivMay = findViewById(R.id.ivMay);
        tvResult = findViewById(R.id.tvResult);
        btndan = findViewById(R.id.btndan);
        btnlaa = findViewById(R.id.btnlaa);
        btnkeoo = findViewById(R.id.btnkeoo);

        btndan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(0);
            }
        });

        btnlaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(1);
            }
        });

        btnkeoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(2);
            }
        });
    }

    private void Play(int player) {
        Random random = new Random();
        int May = random.nextInt(3);

        ivPlayer.setImageResource(images[player]);
        ivMay.setImageResource(images[May]);

        String result;
        if (player == May) {
            result = "Hòa!";
        } else if ((player == 0 && May == 2) ||
                (player == 1 && May == 0) ||
                (player == 2 && May == 1)) {
            result = "Bạn thắng!";
        } else {
            result = "Bạn thua!";
        }

        tvResult.setText(result);
    }
}