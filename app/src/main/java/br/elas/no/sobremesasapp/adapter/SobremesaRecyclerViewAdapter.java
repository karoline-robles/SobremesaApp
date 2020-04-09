package br.elas.no.sobremesasapp.adapter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.elas.no.sobremesasapp.R;
import br.elas.no.sobremesasapp.interfaces.SobremesaListener;
import br.elas.no.sobremesasapp.model.Sobremesa;
import br.elas.no.sobremesasapp.view.SobremesaFragment;

public class SobremesaRecyclerViewAdapter extends RecyclerView.Adapter<SobremesaRecyclerViewAdapter.ViewHolder>{
    private List<Sobremesa> sobremesas;
    private SobremesaListener listener;

    public SobremesaRecyclerViewAdapter(List<Sobremesa> listaSobremesas, SobremesaFragment listener) {
        this.sobremesas = sobremesas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_sobremesa_recycler_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Sobremesa sobremesa = sobremesas.get(position);
        holder.onBind(sobremesa);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.enviaRestaurante(sobremesa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sobremesas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeSobremesa;
        private TextView enderecoSobremesa;
        private TextView horarioSobremesa;
        private ImageView imagemSobremesa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeSobremesa = itemView.findViewById(R.id.text_nome);
            enderecoSobremesa = itemView.findViewById(R.id.textEndereco);
            horarioSobremesa = itemView.findViewById(R.id.textHorario);
            imagemSobremesa = itemView.findViewById(R.id.image_restaurante);
        }

        public void onBind(Sobremesa sobremesa) {
            nomeSobremesa.setText(sobremesa.getNomeRestaurante());
            enderecoSobremesa.setText(sobremesa.getEnderecoRestaurante());
            horarioSobremesa.setText(sobremesa.getHorarioRestaurante());

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = itemView.getResources().getDrawable(sobremesa.getImagemRestaurente());
                imagemSobremesa.setImageDrawable(drawable);
            }
        }
    }
}