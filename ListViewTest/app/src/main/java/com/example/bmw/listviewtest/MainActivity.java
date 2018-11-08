package com.example.bmw.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {
            "王舒扬","范大屏","彭小田","毛侃","福陵轩","猪儿有","asdas","asdas","asdas","asdas","asdas","asdas"
            ,"asdas","asdas","asdas","asdas","asdas","asdas","asdas","asdas","asdas","asdas","asdas","asdas"
            ,"asdas","asdas","asdas"
    };
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();//初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);   //获取当前实例
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        //通过适配器将数据传入ListView
/*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
*/

/*        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/
    }
    //初始化list数组
    private void initFruits(){
        for(int i=0;i<20;i++){
            Fruit Wangnima1 = new Fruit("王舒杨笑嘻嘻",R.drawable.wangshuyang);
            fruitList.add(Wangnima1);
        }
    }
}
