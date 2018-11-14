package com.example.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private SliderLayout mslidershow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        mslidershow = (SliderLayout)view.findViewById(R.id.slider);
        initSlider();


        ListView listView=(ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new MemberAdapter(HomeFragment.this.getActivity()));


        return  view;


    }
    private void initSlider(){
        TextSliderView textSliderView=new TextSliderView(this.getActivity());               //轮播的图片和标题显示
        textSliderView.description("从化有名景点");
        textSliderView.image(R.drawable.p1);

        TextSliderView textSliderView1=new TextSliderView(this.getActivity());
        textSliderView1.description("不一样的餐馆");
        textSliderView1.image(R.drawable.q1);

        TextSliderView textSliderView2=new TextSliderView(this.getActivity());
        textSliderView2.description("农家乐");
        textSliderView2.image(R.drawable.f1);


        mslidershow.addSlider(textSliderView);
        mslidershow.addSlider(textSliderView1);
        mslidershow.addSlider(textSliderView2);
    }

    private class MemberAdapter extends BaseAdapter{
        private Context context;
        private List<Member>memberList;
        private LayoutInflater inflater;
        public MemberAdapter(Context context) {
            this.context=context;
            inflater=LayoutInflater.from(context);
            memberList=new ArrayList<>();
            memberList.add(new Member(1,R.drawable.p6,"石门公园","广州北最大的森林生态公园","国家4A级景区"));
            memberList.add(new Member(2,R.drawable.p3,"石门公园","广州北最大的森林生态公园","国家4A级景区"));
            memberList.add(new Member(3,R.drawable.p8,"石门公园","广州北最大的森林生态公园","国家4A级景区"));

        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=inflater.inflate(R.layout.recyclerview_cardview_home,parent,false);
            Member member=memberList.get(position);

            ImageView images=(ImageView) convertView.findViewById(R.id.tvimage);
            images.setImageResource(member.getImageid());

            TextView id=(TextView) convertView.findViewById(R.id.tvid);
            id.setText(String.valueOf(member.getId()));

            TextView name=(TextView) convertView.findViewById(R.id.name);
            name.setText(member.getName());

            TextView tite1=(TextView) convertView.findViewById(R.id.title1);
            tite1.setText(member.getTitle1());

            TextView tite2=(TextView) convertView.findViewById(R.id.title2);
            tite2.setText(member.getTitle2());
            return convertView;
        }
    }


}
