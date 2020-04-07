package br.elas.no.sobremesasapp.model;
import android.os.Parcel;
import android.os.Parcelable;

public class Sobremesa implements Parcelable{
    private String nomeSobremesa;
    private String enderecoSobremesa;
    private String horarioSobremesa;
    private int imagemSobremesa;

    public Sobremesa(String nomeSobremesa, String enderecoSobremesa, String horarioSobremesa, int imagemSobremesa) {
        this.nomeSobremesa = nomeSobremesa;
        this.enderecoSobremesa = enderecoSobremesa;
        this.horarioSobremesa = horarioSobremesa;
        this.imagemSobremesa = imagemSobremesa;
    }

    public String getNomeSobremesa() { return nomeSobremesa; }

    public void setNomeSobremesa(String nomeSobremesa) { this.nomeSobremesa = nomeSobremesa; }

    public String getEnderecoSobremesa() { return enderecoSobremesa; }

    public void setEnderecoSobremesa(String enderecoSobremesa) { this.enderecoSobremesa = enderecoSobremesa; }

    public String getHorarioSobremesa() { return horarioSobremesa; }

    public void setHorarioSobremesa(String horarioSobremesa) { this.horarioSobremesa = horarioSobremesa; }

    public int getImagemSobremesa() { return imagemSobremesa; }

    public void setImagemSobremesa(int imagemSobremesa) { this.imagemSobremesa = imagemSobremesa; }


    protected Sobremesa(Parcel in) {
        nomeSobremesa = in.readString();
        enderecoSobremesa = in.readString();
        horarioSobremesa = in.readString();
        imagemSobremesa = in.readInt();
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
        dest.writeString(nomeSobremesa);
        dest.writeString(enderecoSobremesa);
        dest.writeString(horarioSobremesa);
        dest.writeInt(imagemSobremesa);
    }
}