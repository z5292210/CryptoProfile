package au.edu.unsw.infs3634.cryptoprofile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;

import au.edu.unsw.infs3634.cryptoprofile.api.Coin;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coin coin = Coin.getCoins().get(position);
        holder.tv1.setText(coin.getName());
        BigDecimal bigDecimal = new BigDecimal(coin.getPriceUsd());
        holder.tv2.setText("$" + bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        holder.tv3.setText(coin.getPercentChange1h() + "%");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailActivity(v,coin.getSymbol());
            }
        });
    }

    // Called when the user taps launch button
    public void launchDetailActivity(View view, String msg) {
        Intent intent = new Intent(view.getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, msg);
        view.getContext().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return Coin.getCoins().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);

        }
    }
}
