package dev.proj.colorspallet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ColorsAdapater extends RecyclerView.Adapter<ColorsAdapater.ColorsHolder>{
    private Context context;
    private List<Integer> dataColors;

    public ColorsAdapater(Context context, List<Integer> dataColors) {
        this.context = context;
        this.dataColors = dataColors;
    }

    @NonNull
    @Override
    public ColorsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.color_items, viewGroup, false);
        return new ColorsHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorsHolder colorsHolder, int i) {
        colorsHolder.imageColors.setBackgroundColor(dataColors.get(i));
    }

    @Override
    public int getItemCount() {
        return dataColors.size();
    }

    class ColorsHolder extends RecyclerView.ViewHolder{
        ImageView imageColors;
        public ColorsHolder(@NonNull View itemView) {
            super(itemView);
            imageColors = itemView.findViewById(R.id.colorItems);
        }
    }
}
