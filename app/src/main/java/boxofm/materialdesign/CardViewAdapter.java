package boxofm.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Model.Card;

/**
 * Created by Hasnain on 3/31/2015.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    private static final String TAG = "CardViewAdapter";
    private List<Card> cardList;

    public CardViewAdapter(List<Card> list) {
        this.cardList = list;
    }

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
}