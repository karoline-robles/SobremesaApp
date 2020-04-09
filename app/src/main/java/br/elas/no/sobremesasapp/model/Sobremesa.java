package br.elas.no.sobremesasapp.model;
import android.os.Parcel;
import android.os.Parcelable;


public class Sobremesa implements Parcelable {
    private String nomeRestaurante;
    private String enderecoRestaurante;
    private String horarioRestaurante;
    private int imagemRestaurente;

    public Sobremesa(String nomeRestaurante, String enderecoRestaurante, String horarioRestaurante, int imagemRestaurente) {
        this.nomeRestaurante = nomeRestaurante;
        this.enderecoRestaurante = enderecoRestaurante;
        this.horarioRestaurante = horarioRestaurante;
        this.imagemRestaurente = imagemRestaurente;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public Sobremesa(){};

    public String getEnderecoRestaurante() {
        return enderecoRestaurante;
    }

    public void setEnderecoRestaurante(String enderecoRestaurante) {
        this.enderecoRestaurante = enderecoRestaurante;
    }

    public String getHorarioRestaurante() {
        return horarioRestaurante;
    }

    public void setHorarioRestaurante(String horarioRestaurante) {
        this.horarioRestaurante = horarioRestaurante;
    }

    public int getImagemRestaurente() {
        return imagemRestaurente;
    }

    public void setImagemRestaurente(int imagemRestaurente) {
        this.imagemRestaurente = imagemRestaurente;
    }

    protected Sobremesa(Parcel in) {
        nomeRestaurante = in.readString();
        enderecoRestaurante = in.readString();
        horarioRestaurante = in.readString();
        imagemRestaurente = in.readInt();
    }

    public static final Creator<Sobremesa> CREATOR = new Creator<Sobremesa>() {
        @Override
        public Sobremesa createFromParcel(Parcel in) {
            return new Sobremesa(in);
        }

        @Override
        public Sobremesa[] newArray(int size) {
            return new Sobremesa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeRestaurante);
        dest.writeString(enderecoRestaurante);
        dest.writeString(horarioRestaurante);
        dest.writeInt(imagemRestaurente);
    }
}
