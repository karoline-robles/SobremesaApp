package br.elas.no.sobremesasapp.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.elas.no.sobremesasapp.R;
import br.elas.no.sobremesasapp.adapter.CardapioRecyclerViewAdapter;
import br.elas.no.sobremesasapp.interfaces.CardapioListener;
import br.elas.no.sobremesasapp.model.Cardapio;
import br.elas.no.sobremesasapp.model.Sobremesa;

import static br.elas.no.sobremesasapp.view.SobremesaFragment.CHAVE_RESTAURANTE;

public class CardapioFragment extends Fragment implements CardapioListener {
    private RecyclerView recyclerView;
    private CardapioRecyclerViewAdapter adapter;
    private TextView textViewNomeRestaurante;
    private ImageView imageViewImagemRestaurante;

    public CardapioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cardapio, container, false);

        if (getArguments() != null){

            textViewNomeRestaurante = view.findViewById(R.id.text_view_nome_rest);
            imageViewImagemRestaurante = view.findViewById(R.id.img_restaurante);

            Bundle bundle = getArguments();
            Sobremesa sobremesa = bundle.getParcelable(CHAVE_RESTAURANTE);

            textViewNomeRestaurante.setText(sobremesa.getNomeRestaurante());
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = getResources().getDrawable(sobremesa.getImagemRestaurente());
                imageViewImagemRestaurante.setImageDrawable(drawable);
            }
        }

        recyclerView = view.findViewById(R.id.rv_list_cardapio);
        adapter = new CardapioRecyclerViewAdapter(getListaCardapio(), this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;
    }

    @Override
    public void enviaCardapio(Cardapio cardapio) {
        Fragment fragment = new PratosFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE_RESTAURANTE, cardapio);
        fragment.setArguments(bundle);

        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit();
    }

    private List<Cardapio> getListaCardapio() {
        List<Cardapio> cardapios = new ArrayList<>();

//        cardapios.add(new Cardapio("Salada com Molho Gengibre",R.drawable.img_pratos));
//        cardapios.add(new Cardapio("Frango Grelhado",R.drawable.img_frango));
//        cardapios.add(new Cardapio("Omelete com Cogumelos",R.drawable.img_omelete));
//        cardapios.add(new Cardapio("Peixe Grelhado",R.drawable.img_peixe));
//        cardapios.add(new Cardapio("Salada com Molho Gengibre",R.drawable.img_pratos));
//        cardapios.add(new Cardapio("Frango Grelhado",R.drawable.img_frango));
//        cardapios.add(new Cardapio("Omelete com Cogumelos",R.drawable.img_omelete));
//        cardapios.add(new Cardapio("Peixe Grelhado",R.drawable.img_peixe));

        return cardapios;
    }

}
