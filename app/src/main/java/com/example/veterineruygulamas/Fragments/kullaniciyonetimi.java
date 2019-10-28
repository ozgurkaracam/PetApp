package com.example.veterineruygulamas.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.veterineruygulamas.Adapters.UserListAdapter;
import com.example.veterineruygulamas.Pojos.User;
import com.example.veterineruygulamas.R;

import java.util.List;


public class kullaniciyonetimi extends Fragment {
    List<User> userList;
    RecyclerView recyclerViewKY;
    UserListAdapter userListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_kullaniciyonetimi, container, false);
        recyclerViewKY=v.findViewById(R.id.recyclerViewKY);
        userListAdapter=new UserListAdapter(getActivity(),userList);
        recyclerViewKY.setAdapter(userListAdapter);
        return v;
    }



}
