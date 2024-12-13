package com.example.intentsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ListView lvMenu = findViewById(R.id.lvMenu);
        List<Map<String,String>> menulist = new ArrayList<>();
        Map<String, String> menu = new HashMap<>();
        menu.put("name","唐揚げ定食");
        menu.put("price","800円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","ハンバーグ定食");
        menu.put("price","850円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","生姜焼き定食");
        menu.put("price","850円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","ステーキ定食");
        menu.put("price","1000円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食");
        menu.put("price","750円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","とんかつ定食");
        menu.put("price","900円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","ミンチかつ定食");
        menu.put("price","850円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","チキンカツ定食");
        menu.put("price","900円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","コロッケ定食");
        menu.put("price","850円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","回鍋肉定食");
        menu.put("price","750円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","麻婆豆腐定食");
        menu.put("price","800円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","青椒肉絲定食");
        menu.put("price","900円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","八宝菜定食");
        menu.put("price","800円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","酢豚定食");
        menu.put("price","700円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","豚の角煮定食");
        menu.put("price","600円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","焼き鳥定食");
        menu.put("price","700円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","焼き魚定食");
        menu.put("price","800円");
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name","焼肉定食");
        menu.put("price","900円");
        menulist.add(menu);

        String[] from = {"name","price"};
        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,menulist,
                android.R.layout.simple_list_item_2,from,to);

        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ListItemClickListener());
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);

            String menuName = item.get("name");
            String menuPrice = item.get("price");

            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);

            intent.putExtra("menuName",menuName);
            intent.putExtra("menuPrice",menuPrice);

            startActivity(intent);
        }
    }
}