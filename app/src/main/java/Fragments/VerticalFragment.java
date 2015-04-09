package Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import boxofm.materialdesign.CardViewAdapter;
import boxofm.materialdesign.DividerDecoration;

/**
 * Created by Hasnain on 4/6/2015.
 */
public class VerticalFragment extends RecyclerFragment {

    private static final String TAG = "VerticalFragment";

    public static VerticalFragment newInstance() {
        Log.v(TAG, "newInstance()");
        VerticalFragment fragment = new VerticalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected RecyclerView.ItemDecoration getItemDecoration() {
        //We must draw dividers ourselves if we want them in a list
        return new DividerDecoration(getActivity());
    }

    protected CardViewAdapter getAdapter() {
        Log.v(TAG, "CardViewAdapter getAdapter()");
        return new CardViewAdapter();
    }
}
