package com.example.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewcontext= inflater.inflate(R.layout.fragment_mine, container, false);
        ListView listView=(ListView) viewcontext.findViewById(R.id.mine_listview);
        listView.setAdapter(new MemberAdapter(MineFragment.this.getActivity()));
        return viewcontext;
    }


    private class MemberAdapter extends BaseAdapter{
        private Context context;
        private List<mine_Member> memberList;
        private LayoutInflater inflater;
        public MemberAdapter(Context context) {
            this.context=context;
            inflater=LayoutInflater.from(context);
            memberList=new ArrayList<>();
            memberList.add(new mine_Member("个人信息"));
            memberList.add(new mine_Member("相册"));
            memberList.add(new mine_Member("关注"));
            memberList.add(new mine_Member("足迹"));
            memberList.add(new mine_Member("设置"));
            memberList.add(new mine_Member("用户反馈"));
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
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=inflater.inflate(R.layout.mine_list_text,parent,false);
            mine_Member member=memberList.get(position);

            TextView textView=(TextView) view.findViewById(R.id.mime_text);
            textView.setText(member.getTitle());
            return view;
        }
    }
}
