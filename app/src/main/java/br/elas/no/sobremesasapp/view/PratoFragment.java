package br.elas.no.sobremesasapp.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.elas.no.sobremesasapp.R;
import br.elas.no.sobremesasapp.model.Cardapio;

import static br.elas.no.sobremesasapp.view.SobremesaFragment.CHAVE_SOBREMESA;

public class PratoFragment extends Fragment {
    private TextView textViewNomePrato;
    private ImageView imageViewImagemPrato;

    public PratoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prato, container, false);

        if (getArguments() != null){

            textViewNomePrato = view.findViewById(R.id.tview_desc_prato);
            imageViewImagemPrato = view.findViewById(R.id.image_prato);

            Bundle bundle = getArguments();
            Cardapio cardapio = bundle.getParcelable(CHAVE_SOBREMESA);

            textViewNomePrato.setText(cardapio.getNomePrato());
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = getResources().getDrawable(cardapio.getImagemPrato());
                imageViewImagemPrato.setImageDrawable(drawable);
            }
        }

        return view;
    }

}
