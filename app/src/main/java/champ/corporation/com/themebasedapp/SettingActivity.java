package champ.corporation.com.themebasedapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import champ.corporation.com.themebasedapp.common.MainActivity;
import champ.corporation.com.themebasedapp.utils.Constant;
import champ.corporation.com.themebasedapp.utils.CustomColor;

public class SettingActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btnMumbai, btnNashik, btnGoa;
    CustomColor customColor;
    int theme;
    int theme_color;
    int app_base_color;
    Constant constant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        app_base_color = sharedPreferences.getInt("color", 0);
        theme = sharedPreferences.getInt("theme", 0);
        theme_color = app_base_color;
        constant.color = app_base_color;

        if (theme_color == 0){
            setTheme(Constant.theme);
        }else if (theme == 0){
            setTheme(Constant.theme);
        }else{
            setTheme(theme);
        }
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Setting");
        toolbar.setBackgroundColor(Constant.color);

        setupUI(savedInstanceState);

        setupClickListner();
        customColor = new CustomColor();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    private void setupUI(Bundle savedInstanceState) {
        btnMumbai = findViewById(R.id.btn_mumbai);
        btnNashik = findViewById(R.id.btn_nashik);
        btnGoa = findViewById(R.id.btn_goa);
    }

    private void setupClickListner() {
        btnMumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = 0xffF44336;
                constant.color = color;
                customColor.setColorTheme(1);
                editor.putInt("color", color);
                editor.putInt("theme",Constant.theme);
                editor.commit();

                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnNashik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = 0xffE91E63;
                constant.color = color;
                customColor.setColorTheme(2);
                editor.putInt("color", color);
                editor.putInt("theme",Constant.theme);
                editor.commit();

                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnGoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = 0xff9C27B0;
                constant.color = color;

                customColor.setColorTheme(3);
                editor.putInt("color", color);
                editor.putInt("theme",Constant.theme);
                editor.commit();

                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}
