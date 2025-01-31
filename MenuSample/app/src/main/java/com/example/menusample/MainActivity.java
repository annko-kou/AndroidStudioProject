package com.example.menusample;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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

    private ListView _lvMenu;
    private List<Map<String, Object>> _menuList;
    private static final String[] FROM = {"name", "price"};
    private static final int[] TO = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _lvMenu = findViewById(R.id.lvMenu);
        _menuList = createTeishokuList();
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList,
                R.layout.row, FROM, TO);
        _lvMenu.setAdapter(adapter);
        _lvMenu.setOnItemClickListener(new ListItemClickListener());
        registerForContextMenu(_lvMenu);
    }

    private List<Map<String, Object>> createTeishokuList() {
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "唐揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鶏のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "うまい生姜焼き");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 850);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", 750);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", 800);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "青椒肉絲定食");
        menu.put("price", 900);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "八宝菜定食");
        menu.put("price", 800);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "酢豚定食");
        menu.put("price", 700);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "豚の角煮定食");
        menu.put("price", 600);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き鳥定食");
        menu.put("price", 700);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 800);
        menu.put("desc", "うまい");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 900);
        menu.put("desc", "うまい");
        menuList.add(menu);
        return menuList;
    }

    private List<Map<String, Object>> createCurryList() {
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ビーフカレー");
        menu.put("price", 520);
        menu.put("desc", "特選スパイスをきかせた国産ビーフ100%のカレーです。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ポークカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスをきかせた国産ポーク100%のカレーです。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグカレー");
        menu.put("price", 420);
        menu.put("desc", "うまいハンバーグ");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チーズカレー");
        menu.put("price", 420);
        menu.put("desc", "チーズ入りのカレーです。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "カツカレー");
        menu.put("price", 420);
        menu.put("desc", "カツ入りのカレーです。");
        menuList.add(menu);
        return menuList;


    }


    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent,View view,int position,long id){
            Map<String,Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
            order(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean returnVal = true;
        int itemId = item.getItemId();

        if (itemId == R.id.menuListOptionTeishoku) {
            _menuList = createTeishokuList();
        } else if (itemId == R.id.menuListOptionCurry) {
            _menuList = createCurryList();
        } else {
            returnVal = super.onOptionsItemSelected(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList,
                R.layout.row, FROM, TO);
        _lvMenu.setAdapter(adapter);
        return returnVal;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,View view,ContextMenu.ContextMenuInfo
            menuInfo){
        super.onCreateContextMenu(menu,view,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_menu_list,menu);
        menu.setHeaderTitle(R.string.menu_list_context_header);
    }
    private void order(Map<String,Object> menu) {
        String menuName = (String) menu.get("name");
        Integer menuPrice = (Integer) menu.get("price");

        Intent intent = new Intent(MainActivity.this,MenuThanksActivity.class);

        intent.putExtra("menuName",menuName);
        intent.putExtra("menuPrice",menuPrice + "円");
        startActivity(intent);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean returnVal = true;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        int listPosition = info.position;
        Map<String,Object> menu = _menuList.get(listPosition);

        int itemId = item.getItemId();
        if (itemId == R.id.menuListContextDesc) {
            String desc = (String) menu.get("desc");
            Toast.makeText(MainActivity.this,desc,Toast.LENGTH_LONG).show();
        }
        else if(itemId == R.id.menuListContextOrder) {
            order(menu);
        }
        else {
            returnVal = super.onContextItemSelected(item);
        }
        return returnVal;
    }

}
