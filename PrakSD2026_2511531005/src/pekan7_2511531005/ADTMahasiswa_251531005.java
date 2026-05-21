package pekan7_2511531005;


public class ADTMahasiswa_251531005 {

    //atribut
    private String nama_1005;
    private String nim_1005;
    private String prodi_1005;

    //konstruktor
    public ADTMahasiswa_251531005(String nama_1005, String nim_1005, String prodi_1005) {
        this.nama_1005 = nama_1005;
        this.nim_1005 = nim_1005;
        this.prodi_1005 = prodi_1005;
    }

    //getter 
    public String getNama_1005() {
        return nama_1005;
    }
    public String getNim_1005() {
        return nim_1005;
    }
    public String getProdi_1005() {
        return prodi_1005;
    }
    
    //setter
    public void setNama_1005(String nama_1005) {
        this.nama_1005 = nama_1005;
    }
    public void setNim_1005(String nim_1005) {
        this.nim_1005 = nim_1005;
    }
    public void setProdi_1005(String programStudi_1005) {
        this.prodi_1005 = programStudi_1005;
    }

   
    @Override
    public String toString() {
        return nama_1005 + " (" + nim_1005 + " - " + prodi_1005 + ")";
    }
}