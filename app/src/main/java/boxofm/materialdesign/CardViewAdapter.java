package boxofm.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Model.Card;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    private static final String TAG = "CardViewAdapter";
    private List<Card> cardList;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView textView;

        public CardViewHolder(View v) {
            super(v);
            Log.v(TAG, "CardViewHolder onBindViewHolder");
            imageView =  (ImageView) v.findViewById(R.id.imageView);
            textView = (TextView)  v.findViewById(R.id.info_text);
        }
    }

    public CardViewAdapter() {
        cardList = new ArrayList<Card>();
    }

    public List<Card> createList(int size, View view) {

        Log.v(TAG, "List<Card> createList");
        List<Card> result = new ArrayList<Card>();
        for (int i=1; i <= size; i++) {
            Card c = new Card();
            c.imageView = (ImageView) view.findViewById(R.id.imageView);
            c.textView = (TextView) view.findViewById(R.id.info_text);
            result.add(c);
        }
        return result;
    }

    /*public CardViewAdapter(List<Card> list) {
        this.cardList = list;
    }*/

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    @Override
    public void onBindViewHolder(CardViewHolder contactViewHolder, int i) {
        Log.v(TAG, "onBindViewHolder");
        contactViewHolder.imageView.setImageResource(R.drawable.dog);
        contactViewHolder.textView.setText("Hasnain " + i);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.v(TAG, "onCreateViewHolder");
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_main, viewGroup, false);
        return new CardViewHolder(itemView);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private void onItemHolderClick(CardViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getPosition(), itemHolder.getItemId());
        }
    }
}