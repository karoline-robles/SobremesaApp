package br.elas.no.sobremesasapp.view;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import br.elas.no.sobremesasapp.R;
import br.elas.no.sobremesasapp.adapter.SobremesaRecyclerViewAdapter;
import br.elas.no.sobremesasapp.interfaces.SobremesaListener;
import br.elas.no.sobremesasapp.model.Sobremesa;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobremesaFragment extends Fragment implements SobremesaListener {
    private RecyclerView recyclerView;
    private SobremesaRecyclerViewAdapter adapter;
    public static final String CHAVE_RESTAURANTE = "restaurante";

    public SobremesaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sobremesa, container, false);

        recyclerView = view.findViewById(R.id.rv_list_restaurante);
        adapter = new SobremesaRecyclerViewAdapter(getListaRestaurantes(), this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        return view;
    }

    @Override
    public void enviaRestaurante(Sobremesa sobremesa) {
        Fragment fragment = new CardapioFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE_RESTAURANTE, sobremesa);
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

    private List<Sobremesa> getListaRestaurantes() {
        List<Sobremesa> sobremesa = new ArrayList<>();
        sobremesa.add(new Sobremesa("Baccio di Latte", "Shopping Morumbi","Fecha às 22:00",R.drawable.im_bac));
        sobremesa.add(new Sobremesa("Senhor - Pudim", "Alameda dos Aicás, 471", "Fecha às 00:00",R.drawable.im_pud));
        sobremesa.add(new Sobremesa("Amor aos Pedaços", "R. Verbo Divino, 1467","Fecha às 00:00",R.drawable.im_am));
        sobremesa.add(new Sobremesa("YogoBerry", "R. Olimpíadas, 360", "Fecha às 01:00",R.drawable.im_yo));

        return sobremesa;
    }
}
