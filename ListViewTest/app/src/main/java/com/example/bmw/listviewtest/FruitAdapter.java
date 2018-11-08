package com.example.bmw.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    //重写getView类 在之前的ListView默认情况下会调用
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);  //获取当前项的Fruit实例
        //避免视图的重复加载   对视图进行缓存
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            //如果之前没有缓存
            view  = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将viewHolder储存于view中
        }
        else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        /*View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);*/
        //此处重复获取
        /*ImageView fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView)view.findViewById(R.id.fruit_name);*/
        /*fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());*/

        return view;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}

