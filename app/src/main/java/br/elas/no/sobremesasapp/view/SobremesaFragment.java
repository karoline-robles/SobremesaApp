package br.elas.no.sobremesasapp.view;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import br.elas.no.sobremesasapp.R;
import br.elas.no.sobremesasapp.adapter.RestauranteRecyclerViewAdapter;
import br.elas.no.sobremesasapp.model.Sobremesa;

public class SobremesaFragment extends Fragment {
    private RecyclerView recyclerView;
    private RestauranteRecyclerViewAdapter adapter;
    public static final String CHAVE_SOBREMESA = "sobremesas";

    public SobremesaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sobremesa, container, false);

        recyclerView = view.findViewById(R.id.rv_list_restaurante);
        adapter = new RestauranteRecyclerViewAdapter(getListaSoobremesa(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        return view;
    }

    public void enviaSobremesas( SobremesaFragment sobremesa) {
        CardapioFragment fragment = new CardapioFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE_SOBREMESA, (Parcelable) sobremesa);
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

    private List<Sobremesa> getListaSoobremesa() {
        List<Sobremesa> sobremesa = new ArrayList<>();

        sobremesa.add(new Sobremesa("Baccio di Latte", "Shopping Morumbi","Fecha às 22:00",R.drawable.im_bac));
        sobremesa.add(new Sobremesa("Senhor - Pudim", "Alameda dos Aicás, 471", "Fecha às 00:00",R.drawable.im_pud));
        sobremesa.add(new Sobremesa("Amor aos Pedaços", "R. Verbo Divino, 1467","Fecha às 00:00",R.drawable.im_am));
        sobremesa.add(new Sobremesa("YogoBerry", "R. Olimpíadas, 360", "Fecha às 01:00",R.drawable.im_yo));

        return sobremesa;
    }
}

