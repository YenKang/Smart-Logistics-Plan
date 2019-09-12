package com.example.bjt.av_delivery_v10;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private List<Item> items;

    private int resource;
    // 初始化
    public ItemAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.resource = resource;
        this.items = items;
    }

    // 設定指定編號的訂單資料
    public void set(int index, Item item) {
        if ( index >= 0 && index < items.size() ) {
            items.set(index, item);
            notifyDataSetChanged();
        }
    }

    // 讀取指定編號的訂單資料
    public Item get(int index) {
        return items.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout itemView;
        // 讀取目前位置的記事物件
        final Item item = getItem(position);

        if (convertView == null) {
            // 建立項目畫面元件
            itemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater)
                    getContext().getSystemService(inflater);
            li.inflate(resource, itemView, true);
        }
        else {
            itemView = (LinearLayout) convertView;
        }

        // 讀取記事顏色、已選擇、標題與日期時間元件
        // RelativeLayout typeColor = (RelativeLayout) itemView.findViewById(R.id.type_color);

        // 將項目的資料進行宣告並從資料給值
        TextView orderNoView = (TextView) itemView.findViewById(R.id.order_No_text);
        TextView orderTimeView = (TextView) itemView.findViewById(R.id.order_time_text);
        TextView cargoContentView = (TextView) itemView.findViewById(R.id.cargo_content_text);

        Timestamp orderTime = item.getOrderTime();
        String orderTimeString = orderTime.toString();

        orderNoView.setText("訂單編號："+item.getOrderNo());
        orderTimeView.setText("下訂時間："+orderTimeString);
        cargoContentView.setText("貨品內容："+item.getCargoContent());

        // 設定是否已選擇
        // selectedItem.setVisibility(item.isSelected() ? View.VISIBLE : View.INVISIBLE);

        return itemView;
    }

}
