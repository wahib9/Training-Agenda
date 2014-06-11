package com.example.abs;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_adapter extends ArrayAdapter<data>{

	ArrayList<data> arr;
	Context context;
	int layoutId;
	
	public custom_adapter(Context context, int resource, ArrayList<data>obj) {
		super(context, resource, obj);
		arr= new ArrayList<data>();
		this.arr=obj;
		this.context=context;
		this.layoutId=resource;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View ro = null;   
		if(convertView == null){
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
      		 ro = inflater.inflate(R.layout.row, parent, false);
		}
		else
		{
			ro=(View)convertView;
		}
		TextView tx1 = (TextView)ro.findViewById(R.id.textView1);
		TextView tx2 = (TextView)ro.findViewById(R.id.textView2);
		tx1.setText(arr.get(position).getName());
		tx2.setText(arr.get(position).getPh());
		return ro;
	}

}
